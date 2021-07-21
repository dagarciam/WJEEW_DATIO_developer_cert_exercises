package com.bbva.datioamproduct.fdevdatio.lessons.inheritance

/** Un trait define comportamiento de alguna clase, contiene implementaciones
 * de métodos y atributos que vuelven peculiar a la clase que lo hereda */
trait Fire {
  def fireBlast(): Unit = {
    println("ataque -> Lanzallamas")
  }
}
