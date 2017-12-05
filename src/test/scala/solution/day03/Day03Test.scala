package solution.day03

import org.scalatest.FunSuite

class Day03Test extends FunSuite {

  test("Day03.problemA") {

    assert(Day03.problemA(12) === 3)
    assert(Day03.problemA(23) === 2)
    assert(Day03.problemA(1024) === 31)
    assert(Day03.problemA(1) === 0)

  }

  test("Day03.valueAt") {

    assert(Day03.valueAt(1) === 1)
    assert(Day03.valueAt(2) === 1)
    assert(Day03.valueAt(3) === 2)
    assert(Day03.valueAt(4) === 4)
    assert(Day03.valueAt(5) === 5)

  }
}
