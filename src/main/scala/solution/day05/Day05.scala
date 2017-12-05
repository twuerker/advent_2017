package solution.day05

import adventofcode._

object Day05 extends Day(5) {

  case class JumpPathA(index: Int, jumpMap: Vector[Int]) {
    def step(): JumpPathA = {
      val valueAtIndex = jumpMap(index)
      val nextIndex = index + valueAtIndex
      val headList = jumpMap.take(index)
      val tailList = jumpMap.drop(index + 1)
      val nextJumpMap = (headList :+ (valueAtIndex + 1)) ++ tailList
      JumpPathA(nextIndex, nextJumpMap)
    }

    def canStep(): Boolean = {
      index >= 0 && index < jumpMap.length
    }
  }

  case class JumpPathB(index: Int, jumpMap: Vector[Int]) {
    def step(): JumpPathB = {
      val valueAtIndex = jumpMap(index)
      val nextIndex = index + valueAtIndex
      val nextValue = if (valueAtIndex >= 3) { valueAtIndex - 1 } else { valueAtIndex + 1 }
      val headList = jumpMap.take(index)
      val tailList = jumpMap.drop(index + 1)
      val nextJumpMap = (headList :+ nextValue) ++ tailList
      JumpPathB(nextIndex, nextJumpMap)
    }

    def canStep(): Boolean = {
      index >= 0 && index < jumpMap.length
    }
  }

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {

    val jumpMap = input.split("\n").map(_.toInt).toVector
    val startPath = JumpPathA(0, jumpMap)

    def loop(step: Int, path: JumpPathA): Int = {
      if (!path.canStep()) {
        step
      } else {
        loop(step + 1, path.step())
      }
    }

    loop(0, startPath)
  }

  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {

    val jumpMap = input.split("\n").map(_.toInt).toVector
    val startPath = JumpPathB(0, jumpMap)

    def loop(step: Int, path: JumpPathB): Int = {
      if (!path.canStep()) {
        step
      } else {
        loop(step + 1, path.step())
      }
    }

    loop(0, startPath)
  }

  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
