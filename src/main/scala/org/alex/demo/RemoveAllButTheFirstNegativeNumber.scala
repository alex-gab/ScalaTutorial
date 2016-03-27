package org.alex.demo

import scala.annotation.tailrec
import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

object RemoveAllButTheFirstNegativeNumber extends App {

  def indicesForNegatives(numbers: ArrayBuffer[Int]) = {
    for (i <- numbers.indices if numbers(i) < 0) yield i
  }

  def removeAllButTheFirstNegativeNumber0(numbers: ArrayBuffer[Int]) = {
    val indicesForNegativesReversed = indicesForNegatives(numbers).drop(1).reverse
    @tailrec
    def removeAllButTheFirstNegativeNumberHelper(numbers: ArrayBuffer[Int],
                                                 indices: Seq[Int],
                                                 currentIndex: Int): ArrayBuffer[Int] = {
      if (currentIndex == indices.length) {
        numbers
      } else {
        numbers.remove(indices(currentIndex))
        removeAllButTheFirstNegativeNumberHelper(numbers, indices, currentIndex + 1)
      }
    }
    removeAllButTheFirstNegativeNumberHelper(numbers, indicesForNegativesReversed, 0)
  }

  def removeAllButTheFirstNegativeNumber1(numbers: ArrayBuffer[Int]) = {
    val indicesToRemove = indicesForNegatives(numbers).drop(1)
    @tailrec
    def removeAllButTheFirstNegativeNumberHelper(currentSeq: Vector[Int], indices: Seq[Int], currentIndex: Int): Vector[Int] = {
      if (currentIndex == numbers.length) {
        currentSeq
      } else {
        val newSeq =
          if (!indices.contains(currentIndex)) {
            currentSeq :+ numbers(currentIndex)
          } else {
            currentSeq
          }
        removeAllButTheFirstNegativeNumberHelper(newSeq, indices, currentIndex + 1)
      }
    }
    removeAllButTheFirstNegativeNumberHelper(immutable.Vector.empty, indicesToRemove, 0)
  }

  def removeAllButTheFirstNegativeNumber2(numbers: ArrayBuffer[Int]) = {
    val indexes = for (i <- numbers.indices if numbers(i) < 0) yield i
    val indexesToRemove = indexes.drop(1)
    for (i <- indexesToRemove.reverse) numbers.remove(i)
  }

  def removeAllButTheFirstNegativeNumber(numbers: ArrayBuffer[Int]) = {
    val indexes = for (i <- numbers.indices if numbers(i) < 0) yield i
    val indexesToRemove = indexes.drop(1)
    for (i <- numbers.indices if !indexesToRemove.contains(i)) yield numbers(i)
  }

  private val numbers = ArrayBuffer(2, -8, 9, 10, -345, -89, 74, -11, 45, 23, -99, 1)

  println(removeAllButTheFirstNegativeNumber(numbers))

}
