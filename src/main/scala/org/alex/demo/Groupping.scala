package org.alex.demo

object Groupping extends App {
  val words = Array("Mary", "had", "a", "little", "lamb", "its", "fleece", "was", "white",
    "as", "snow", "and", "everywhere", "that", "Mary", "went", "the", "lamb", "was", "shure", "to", "go")

  private val map = words.groupBy(_.substring(0, 1))
  private val map2 = words.groupBy(_.length)
  println("bau")
}
