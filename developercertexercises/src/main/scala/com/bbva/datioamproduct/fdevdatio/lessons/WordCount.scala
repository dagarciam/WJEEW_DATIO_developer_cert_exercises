package com.bbva.datioamproduct.fdevdatio.lessons

import com.bbva.datioamproduct.fdevdatio.common.ConfigConstants.BOOKS_TXT_PATH_CONFIG
import com.typesafe.config.Config
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

class WordCount(sc: SparkContext, config: Config) {
  val rdd: RDD[String] = sc.textFile(config.getString(BOOKS_TXT_PATH_CONFIG))

  def apply(): Unit = {
    val x = rdd
      .flatMap(
        line => line
          .replace(",", "")
          .replace(".", "")
          .toLowerCase
          .split(" ")
      ) // map -> RDD[Array[String]] vs flatMap RDD[String]
      .filter(_.size > 4)
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      .reduce((a, b) => {
        if (a._2 > b._2) {
          a
        } else {
          b
        }
      })
    //.reduceByKey((a, b) => a + b)

    println(x)

  }

}
