package com.knoldus.Implementation

import com.knoldus.Traits.TraitDefination
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class Trait_Test extends AsyncFlatSpec{


  val TraitsMocking: TraitDefination = mock(classOf[TraitDefination])
  val trait_Implementation = new Trait_Implementation()

  // Unit Test Cases for Fibonacci.

  "Fibonacci series " should "return [0,1,1] " in {
    when(TraitsMocking.fibonacci(firstterm = 0, secondterm = 1, totalnoterms = 3)) thenReturn Array[Int] ( xs= 0,1,1)
    val result = trait_Implementation.FibonacciSeries(firstterm = 0, secondterm = 1, totalnoterms = 3)
    assert(result sameElements Array[Int](xs = 0, 1, 1))
  }

  "Fibonacci series " should "return [4,5,9,14,23] " in {
    when(TraitsMocking.fibonacci(firstterm = 4, secondterm = 5, totalnoterms = 5)) thenReturn Array[Int] ( xs= 4,5,9,14,23)
    val result = trait_Implementation.FibonacciSeries(firstterm = 4, secondterm = 5, totalnoterms = 5)
    assert(result sameElements Array[Int](xs = 4,5,9,14,23))

  }
  "Fibonacci series " should "not return [0,1,1,2,2] " in {
    when(TraitsMocking.fibonacci(firstterm = 0, secondterm = 1, totalnoterms = 5)) thenReturn Array[Int] ( xs= 0,1,1,2,3)
    val result = trait_Implementation.FibonacciSeries(firstterm = 0, secondterm = 1, totalnoterms = 5)
    assert(result != Array[Int](xs = 0,1,1,2,2))

  }

  // Unit Test Cases for Division

  "On Dividing 200 by 25" should "give 8" in {
    when(TraitsMocking.divide(num = 200, deno = 25)) thenReturn 8
    val result = trait_Implementation.division(num = 200, deno = 25)
    assert(result==8)
  }
  "On Dividing 200 by 25" should "not give 10" in {
    when(TraitsMocking.divide(num = 200, deno = 25)) thenReturn 8
    val result = trait_Implementation.division(num = 200, deno = 25)
    assert(result!=10)
  }

}
