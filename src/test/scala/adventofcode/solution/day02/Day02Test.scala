package adventofcode.solution.day02

import org.scalatest.FunSuite

class Day02Test extends FunSuite {

  test("Day02.problemA") {

    val testInput = "5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8"
    assert(Day02.problemA(testInput) === 18)

  }

  test("Day02.problemB") {

    val testInput = "5\t9\t2\t8\n9\t4\t7\t3\n3\t8\t6\t5"
    assert(Day02.problemB(testInput) === 9)

  }
}
