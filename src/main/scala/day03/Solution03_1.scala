package day03

object Solution03_1 extends App {

  val input = 347991

  def solve(input: Int): Int = {
    if (input <= 1) return 0

    println(s"** INPUT = $input")

    def maxInLayer(layer: Int): Int = Math.pow((layer - 1) * 2 + 1, 2).toInt

    def findLayer(currentLayer: Int, input: Int): Int = {
      val max = maxInLayer(currentLayer)
      if (input > max) {
        findLayer(currentLayer + 1, input)
      } else { currentLayer }
    }

    val layer = findLayer(1, input)
    val min = maxInLayer(layer - 1)
    val max = maxInLayer(layer)
    println(s"layer = $layer, min = $min, max = $max")

    val edgeSize = (max - min) / 4 + 1
    val posInEdge = (input - min) % (edgeSize - 1)
    val middlePos = edgeSize / 2
    val posFromMiddle = Math.abs(posInEdge - middlePos)
    println(s"edgeSize = $edgeSize, posInEdge = $posInEdge, posFromMiddle = $posFromMiddle")
    posFromMiddle + layer - 1

  }

  val solution = solve(input)
  println(s"solution for given input = $solution")

  //solution for given input = 480

}
