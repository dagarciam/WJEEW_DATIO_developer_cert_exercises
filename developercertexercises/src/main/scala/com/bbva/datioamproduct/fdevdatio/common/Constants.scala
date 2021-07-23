package com.bbva.datioamproduct.fdevdatio.common

import scala.util.matching.Regex

object Constants {
  //val SayHi: String = "Hola mundo desde la clase Lesson1"
  val SAY_HI: String = "Hola mundo desde la clase Lesson1"
  val BOOK_REGEX: Regex = """(\d+)\,(.+)\,(.+)\,(\d\.\d+)\,(.+)\,(\d+)\,(.+)\,(\d+)\,(\d+)\,(\d+)\,(\d+/\d+/\d{4})\,(.+)""".r

  val SUCCESS_EXITCODE: Int = 0
  val FAILURE_EXITCODE: Int = -1

  val CUTOFF_DATE_INITIAL_BOUND = "2020-03-01"
  val CUTOFF_DATE_FINAL_BOUND = "2020-03-04"
  val CREDIT_CARD_NUMBER_FILTER = 17

  val BRAND_FILTER = List("Dell", "Coolpad", "Chea", "BQ", "BLU")
  val COUNTRY_CODE_FILTER = List("CH", "IT", "CZ", "DK")

  case object JoinTypes {
    val inner: String = "inner"
    val left: String = "left"
  }

}
