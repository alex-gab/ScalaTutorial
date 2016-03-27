package org.alex.demo

import java.net.URL
import java.util.Scanner

object Alice extends App {
  private val in = new Scanner(new URL("http://horstmann.com/presentations/livelessons-scala-2016/alice30.txt").openStream())

  private var count = Map[String, Int]()

  while (in.hasNext) {
    val word = in.next()
    count = count + (word -> (count.getOrElse(word, 0) + 1))
  }

  println(count("Alice"))
  println(count("Rabbit"))
}
