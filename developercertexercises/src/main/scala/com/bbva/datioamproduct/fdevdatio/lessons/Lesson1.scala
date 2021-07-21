package com.bbva.datioamproduct.fdevdatio.lessons

import com.bbva.datioamproduct.fdevdatio.common.Constants._
import com.bbva.datioamproduct.fdevdatio.common.ConfigConstants._
import com.typesafe.config.Config
import com.typesafe.scalalogging.LazyLogging
import scala.collection.mutable

class Lesson1(config: Config) extends LazyLogging {

  //val sayHi:String = "Hola mundo desde la clase Lesson1"

  val populationMap: mutable.Map[String, Int] = mutable.Map("Perú" -> 32000000,
    "España" -> 47000000,
    "México" -> 127000000,
    "Brasil" -> 211000000,
    "Japón" -> 126000000
  )

  def method(x: Any): Unit = {
    logger.info(s"Hola $x")
  }

  def apply(): Unit = {
    logger.info(SAY_HI)
    val devName: String = config.getString(DEV_NAME_CONFIG)
    val devAge = config.getInt(DEV_AGE_CONFIG)
    val devGender: String = config.getString(DEV_GENDER_CONFIG)

    logger info {
      s"dev_name: $devName\ndev_age: $devAge\ndev_gender: $devGender"
    }

    val countries: List[String] = List("Perú", "España", "México", "Japón")
    val countries2: List[String] = List("Rusia", "Corea")

    populationMap.put("Rusia", 144000000)
    populationMap.put("Corea", 51000000)
    populationMap.put("Canada", 57000000)
    populationMap.remove("Brasil")

    //Concatenar Listas
    val countries3: List[String] = countries ++ countries2

    //Concatenar un elemento a una lista
    val countries4: List[String] = countries3 :+ "Canada"

    val returnedMap: mutable.Map[String, Double] = printList(countries4: _*)

    logger.info(returnedMap.toString())
  }

  def example(lesson: Lesson1, x: Int, y: Int): AnyRef = {
    if (x > y) {
      lesson
    } else {
      List(1, 5, 3, 4)
    }
  }

  def printList(list: String*): mutable.Map[String, Double] = {

    val densityMap: mutable.Map[String, Double] = mutable.Map()

    list.foreach(country => {
      val population: Int = populationMap(country)
      val area: Double = 1200
      val density: Double = population / area

      logger.info(s">> $country, $density")
      densityMap.put(country, density)

    })
    densityMap
  }

  /** TODO:
   * Crear un Map con la extensión territorial de los paises
   * Calculen la densidad poblacional por km^2
   * Crear un método que retorne un Map que contenga el país y la densidad poblacional
   * */


  def printList(list: List[String]): Unit = {
    list.foreach(country => {
      logger.info(s"_> $country")
    })
  }
}


