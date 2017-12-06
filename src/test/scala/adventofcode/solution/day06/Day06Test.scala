package adventofcode.solution.day06

import adventofcode.solution.day06.Day06.Allocation
import org.scalatest.FunSuite

class Day06Test extends FunSuite {

  test("Day05.Allocation") {

    val allo1 = Allocation(Vector(0,2,7,0))
    val allo2 = Allocation(Vector(2,4,1,2))
    val allo3 = Allocation(Vector(3,1,2,3))
    val allo4 = Allocation(Vector(0,2,3,4))
    val allo5 = Allocation(Vector(1,3,4,1))

    assert(allo1.largestBlock === (7,2))
    assert(allo2.largestBlock === (4,1))
    assert(allo3.largestBlock === (3,0))
    assert(allo4.largestBlock === (4,3))
    assert(allo5.largestBlock === (4,2))

    assert(allo1.redistributeLargestBlock === allo2)
    assert(allo2.redistributeLargestBlock === allo3)
    assert(allo3.redistributeLargestBlock === allo4)
    assert(allo4.redistributeLargestBlock === allo5)
    assert(allo5.redistributeLargestBlock === allo2)
  }

  test("Day06.problemA") {

    val testInput = Vector(0,2,7,0).mkString("\t")
    assert(Day06.problemA(testInput) === 5)

  }

  test("Day06.problemB") {

    val testInput = Vector(0,2,7,0).mkString("\t")
    assert(Day06.problemB(testInput) === 4)

  }

}
