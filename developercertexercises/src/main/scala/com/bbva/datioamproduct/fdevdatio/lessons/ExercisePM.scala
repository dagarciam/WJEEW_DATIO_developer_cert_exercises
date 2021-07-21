package com.bbva.datioamproduct.fdevdatio.lessons

import com.typesafe.scalalogging.LazyLogging

class ExercisePM extends LazyLogging {

  val pricing: List[(String, String, Double)] = List(
    ("México", "PS5", 14000.0),
    ("Perú", "iPhone 12", 7395.28)
  )

  val currency: Map[String, String] = Map(
    "México" -> "MXN",
    "Perú" -> "SOL"
  )

  val toUSD: Map[String, Double] = Map(
    "MXN" -> 19.89,
    "SOL" -> 5.0
  )

  /** Todo:
   * Implementar con la función map un algoritmo que retorne la lista de items comprados
   * con su valor en dolares
   * UTILIZAR PATTERN MATCHING
   * */

  def apply(): Unit = {
    pricing.map(
      item => {
        val exchangeValue: Double = item._1 match {
          case "México" => 19.89
          case "Perú" => 3.97
        }
        (item._2, item._3 / exchangeValue)
      }
    ).foreach(println)
  }

  def exampleMap(): Unit = {
    val list: List[Int] = List(1, 4, 5, 7, 8, 3)


    list.map {
      case (n: Int) if n % 2 == 0 => 0
      case (_: Int) => 1
    }.foreach(println)

    list.map(n => {
      n match {
        case (n: Int) if n % 2 == 0 => 0
        case (_: Int) => 1
      }
    }).foreach(println)

  }

}
