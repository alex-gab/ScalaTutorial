package org.alex.demo.builder

trait Builder[T] {
  def build: T
}
