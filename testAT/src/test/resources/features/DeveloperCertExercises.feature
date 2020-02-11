@developercertexercises
Feature: Feature for DeveloperCertExercises

  Scenario: Test DeveloperCertExercises should result OK
    Given a config file in path src/test/resources/config/application.conf
    When execute main class com.bbva.datioamproduct.fdevdatio.DeveloperCertExercises in Spark
    Then exit code is equal to 0
    When example custom rule with parameter
