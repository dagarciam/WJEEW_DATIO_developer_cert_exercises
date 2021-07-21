package com.bbva.datioamproduct.fdevdatio.lessons.inheritance

/** Abstract Class se utilizan para definir el MVP de una clase
 * El layout de la clase que lo implemente
 * Las abstract class normalmente no llevan implementación, sólo firmas
 */
abstract class Pokemon {
  val name: String
  val pokemonType: List[String]
  val attacks: List[String]

  val weight: Double
  val height: Double

  def attack(): Unit
}
