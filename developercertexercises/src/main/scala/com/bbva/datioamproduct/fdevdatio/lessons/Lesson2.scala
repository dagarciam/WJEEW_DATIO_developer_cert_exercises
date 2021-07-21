package com.bbva.datioamproduct.fdevdatio.lessons

import com.typesafe.scalalogging.LazyLogging

import scala.collection.mutable

class Lesson2 extends LazyLogging {

  val populationMap: mutable.Map[String, Int] = mutable.Map(
    "Perú" -> 32000000,
    "España" -> 47000000,
    "México" -> 127000000,
    "Brasil" -> 211000000,
    "Japón" -> 126000000
  )

  val extensionMap: mutable.Map[String, Int] = mutable.Map(
    "Perú" -> 1285000,
    "España" -> 505990,
    "México" -> 1973000,
    "Brasil" -> 8516000,
    "Japón" -> 3777975
  )

  def run(): Unit = {
    val countries: List[String] = List("Perú", "España", "México", "Brasil", "Japón")
    val densityMap: Map[String, Double] = getDensityMap(countries: _*)

    densityMap.foreach(println)
    //densityMap.foreach(item => println(item))

    countries.foreach(country => {
      val capital: String = examplePatterMatching(country)
      logger.info(capital)
    })

    val items: List[Any] = List(1, 6f, 54.0, 44.0, "Hola", 56L)

    items.foreach(examplePatterMatching2)
  }

  /** Transformación -> Es aquella operación que a partir de un conjunto(RDD, DataFrame)
   * de datos genera otro conjunto(RDD, Dataframe) de datos */

  /**
   *
   * @param countries es una colección de paises
   * @return un mapa con la densidad poblacional de cada país
   */
  def getDensityMap(countries: String*): Map[String, Double] = {
    countries.map(county => {
      val population: Int = populationMap(county)
      val extension: Int = extensionMap(county)
      val density: Double = population.toDouble / extension

      (county, density)
    })
      .toMap
  }

  /**
   * @param country
   * @return la capital del pais
   */
  def examplePatterMatching(country: String): String = {
    country match {
      case "España" => "Madrid"
      case "México" => "CDMX"
      case "Perú" => "Lima"
      case "Brasil" => "Brasilia"
      case "Japón" => "Tokio"
      case _ => s"No se conoce la capital del país $country"
    }
  }

  /**
   *
   * @param value is a Any type
   * @return example for match by Class, Value and Conditions
   */
  def examplePatterMatching2(value: Any): Unit = {
    value match {
      case 54.0 => logger.info("Es un número double y es cincuenta y cuatro punto cero")
      case _: Double => logger.info("Es un número double")
      case _: Int => logger.info("Es un número entero")
      case _: Float => logger.info("Es un número float")
      case _: String => logger.info("Es una cadena de caracteres")
      case _ if value.asInstanceOf[Long] > 10L => logger.info(s"$value  Es un Long mayor a 10L")
      case _ => logger.info("Es un objeto desconocido")
    }

  }


}
