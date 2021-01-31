package com.knoldus.Implementation

import com.knoldus.Traits.TraitDefination

class Trait_Implementation extends TraitDefination{
  override def divide(num: Int, deno: Int): Int = {
    num/deno
  }
  def division (num: Int, deno: Int): Int = {
    val output= divide(num: Int, deno: Int)
    output
  }

  override def fibonacci(firstterm: Int, secondterm: Int, totalnoterms: Int): Array[Int] = {
    val fibonacciSeries: Array[Int] = new Array[Int](totalnoterms)
    var a = firstterm
    var b = secondterm
    fibonacciSeries(0) = firstterm
    fibonacciSeries(1) = secondterm
    for (i <- 2 until totalnoterms) {
      val next_term = a + b
      fibonacciSeries(i) = next_term
      a = b
      b = next_term
    }
    fibonacciSeries
  }
  def FibonacciSeries (firstterm: Int, secondterm: Int, totalnoterms : Int): Array[Int] = {
    val Fibonacci_Series = fibonacci(firstterm: Int, secondterm: Int, totalnoterms :Int)
    Fibonacci_Series
  }

}
