package com.bbva.datioamproduct.fdevdatio.lessons.inheritance

import com.typesafe.scalalogging.LazyLogging

object Runner extends LazyLogging {

  def main(args: Array[String]): Unit = {
    val moltres: Moltres = new Moltres(height = 6.6, name = "Fire Chicken")

    logger.info(moltres.getName(upperCase = true))

  }

}