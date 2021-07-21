package com.bbva.datioamproduct.fdevdatio.lessons.inheritance

/** Para que yo pueda instanciar una clase abstracta o trait debe hacerse mediante herencia */
class Moltres(override val name: String, override val height: Double, override val weight: Double) extends Pokemon with Fire {

  override val pokemonType: List[String] = List("Fire", "Flyer")
  override val attacks: List[String] = List("Sky attack", "fireBlast")

  override def attack(): Unit = {
    println("ataque -> Sky Attack")
  }

  // String, Double => Moltres
  def this(name: String, height: Double) = this(name, height, 132.277)

  // Double, String => Moltres
  def this(weight: Double = 132.277, name: String) = this(name, 6.56168, weight)

  def getName(upperCase: Boolean = false, lowerCase: Boolean = false): String = {
    if (upperCase) {
      name.toUpperCase
    } else if (lowerCase) {
      name.toLowerCase
    } else {
      name
    }
  }

}