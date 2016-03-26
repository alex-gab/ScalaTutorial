package org.alex.demo



object Single {
  var name: String = "bau"

  def newInstance(name: String) = {
    this.name = name
    this
  }

  override def toString = s"Single($name)"
}
