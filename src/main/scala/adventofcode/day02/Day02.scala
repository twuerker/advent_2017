package adventofcode.day02

import adventofcode.{A, B, Day}

object Day02 extends Day(2) {

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {

    input
      .split("\n")
      .map{ line =>
        val numbers = line.split("\t").map(number => number.toInt)
        val max = numbers.max
        val min = numbers.min
        max - min
      }
      .sum
  }

  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)


  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {

    input
      .split("\n")
      .map{ line =>
        val numbers = line.split("\t").map(number => number.toInt)
        val divs = for {
          x <- numbers
          y <- numbers
        } yield {
          if (x > y && x % y == 0) Some(x/y) else None
        }
        divs.flatten.head
      }
      .sum
  }

  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
