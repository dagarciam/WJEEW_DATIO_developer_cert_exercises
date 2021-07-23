package com.bbva.datioamproduct.fdevdatio.common

import org.apache.spark.sql.DataFrame

object ConfigConstants {

  val ROOT_CONFIG: String = "SparkJob"
  val INPUT_CONFIG: String = s"$ROOT_CONFIG.input"
  val CUSTOMERS_CONFIG = s"$INPUT_CONFIG.customers"
  val PHONES_CONFIG = s"$INPUT_CONFIG.phones"


  //----------------------------< OLD CONSTANTS >-----------------------------------------------------//
  val DEV_CONFIG: String = s"$ROOT_CONFIG.dev"

  val DEV_NAME_CONFIG: String = s"$DEV_CONFIG.dev_name"
  val DEV_AGE_CONFIG: String = s"$DEV_CONFIG.dev_age"
  val DEV_GENDER_CONFIG: String = s"$DEV_CONFIG.dev_gender"


  val BOOKS_CONFIG: String = s"$INPUT_CONFIG.books"
  val BOOKS_PATH_CONFIG: String = s"$BOOKS_CONFIG.path"

  val BOOKS_TXT_CONFIG: String = s"$INPUT_CONFIG.books_txt"
  val BOOKS_TXT_PATH_CONFIG: String = s"$BOOKS_TXT_CONFIG.path"

}
