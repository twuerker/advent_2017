package solution.day04

import adventofcode._

object Day04 extends Day(4) {

  def hasNoDuplicateWords(passphrase: String): Boolean = {
    val words = passphrase.split(" ")
    def checkNextWord(remaining: Seq[String], seen: Set[String]): Boolean =
      remaining.headOption match {
        case Some(word) =>
          if (seen.contains(word)) {
            false
          } else {
            checkNextWord(remaining.tail, seen + word)
          }
        case None => true
      }
    checkNextWord(words, Set.empty[String])
  }

  def hasNoAnagrams(passphrase: String): Boolean = {
    val words = passphrase.split(" ")
    def checkNextWord(remaining: Seq[String], seen: Set[String]): Boolean =
      remaining.headOption match {
        case Some(word) =>
          val sortedWord = word.sorted
          if (seen.contains(sortedWord)) {
            false
          } else {
            checkNextWord(remaining.tail, seen + sortedWord)
          }
        case None => true
      }
    checkNextWord(words, Set.empty[String])

  }

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {
    val lineSeparator = "\n"
    input.split(lineSeparator).map { passphrase =>
      hasNoDuplicateWords(passphrase) match {
        case true => 1
        case false => 0
      }
    }.sum
  }

  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {
    val lineSeparator = "\n"
    input.split(lineSeparator).map { passphrase =>
      hasNoAnagrams(passphrase) match {
        case true => 1
        case false => 0
      }
    }.sum
  }

  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
