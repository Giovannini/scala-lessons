case class World(cells: Vector[Vector[Cell]]) {

  /**
   * Apply the rules to the world to generate its next state
   * @return the next state of the current world
   */
  def next: World = {
    val newCells = cells.indices.toVector.map { y =>
      val row = cells(y)
      row.indices.toVector.map { x =>
        val cell = row(x)
        decideNextCell(cell, x, y)
      }
    }
    World(newCells)
  }

  def decideNextCell(cell: Cell, x: Int, y: Int): Cell = {
    val neighbours = getNeighbours(x,y)
    val aliveNeighbours = neighbours.count(_ == Alive)

    if (aliveNeighbours == 0 || aliveNeighbours == 1) Dead
    else if ((aliveNeighbours == 2 || aliveNeighbours == 3) && cell == Alive) cell
    else if (aliveNeighbours == 3 && cell == Dead) Alive
    else Dead
  }

  def getNeighbours(x: Int, y: Int): Seq[Cell] = {
    for {
      i <- (x - 1) to (x + 1)
      j <- (y - 1) to (y + 1)
      if i != x || j != y
    } yield getCell(i,j)
  }

  def getCell(x: Int, y: Int): Cell = {
    def posMod(x: Int, n: Int): Int = ((x % n) + n) % n
    val xMod = posMod(x, cells.size)
    val yMod = posMod(y, cells(xMod).size)
    cells(yMod)(xMod)
  }

}

object World {

  /**
   * Initialize the world with a grid of a given size
   * @param size size of the grid to create
   * @return
   */
  def init(size: Int): World = {
    val cells = Vector.fill(size, size){
      if(scala.util.Random.nextInt(10) > 5) Alive else Dead
    }
    World(cells)
  }
}