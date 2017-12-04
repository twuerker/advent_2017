package day02

import org.scalatest.FunSuite

class Solution02_2Test extends FunSuite {

  test("Solution02_2") {

    val testInput = "5\t9\t2\t8\n9\t4\t7\t3\n3\t8\t6\t5"
    assert(Solution02_2.solve(testInput) === 9)

  }
}
