package day01

import org.scalatest.FunSuite

class Solution01_1Test extends FunSuite {

  test("Solution01_1") {

    assert(Solution01_1.solve("1122") === 3)
    assert(Solution01_1.solve("1111") === 4)
    assert(Solution01_1.solve("1234") === 0)
    assert(Solution01_1.solve("91212129") === 9)

  }
}
