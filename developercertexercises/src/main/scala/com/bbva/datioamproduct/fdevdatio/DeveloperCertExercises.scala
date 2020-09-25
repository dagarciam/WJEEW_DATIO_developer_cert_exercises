package com.bbva.datioamproduct.fdevdatio

import com.datio.spark.InitSpark
import com.datio.spark.metric.model.BusinessInformation
import com.typesafe.config.Config
import org.apache.spark.sql.SparkSession

/**
  * Main file for DeveloperCertExercises process.
  * Implements InitSpark which includes metrics and SparkSession.
  *
  * Configuration for this class should be expressed in HOCON like this:
  *
  * DeveloperCertExercises {
  *   ...
  * }
  *
  */
protected trait DeveloperCertExercisesTrait extends InitSpark {
  this: InitSpark =>
    /**
      * @param spark Initialized SparkSession
      * @param config Config retrieved from args
      */
    override def runProcess(spark : SparkSession, config : Config): Int = {

      this.logger.info("Init process DeveloperCertExercises")
      val prueba = new Prueba
      this.logger.info("Hola mundo!")
      val exitCode = 0

      exitCode

    }

  override def defineBusinessInfo(config: Config): BusinessInformation =
    BusinessInformation(exitCode = 0, entity = "", path = "", mode = "",
                        schema = "", schemaVersion = "", reprocessing = "")

}

object DeveloperCertExercises extends DeveloperCertExercisesTrait with InitSpark

