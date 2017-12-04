package day02

import org.scalatest.FunSuite

class Solution02_1Test extends FunSuite {

  test("Solution02_1") {

    val testInput = "5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8"
    assert(Solution02_1.solve(testInput) === 18)

  }
}
