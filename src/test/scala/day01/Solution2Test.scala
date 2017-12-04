package day01

import org.scalatest.FunSuite

class Solution2Test extends FunSuite {

  test("Solution2") {

    assert(Solution2.solve("1212") === 6)
    assert(Solution2.solve("1221") === 0)
    assert(Solution2.solve("123425") === 4)
    assert(Solution2.solve("123123") === 12)
    assert(Solution2.solve("12131415") === 4)

  }
}
