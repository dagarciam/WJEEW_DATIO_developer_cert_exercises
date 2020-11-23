package com.bbva.datioamproduct.fdevdatio.dataframe

class ExerciseDf {
  def realState(): Unit = {
    /* Create a Spark program to read the house data from RealEstate.csv,
         group by location, aggregate the average price per SQ Ft and sort by average price per SQ Ft.

      The houses dataset contains a collection of recent real estate listings in San Luis Obispo county and
      around it. 

      The dataset contains the following fields:
      1. MLS: Multiple listing service number for the house (unique ID).
      2. Location: city/town where the house is located. Most locations are in San Luis Obispo county and
      northern Santa Barbara county (Santa Maria­Orcutt, Lompoc, Guadelupe, Los Alamos), but there
      some out of area locations as well.
      3. Price: the most recent listing price of the house (in dollars).
      4. Bedrooms: number of bedrooms.
      5. Bathrooms: number of bathrooms.
      6. Size: size of the house in square feet.
      7. Price/SQ.ft: price of the house per square foot.
      8. Status: type of sale. Thee types are represented in the dataset: Short Sale, Foreclosure and Regular.

      Each field is comma separated.

      Sample output:

      +----------------+-----------------+
      |        Location| avg(Price SQ Ft)|
      +----------------+-----------------+
      |          Oceano|             95.0|
      |         Bradley|            206.0|
      | San Luis Obispo|            359.0|
      |      Santa Ynez|            491.4|
      |         Cayucos|            887.0|
      |................|.................|
      |................|.................|
      |................|.................|
       */
  }

  def netflix(): Unit = {

    // DATAFRAME PROJECT
    // Use the Netflix_2011_2016.csv file to Answer and complete
    // the commented tasks below!

    // Start a simple Spark Session

    // Load the Netflix Stock CSV File, have Spark infer the data types.

    // What are the column names?

    // What does the Schema look like?

    // Print out the first 5 columns.

    // Use describe() to learn about the DataFrame.

    // Create a new dataframe with a column called HV Ratio that
    // is the ratio of the High Price versus volume of stock traded
    // for a day.

    // What day had the Peak High in Price?

    // What is the mean of the Close column?

    // What is the max and min of the Volume column?

    // For Scala/Spark $ Syntax

    // How many days was the Close lower than $ 600?

    // What percentage of the time was the High greater than $500 ?

    // What is the Pearson correlation between High and Volume?

    // What is the max High per year?

    // What is the average Close for each Calender Month?

  }

}
