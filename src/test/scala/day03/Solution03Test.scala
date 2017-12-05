package day03

import org.scalatest.FunSuite

class Solution03Test extends FunSuite {

  test("Solution03.solve1") {

    assert(Solution03.solve1(12) === 3)
    assert(Solution03.solve1(23) === 2)
    assert(Solution03.solve1(1024) === 31)
    assert(Solution03.solve1(1) === 0)

  }

  test("Solution03.valueAt") {

    assert(Solution03.valueAt(1) === 1)
    assert(Solution03.valueAt(2) === 1)
    assert(Solution03.valueAt(3) === 2)
    assert(Solution03.valueAt(4) === 4)
    assert(Solution03.valueAt(5) === 5)

  }
}
