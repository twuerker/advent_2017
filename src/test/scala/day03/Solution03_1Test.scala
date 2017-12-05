package day03

import org.scalatest.FunSuite

class Solution03_1Test extends FunSuite {

  test("Solution03_1.solve") {

    assert(Solution03_1.solve(12) === 3)
    assert(Solution03_1.solve(23) === 2)
    assert(Solution03_1.solve(1024) === 31)
    assert(Solution03_1.solve(1) === 0)

  }
}
