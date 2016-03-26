package org.alex.demo

import scala.util.Random

class Person(private val name: String, private val age: Int) {
  override def toString = s"Person($name, $age)"
}


object Hello extends App {
  println("Hello World")

  private val names: List[String] = List("Alice", "Bob", "Carol", "Dave", "Eve", "Frank")

  names map (_.toUpperCase()) filter (_.length > 5)
  names.mkString(",")

  private val persons: List[Person] = for (name <- names) yield {
    val age = (Random.nextGaussian() * 8 + 20).toInt
    new Person(name, age)
  }

  private val first: Single.type = Single.newInstance("caca")
  private val second: Single.type = Single newInstance "pipi"

  println(first)

  private val z: Complex = new Complex(2, 4)
  z.re
}
