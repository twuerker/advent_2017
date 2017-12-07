package adventofcode.day04

import org.scalatest.FunSuite

class Day04Test extends FunSuite {

  test("Day04.hasNoDupicateWords") {

    assert(Day04.hasNoDuplicateWords("aa bb cc dd ee") === true)
    assert(Day04.hasNoDuplicateWords("aa bb cc dd aa") === false)
    assert(Day04.hasNoDuplicateWords("aa bb cc dd aaa") === true)

  }

  test("Day04.problemA") {

    assert(Day04.problemA("aa bb cc dd ee") === 1)

    assert(Day04.problemA("aa bb cc dd aa") === 0)

    val testPhrases = Seq("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa").mkString("\n")
    assert(Day04.problemA(testPhrases) === 2)

  }

  test("Day04.hasNoAnagrams") {

    assert(Day04.hasNoAnagrams("abcde fghij") === true)
    assert(Day04.hasNoAnagrams("abcde xyz ecdab") === false)
    assert(Day04.hasNoAnagrams("a ab abc abd abf abj") === true)
    assert(Day04.hasNoAnagrams("iiii oiii ooii oooi oooo") === true)
    assert(Day04.hasNoAnagrams("oiii ioii iioi iiio") === false)

  }

  test("Day04.problemB") {

    assert(Day04.problemB("abcde fghij") === 1)

    assert(Day04.problemB("abcde xyz ecdab") === 0)

    val testPhrases = Seq("abcde fghij","abcde xyz ecdab","a ab abc abd abf abj").mkString("\n")
    assert(Day04.problemB(testPhrases) === 2)


  }
}
