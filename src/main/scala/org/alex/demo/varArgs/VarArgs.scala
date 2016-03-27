package org.alex.demo.varArgs

import scala.annotation.tailrec

object VarArgs extends App {

  def sum(args: Int*) = {
    @tailrec
    def sumHelper(seq: Seq[Int], sum: Int, index: Int): Int = {
      if (index == seq.length) {
        sum
      } else {
        sumHelper(seq, sum + seq(index), index + 1)
      }
    }

    sumHelper(seq = args, sum = 0, index = 0)
  }

  private val seq: Seq[Int] = 1 to 4

  private val sum: Int = sum(seq: _*)
  println(sum)

}
