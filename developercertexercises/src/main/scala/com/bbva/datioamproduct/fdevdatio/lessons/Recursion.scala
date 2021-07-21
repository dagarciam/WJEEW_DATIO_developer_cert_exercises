package com.bbva.datioamproduct.fdevdatio.lessons

class Recursion {

  def apply(): Unit = {
    println(f(4))
    println(tailF(4))

    val list = List(2, 4, 6, 9, 14, 40, 67)
    println(
      binarySearch(list, 5)
    )
    println(
      binarySearch(list, 40)
    )
    println(
      binarySearch(list, 67)
    )
  }

  /**
   *
   * @param n = 4
   * @return 4*3*2*1
   *         1! = 1
   *         0! = 1
   */
  def f(n: Long): Long = {
    n match {
      case 0 | 1 => 1
      case _ => n * f(n - 1)
    }
  }

  /**
   * n=4 -> 4*f(3) -> f(4)*f(3)*f(2)*f(1)
   * n=3 -> 3*f(2)
   * n=2 -> 2*f(1)
   * n=1 -> 1
   */


  /**
   *
   * @param n = 4
   * @return 4*3*2*1
   *         1! = 1
   *         0! = 1
   */
  def tailF(n: Long, r: Long = 1): Long = {
    n match {
      case 0 | 1 => r
      case _ => tailF(n - 1, n * r)
    }
  }

  /**
   * n=4, r=1 -> f(3, 4)
   * n=3, r=4 -> f(2,12)
   * n=2, r=12 -> f(1, 24)
   * n=1, r=24 -> 24
   */

  /** TODO:
   * Implementar un método recursivo de cola que reciba una lista de enteros
   * y retorne el entero más grande (opcional: y también el valor más pequeño)
   * def f(list:List[Int]):(Int, Int)
   * */


  def f(list: List[Int]): Unit = {
    list match {
      case Nil => println("Fin de la lista")
      case cabeza :: cola => {
        println(cabeza)
        f(cola)
      }
    }
  }

  def f1(list: List[Int]): Unit = {
    if (list.nonEmpty) {
      //Imprime la cabeza de la lista (Elemento 0)
      println(list.head)
      //Manda llamar a la misma función pero con una lista nueva que consta de los elementos 1 al final
      f1(list.tail)
    }
  }

  // llamar a f con List(1,4,2,5,8)
  // imprimir 1
  // llamar a f con List(4,2,5,8)
  // imprimir 4
  // llamar a f con List(2,5,8)
  //imprimir 2
  // llamar a f con List(5,8)


  /**
   * Conocer los casos base (son las casuisticas en donde conocermos el resultado)
   * Se apoya de variables que contienen el resultado
   * No encola llamados para realizar operaciones
   * Encola llamados y les pasa el resultado de la operación
   */

  /**
   * Implementar una función recursiva
   * que entregue en el menor número de llamados un elemento buscado en una lista ordenada
   * -> Búsqueda binaria
   * list = List(2, 4, 6, 9, 14, 40, 67)
   * vamos a buscar n = 40
   * tamaño de la lista entre 2
   * 7/2 = 3
   * comparamos el número en la posición 3 de la lista con el que estamos buscando
   * list(3) -> 9
   * n == list(3) (40 == 9) -> "Encontrado"
   * n < list(3) (40 < 9) -> volver a llamar al método con la primera mitad list[:3]
   * n > list(3) (40 > 9) -> volver a llamar al método con la segunda mitad list[3:]
   * list = List(9,14,40,67)
   * list(2) -> 40
   * n == list(2) (40 == 40) -> "Encontrado"
   */
  def binarySearch(list: List[Int], n: Int, j: Int = 0): String = {
    list match {
      case Nil => "Elemento no encontrado"
      case _ if n == list(list.size / 2) => "Encontrado"
      case _ if n > list(list.size / 2) => binarySearch(list.slice((list.size / 2) + 1, list.size), n, j + 1)
      case _ if n < list(list.size / 2) => binarySearch(list.slice(0, list.size / 2), n, j + 1)
    }
  }


}
