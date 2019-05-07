@ActivateSegment
Feature: Feature for DeveloperCertExercises

  Scenario: Test DeveloperCertExercises should result OK
    Given a config file path in HDFS hdfs://hadoop:9000/DeveloperCertExercises.conf
    When execute DeveloperCertExercises in Spark
    Then should send metrics to Kafka with key DeveloperCertExercises-test
    And should have 0 lines written and 0 lines readed

  Scenario Outline: Test custom implementations result OK
    Given a config file path in HDFS hdfs://hadoop:9000/<pathConfig>.conf
    When execute DeveloperCertExercises in Spark
    Then should send metrics to Kafka with key DeveloperCertExercises-test
    And should have <linesWritten> lines written and <linesRead> lines readed

      Examples:
        | pathConfig     | linesWritten | linesRead |
        | DeveloperCertExercises | 0            | 0         |

