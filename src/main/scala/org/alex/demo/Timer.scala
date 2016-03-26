package org.alex.demo

import java.util.concurrent.TimeUnit

object Timer {
  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      TimeUnit.SECONDS sleep 2
    }
  }

  def main(args: Array[String]) {
    val callback: () => Unit = () => println("time flies like an arrow...")
    this oncePerSecond callback
  }
}
