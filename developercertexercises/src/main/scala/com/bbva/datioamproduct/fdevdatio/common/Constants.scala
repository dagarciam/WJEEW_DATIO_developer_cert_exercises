package com.bbva.datioamproduct.fdevdatio.common

import scala.util.matching.Regex

object Constants {
  //val SayHi: String = "Hola mundo desde la clase Lesson1"
  val SAY_HI: String = "Hola mundo desde la clase Lesson1"
  val BOOK_REGEX: Regex = """(\d+)\,(.+)\,(.+)\,(\d\.\d+)\,(.+)\,(\d+)\,(.+)\,(\d+)\,(\d+)\,(\d+)\,(\d+/\d+/\d{4})\,(.+)""".r

  val SUCCESS_EXITCODE: Int = 0
  val FAILURE_EXITCODE: Int = -1

}
