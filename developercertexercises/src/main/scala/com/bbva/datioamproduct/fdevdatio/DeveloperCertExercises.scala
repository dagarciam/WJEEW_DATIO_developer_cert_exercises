package com.bbva.datioamproduct.fdevdatio

import com.bbva.datioamproduct.fdevdatio.lessons.{ExercisePM, Lesson1, Lesson2, RDDs, Recursion, WordCount}
import com.datio.spark.InitSpark
import com.datio.spark.metric.model.BusinessInformation
import com.typesafe.config.Config
import org.apache.spark.sql.SparkSession
import com.bbva.datioamproduct.fdevdatio.common.Constants.{FAILURE_EXITCODE, SUCCESS_EXITCODE}
import com.bbva.datioamproduct.fdevdatio.engine.AmazonAnalitycs
import org.apache.spark.SparkContext

import scala.util.{Failure, Success, Try}

/**
 * Main file for DeveloperCertExercises process.
 * Implements InitSpark which includes metrics and SparkSession.
 *
 * Configuration for this class should be expressed in HOCON like this:
 *
 * DeveloperCertExercises {
 * ...
 * }
 *
 */
protected trait DeveloperCertExercisesTrait extends InitSpark {
  this: InitSpark =>
  /**
   * @param spark  Initialized SparkSession
   * @param config Config retrieved from args
   */
  override def runProcess(spark: SparkSession, config: Config): Int = {

    Try {
      val engine: AmazonAnalitycs = new AmazonAnalitycs(config)(spark)
      engine()
    } match {
      case Success(_) => SUCCESS_EXITCODE
      case Failure(exception) => {
        exception.printStackTrace()
        FAILURE_EXITCODE
      }
    }

  }

  override def defineBusinessInfo(config: Config): BusinessInformation =
    BusinessInformation(exitCode = 0, entity = "", path = "", mode = "",
      schema = "", schemaVersion = "", reprocessing = "")

}

object DeveloperCertExercises extends DeveloperCertExercisesTrait with InitSpark
