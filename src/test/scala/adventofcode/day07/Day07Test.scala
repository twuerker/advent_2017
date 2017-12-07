package adventofcode.day07

import adventofcode.day07.Day07.Disc
import org.scalatest.FunSuite

class Day07Test extends FunSuite {

  val testInput =
    "pbga (66)\n" +
    "xhth (57)\n" +
    "ebii (61)\n" +
    "havc (66)\n" +
    "ktlj (57)\n" +
    "fwft (72) -> ktlj, cntj, xhth\n" +
    "qoyq (66)\n" +
    "padx (45) -> pbga, havc, qoyq\n" +
    "tknk (41) -> ugml, padx, fwft\n" +
    "jptl (61)\n" +
    "ugml (68) -> gyxo, ebii, jptl\n" +
    "gyxo (61)\n" +
    "cntj (57)"

  val parsedDiscMap = Day07.parseDiscMap(testInput)

  test("parseDiscMap") {

    assert(parsedDiscMap.keySet equals
      Set("pbga", "xhth", "ebii", "havc", "ktlj", "fwft", "qoyq", "padx", "tknk", "jptl", "ugml", "gyxo", "cntj"))

    assert(parsedDiscMap.get("pbga") contains Disc(Set.empty[String], 66))
    assert(parsedDiscMap.get("xhth") contains Disc(Set.empty[String], 57))
    assert(parsedDiscMap.get("ebii") contains Disc(Set.empty[String], 61))
    assert(parsedDiscMap.get("havc") contains Disc(Set.empty[String], 66))
    assert(parsedDiscMap.get("ktlj") contains Disc(Set.empty[String], 57))
    assert(parsedDiscMap.get("fwft") contains Disc(Set("ktlj", "cntj", "xhth"), 72))
    assert(parsedDiscMap.get("qoyq") contains Disc(Set.empty[String], 66))
    assert(parsedDiscMap.get("padx") contains Disc(Set("pbga", "havc", "qoyq"), 45))
    assert(parsedDiscMap.get("tknk") contains Disc(Set("ugml", "padx", "fwft"), 41))
    assert(parsedDiscMap.get("jptl") contains Disc(Set.empty[String], 61))
    assert(parsedDiscMap.get("ugml") contains Disc(Set("gyxo", "ebii", "jptl"), 68))
    assert(parsedDiscMap.get("gyxo") contains Disc(Set.empty[String], 61))
    assert(parsedDiscMap.get("cntj") contains Disc(Set.empty[String], 57))

  }

  test("findRoot") {
    assert(Day07.findRoot(parsedDiscMap) === "tknk")
  }

  test("DiscMap.getWordTotalWeight") {
    assert(parsedDiscMap.getWordTotalWeight("ugml") === 251)
    assert(parsedDiscMap.getWordTotalWeight("padx") === 243)
    assert(parsedDiscMap.getWordTotalWeight("fwft") === 243)
  }

  test("findUnbalanced") {
    assert(Day07.findUnbalanced(parsedDiscMap) === ("ugml", 60))
  }



}
