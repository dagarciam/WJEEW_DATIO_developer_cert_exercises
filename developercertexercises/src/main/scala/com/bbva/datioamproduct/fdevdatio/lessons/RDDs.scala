package com.bbva.datioamproduct.fdevdatio.lessons

import com.typesafe.config.Config
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import com.bbva.datioamproduct.fdevdatio.common.ConfigConstants.BOOKS_PATH_CONFIG
import com.bbva.datioamproduct.fdevdatio.common.Constants.BOOK_REGEX

class RDDs(sc: SparkContext, config: Config) {

  val rdd: RDD[String] = sc.textFile(config.getString(BOOKS_PATH_CONFIG))

  def transformToBooks(rdd: RDD[String]): RDD[Book] = {
    rdd
      .filter(
        line => BOOK_REGEX.pattern.matcher(line).matches
      )
      .map(_.split(",").toList)
      .map(list => {
        list.size match {
          case 12 => Book(
            list.head.toInt, list(1), list(2), list(3).toDouble, list(4),
            list(5).toLong, list(6), list(7).toInt, list(8).toInt, list(9).toInt, list(10), list(11)
          )
          case 13 => {
            Book(
              list.head.toInt, list(1), s"${list(2)}, ${list(3)}", list(4).toDouble,
              list(5), list(6).toLong, list(7), list(8).toInt, list(9).toInt, list(10).toInt, list(11), list(12)
            )
          }
        }
      })
  }

  def getTotalAverageRating(rdd: RDD[Book]): Double = {
    val sumAverageRating: Double = rdd
      // Transformo RDD[Book] a RDD[Double] quedandonos únicamente con el atributo averageRating
      .map(
        _.ratingsCount.toDouble
      )
      // Aplico una función reduce que realiza una operación entre dos registros
      .reduce((a: Double, b: Double) => {
        a + b
      })
    sumAverageRating / rdd.count()
  }

  def getShortestBook(rdd: RDD[Book]): Book = {
    rdd
      .filter(_.numPages > 0)
      .reduce((a, b) => {
        if (a.numPages < b.numPages) {
          a
        } else {
          b
        }
      })
  }

  def booksByYear(rdd: RDD[Book]): RDD[(Int, Int)] = {
    rdd
      .map(book => {
        val year: Int = book.publicationDate.split("/")(2).toInt
        (year, 1)
      })
      // (a:Int, b:Int):Int **No entran las llaves a la operación de reduce
      .reduceByKey((a, b) => {
        a + b
      })
  }

  def apply(): Unit = {
    val rddBooks: RDD[Book] = transformToBooks(rdd)
    val totalAverageRating: Double = getTotalAverageRating(rddBooks)
    val shortestBook: Book = getShortestBook(rddBooks)

    val countByYear: RDD[(Int, Int)] = booksByYear(rddBooks)

    // todo: obtener el libro con menor número de páginas
    // todo: obtener el promedio de el atributo ratingsCount para toda nuestra colección
    //reduceByKey Entrega un resultado por cada llave generada (la llave se genera en un map previo)

    // Todo: Implementar un método que devuelva la palabra más repetida en los titulos de los libros
    // Todo: Implementar uno o varios métodos que devuelvan el promedio de ratingsCount agrupado por Año y Mes
    //(2016 / 07, 2400)

    ratingCountByYear(rddBooks)
      .foreach(println)

    wordCount(rddBooks)
      //.take(100)
      .foreach(println)


  }

  def ratingCountByYear(rdd: RDD[Book]): RDD[(String, Double)] = {
    rdd.map(book => {
      val year: Int = book.publicationDate.split("/")(2).toInt
      val month: Int = book.publicationDate.split("/")(0).toInt
      (s"$year/$month", (book.ratingsCount.toLong, 1.0))
    })
      .reduceByKey((a, b) => {
        (a._1 + b._1, a._2 + b._2)
      })
      .map {
        case (key: String, (ratingCount: Long, n: Double)) => (key, ratingCount / n)
      }
  }

  def wordCount(rdd: RDD[Book]): RDD[(String, Int)] = {
    rdd
      .flatMap(book => {
        book
          .title
          .replaceAll("""\W""", " ")
          .toLowerCase
          .split(" ")
      })
      .filter(_.size > 3)
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      .coalesce(1)
      .sortBy(_._2, ascending = false)
  }


}
