package adventofcode

import java.io.PrintWriter

import scala.io.Source

class Day(day: Int) extends App {

  require(day >= 1 && day <= 25)

  protected val lineSeparator = "\n"
  private val formatted = "%02d".format(day)

  protected val input = readInput()

  private def readInput(): String = Source.fromFile(s"input/$formatted.txt").getLines().mkString(lineSeparator)
  private def writeOutput(output: String, subProblem: SubProblem): Unit = {
    new PrintWriter(s"output/$formatted${subProblem.formatted}.txt") {
      write(output)
      close()
    }
  }

  protected def finalAnswer(output: String, subProblem: SubProblem): Unit = {
    writeOutput(output, subProblem)
    println(s"${formatted}${subProblem.formatted} = $output")
  }

}

sealed trait SubProblem {
  def formatted: String
}
case object A extends SubProblem {
  override def formatted: String = "A"
}
case object B extends SubProblem {
  override def formatted: String = "B"
}
