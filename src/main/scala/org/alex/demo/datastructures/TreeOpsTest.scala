package org.alex.demo.datastructures

import org.alex.demo.datastructures.TreeOps.{Environment, derive, eval}

object TreeOpsTest extends App {
  val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
  val env: Environment = {
    case "x" => 5
    case "y" => 7
  }
  println("Expression: " + exp)
  println("Evaluation with x=5, y=7: " + eval(exp, env))
  println("Derivative relative to x:\n " + derive(exp, "x"))
  println("Derivative relative to y:\n " + derive(exp, "y"))
}
