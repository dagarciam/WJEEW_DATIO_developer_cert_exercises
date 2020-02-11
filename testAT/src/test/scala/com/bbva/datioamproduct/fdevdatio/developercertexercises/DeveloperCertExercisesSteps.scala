package com.bbva.datioamproduct.fdevdatio.developercertexercises

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

class DeveloperCertExercisesSteps extends Matchers with ScalaDsl with EN {

  When("""^example custom rule with (.*)$""") {
    parameter: String => assert(parameter == "parameter")
  }

}
