package com.bbva.datioamproduct.fdevdatio

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array
  (
    "src/test/resources/features/DeveloperCertExercises.feature"
  ),
  glue = Array("com.datio.spark.bdt.steps", "com.bbva.datioamproduct.fdevdatio.developercertexercises"),
  plugin = Array(
    "pretty"
  ),
  tags = Array("~@ignore")
)
class RunCukesTest
