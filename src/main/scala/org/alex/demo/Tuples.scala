package org.alex.demo

object Tuples extends App {
  private val part = "New York".partition(_.isUpper)
  private val part1 = List(1, 2, 3, 4, 5).partition(_ % 2 == 0)
  println(part)
  println(part1)

  private val numbers = List(2, -8, 9, 10, -345, -89, 74, -11, 45, 23, -99, 1)
  private val (neg, pos) = numbers.partition(_ < 0)
  private val filtered = if(neg.isEmpty) pos else neg.head :: pos
  println(filtered)

  val symbols = Array("<", "-", ">")
  val counts = Array(2, 10, 2)
  private val pairs = symbols.zip(counts)

  for ((left, right) <- pairs) {
    print(left * right)
  }
}
