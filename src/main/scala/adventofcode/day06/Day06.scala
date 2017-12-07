package adventofcode.day06

import adventofcode._

object Day06 extends Day(6) {

  type Banks = Vector[Int]

  case class Allocation(banks: Banks) {

    lazy val largestBlock: (Int, Int) = {
      case class Bank(index: Int, value: Int)
      banks.zipWithIndex.foldLeft((0,0)){(max, current) =>
        if (current._1 > max._1) {
          current
        } else {
          max
        }
      }
    }

    lazy val redistributeLargestBlock: Allocation = {
      def loop(remaining: Int, index: Int, banks: Banks): Banks = {
        if (remaining <= 0) {
          banks
        } else {
          val correctedIndex = if (index >= banks.length) { 0 } else { index }
          val increased = banks(correctedIndex) + 1
          val nextBanks = (banks.take(correctedIndex) :+ increased) ++ banks.drop(correctedIndex + 1)
          loop(remaining - 1, correctedIndex + 1, nextBanks)
        }
      }
      val (value, index) = largestBlock
      val startingBanks = (banks.take(index) :+ 0) ++ banks.drop(index + 1)
      val newBanks = loop(value, index + 1, startingBanks)
      Allocation(newBanks)
    }
  }

  def findLoop(allocation: Allocation) = {

    def loop(step: Int, current: Allocation, seen: Set[Allocation]): Int = {
      if (seen.contains(current)) {
        return step
      } else {
        val nextAllo = current.redistributeLargestBlock
        val nextSeen = seen + current
        loop(step + 1, nextAllo, nextSeen)
      }
    }
    loop(0, allocation, Set.empty)
  }

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {

    def loop(step: Int, current: Allocation, seen: Set[Allocation]): Int = {
      if (seen.contains(current)) {
        return step
      } else {
        val nextAllo = current.redistributeLargestBlock
        val nextSeen = seen + current
        loop(step + 1, nextAllo, nextSeen)
      }
    }

    val allocation = Allocation(input.split("\t").map(_.toInt).toVector)
    loop(0, allocation, Set.empty)
  }

  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {

    def loop(step: Int, current: Allocation, seen: Seq[Allocation]): Int = {
      seen.indexOf(current) match {
        case -1 => {
          val nextAllo = current.redistributeLargestBlock
          val nextSeen = seen :+ current
          loop(step + 1, nextAllo, nextSeen)
        }
        case i => {
          seen.length - i
        }
      }
    }

    val allocation = Allocation(input.split("\t").map(_.toInt).toVector)
    loop(0, allocation, Seq.empty)
  }

  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
