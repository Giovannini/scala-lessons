import doodle.core._

object GameOfLife {

  /**
   * Start the game of lige
   * @param size size of the grid
   */
  def start(size: Int) {
    val clock: Events[Unit] = Events.every(200)
    val worldInit: World = World.init(size)
    val worlds: Events[World] = clock.fold(worldInit) { (_, world) =>
      world.next
    }

    Ui.show(worlds.map(worldImage))
  }

  val emptyImage: Image = Rectangle(0,0)

  val cellSize = 10
  def cellImage(cell: Cell): Image = {
    val color = if (cell == Alive) Color.green else Color.white
    Rectangle(cellSize, cellSize).fillColor(color)
  }

  /**
   * Given a world, generate an image to draw
   * @param world from which the image will be generated
   * @return the image generated from the world's informations
   */
  def worldImage(world: World): Image = {
    val rowImages = world.cells.map{ row =>
      val cellImages = row.map(cellImage)
      cellImages.foldLeft(emptyImage)(_ beside _)
    }
    rowImages.foldLeft(emptyImage)(_ above _)
  }

}
