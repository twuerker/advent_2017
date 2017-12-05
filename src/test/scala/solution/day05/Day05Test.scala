package solution.day05

import org.scalatest.FunSuite

class Day05Test extends FunSuite {

  test("Day05.problemA") {

    val testInput = Seq("0","3","0","1","-3").mkString("\n")
    assert(Day05.problemA(testInput) === 5)

  }

  test("Day05.problemB") {

    val testInput = Seq("0","3","0","1","-3").mkString("\n")
    assert(Day05.problemB(testInput) === 10)

  }

}
