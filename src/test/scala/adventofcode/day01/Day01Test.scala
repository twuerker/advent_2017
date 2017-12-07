package adventofcode.day01

import org.scalatest.FunSuite

class Day01Test extends FunSuite {

  test("DayO1.problemA") {

    assert(Day01.problemA("1122") === 3)
    assert(Day01.problemA("1111") === 4)
    assert(Day01.problemA("1234") === 0)
    assert(Day01.problemA("91212129") === 9)

  }

  test("Day01.problemB") {

    assert(Day01.problemB("1212") === 6)
    assert(Day01.problemB("1221") === 0)
    assert(Day01.problemB("123425") === 4)
    assert(Day01.problemB("123123") === 12)
    assert(Day01.problemB("12131415") === 4)

  }
}
