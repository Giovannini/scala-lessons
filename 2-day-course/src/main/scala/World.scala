case class World(cells: Vector[Vector[Cell]]) {

  /**
   * Apply the rules to the world to generate its next state
   * @return the next state of the current world
   */
  def next: World = ???

}

object World {

  /**
   * Initialize the world with a grid of a given size
   * @param size size of the grid to create
   * @return
   */
  def init(size: Int): World = ???
}