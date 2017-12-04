package day01

import org.scalatest.FunSuite

class Solution1Test extends FunSuite {

  test("Solution1") {

    assert(Solution1.solve("1122") === 3)
    assert(Solution1.solve("1111") === 4)
    assert(Solution1.solve("1234") === 0)
    assert(Solution1.solve("91212129") === 9)

  }
}
