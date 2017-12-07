package adventofcode.day03

import adventofcode.{A, B, Day}

object Day03 extends Day(3) {

  case class Vector(x: Int, y: Int) {
    def add(other: Vector) = Vector(this.x + other.x, this.y + other.y)
    lazy val distance = Math.abs(x) + Math.abs(y)
  }

  sealed trait Direction {
    val turnDirection: Direction
    val vector: Vector
  }
  case object Up extends Direction {
    override val turnDirection: Direction = Left
    override val vector: Vector = Vector(0, 1)
  }
  case object Down extends Direction {
    override val turnDirection: Direction = Right
    override val vector: Vector = Vector(0, -1)
  }
  case object Right extends Direction {
    override val turnDirection: Direction = Up
    override val vector: Vector = Vector(1, 0)
  }
  case object Left extends Direction {
    override val turnDirection: Direction = Down
    override val vector: Vector = Vector(-1, 0)
  }

  case class SpiralPath(position: Vector, direction: Direction, visited: Set[Vector]) {

    lazy val turnDirection = direction.turnDirection

    def step() = {
      val turnPosition = position.add(turnDirection.vector)
      if (visited.contains(turnPosition)) {
        val forwardPosition = position.add(direction.vector)
        SpiralPath(forwardPosition, direction, visited + forwardPosition)
      } else {
        SpiralPath(turnPosition, turnDirection, visited + turnPosition)
      }
    }
  }

  object SpiralPath {
    val init = SpiralPath(
      position = Vector(0,0), direction = Left, visited = Set(Vector(0,0))
    )
  }

  def findSumOfNeighbors(position: Vector, valueMap: Map[Vector, Int]): Int = {
    val x = position.x
    val y = position.y
    val neighbors = Seq(
      Vector(x+1, y+1), Vector(x+1, y), Vector(x+1, y-1),
      Vector(x, y+1), Vector(x, y-1),
      Vector(x-1, y+1), Vector(x-1, y), Vector(x-1, y-1))
    neighbors.map( pos => valueMap.getOrElse(pos, 0)).sum
  }

  def valueAt(input: Int) = {

    def loop(stepsLeft: Int, path: SpiralPath, valueMap: Map[Vector, Int]): Int = {
      if (stepsLeft <= 0) {
        valueMap.getOrElse(path.position, -2)
      }
      else {
        valueMap.get(path.position) match {
          case Some(value) => {
            val nextPath = path.step()
            val nextValue = findSumOfNeighbors(nextPath.position, valueMap)
            val nextMap = valueMap + (nextPath.position -> nextValue)
            loop(stepsLeft - 1, nextPath, nextMap)
          }
          case None => -1
        }
      }
    }
    val startPath = SpiralPath.init
    val startMap = Map(Vector(0,0) -> 1)
    loop(input - 1, startPath, startMap)
  }

  /**
    * ProblemA
    * @param input
    * @return
    */
  def problemA(input: Int): Int = {

    def stepping(stepsLeft: Int, path: SpiralPath): SpiralPath = {
      if (stepsLeft <= 0) {
        path
      } else {
        val nextPath = path.step()
        stepping(stepsLeft - 1, nextPath)
      }
    }
    val path = stepping(input - 1, SpiralPath.init)
    path.position.distance
  }
  val solutionA = problemA(input.toInt).toString
  finalAnswer(solutionA, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: Int): (Int, Int) = {
    def loop(step: Int, path: SpiralPath, valueMap: Map[Vector,Int]): (Int, Int) = {
      valueMap.get(path.position) match {
        case Some(value) => {
          if (value > input) {
            (step, value)
          } else {
            val nextPath = path.step()
            val nextValue = findSumOfNeighbors(nextPath.position, valueMap)
            val nextMap = valueMap + (nextPath.position -> nextValue)
            loop(step + 1, nextPath, nextMap)
          }
        }
        case None => (-1, -1)
      }
    }
    loop(1, SpiralPath.init, Map(Vector(0,0) -> 1))
  }

  val (solutionBStep, solutionB) = problemB(input.toInt)
  finalAnswer(solutionB.toString, B)

}
