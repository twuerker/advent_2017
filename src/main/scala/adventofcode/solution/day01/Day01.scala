package adventofcode.solution.day01

import adventofcode.{A, B, Day}

object Day01 extends Day(1) {

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {

    case class SumAndPrevious(sum: Int, previous: String)

    val atEnd = input.split("").foldLeft(SumAndPrevious(0, "x")){(last, current) =>
      val nextSum = (current == last.previous) match {
        case true => last.sum + current.toInt
        case false => last.sum
      }
      SumAndPrevious(nextSum, current)
    }

    if (atEnd.previous == input.substring(0,1)) atEnd.sum + atEnd.previous.toInt
    else atEnd.sum
  }

  val solutionA = problemA(input).toString
  finalAnswer(solutionA, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {

    val halfLength = input.length / 2

    val firstHalf = input.substring(0, halfLength).split("")
    val secondHalf = input.substring(halfLength).split("")

    val pairs: Seq[(String, String)] = firstHalf.zip(secondHalf)

    pairs.foldLeft(0){
      (sum, pair) => {
        if (pair._1 == pair._2) {
          sum + (2 * pair._1.toInt)
        } else {
          sum
        }
      }
    }
  }

  val solutionB = problemB(input).toString
  finalAnswer(solutionB.toString, B)

}
