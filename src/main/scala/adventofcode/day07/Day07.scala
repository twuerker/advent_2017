package adventofcode.day07

import adventofcode._

object Day07 extends Day(7) {

  case class Disc(subs: Set[String], weight: Int)

  case class DiscMap(map: Map[String, Disc]) {

    def getWordTotalWeight(word: String): Int = {
      val disc = map(word)
      disc.subs.toSeq.map(getWordTotalWeight).sum + disc.weight
    }

    def getSubWeights(word: String): Map[Int, Set[String]] = {
      val disc = map(word)
      disc.subs.foldLeft(Map.empty[Int, Set[String]]){ (acc, x) =>
        val subWeight = getWordTotalWeight(x)
        val mapEntry = (subWeight, acc.getOrElse(subWeight, Set.empty) + x)
        acc + mapEntry
      }
    }

    def apply(word: String): Disc = map(word)
    def get(word: String): Option[Disc] = map.get(word)
    def contains(word: String): Boolean = map.contains(word)
    def keySet = map.keySet
  }

  def parseDiscMap(input: String): DiscMap = {
    def parseKeyName(str: String): (String, Int) = {
      val x = str.split(" ")
      val keyName = x(0)
      val weight = """\d+""".r.findFirstIn(x(1)).get.toInt
      (keyName, weight)
    }

    val map = input.split("\n").map{ line =>
      line.contains("->") match {
        case true => {
          val split = line.split(" -> ")
          val (keyName, weight) = parseKeyName(split(0))
          val subSet = split(1).stripMargin.split(", ").toSet
          val disc = Disc(subSet, weight)
          (keyName, disc)
        }
        case false => {
          val (keyName, weight) = parseKeyName(line)
          val disc = Disc(Set.empty[String], weight)
          (keyName, disc)
        }
      }
    }.toMap
    DiscMap(map)
  }

  def findDepths(map: DiscMap): Map[String, Int] = {

    def loopOnDepths(knownLengths: Map[String, Int], remaining: Seq[String]): Map[String, Int] = {
      remaining.headOption match {
        case None => knownLengths
        case Some(word) if !map.contains(word) => loopOnDepths(knownLengths, remaining.tail)
        case Some(word) if map(word).subs.isEmpty => loopOnDepths(knownLengths + (word -> 1), remaining.tail)
        case Some(word) => {
          if (map(word).subs.forall(s => knownLengths.contains(s))) {
            val depth = map(word).subs.foldLeft(0)((max, s) => Math.max(max, knownLengths(s))) + 1
            loopOnDepths(knownLengths + (word -> depth), remaining.tail)
          } else {
            loopOnDepths(knownLengths, remaining.tail :+ word)
          }
        }
      }
    }

    loopOnDepths(Map.empty[String, Int], map.keySet.toSeq)
  }

  def findRoot(map: DiscMap): String = {

    val depths = findDepths(map)

    val (rootWord, _) = depths.foldLeft(("", -1)) { (root, current) =>
      if (current._2 > root._2) {
        current
      } else {
        root
      }
    }
    rootWord
  }

  /*****/


  def findUnbalanced(discMap: DiscMap): (String, Int) = {

    def loop(unbalancedWord: String, siblingWeight: Int): (String, Int) = {
      val subWeights = discMap.getSubWeights(unbalancedWord)
      if (subWeights.size <= 1) {
        //weights above are balanced. This is the bad node
        val diff = siblingWeight - discMap.getWordTotalWeight(unbalancedWord)
        val newWeight = discMap(unbalancedWord).weight + diff
        (unbalancedWord, newWeight)
      } else {
        //find which of the sub nodes are unbalanced
        val badWord = subWeights.find(e => e._2.size == 1).get._2.head
        val goodWeight = subWeights.find(e => e._2.size != 1).get._1
        loop(badWord, goodWeight)
      }
    }

    val root = findRoot(discMap)
    val rootWeight = discMap(root).weight
    loop(root, rootWeight)
  }

  /**
    * Problem A
    * @param input
    */
  def problemA(input: String): String = {
    val map = parseDiscMap(input)
    findRoot(map)
  }
  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    */
  def problemB(input: String) = {
    val map = parseDiscMap(input)
    val (word, correctedWeight) = findUnbalanced(map)
    println(s"The word '${word}' should be $correctedWeight")
    correctedWeight
  }
  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
