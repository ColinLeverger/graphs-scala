package graph

/**
 * define a graph
 * which is basically a two dimensional array
 * NOTE: case class is like an extended class
 * we do not need getters & setters to use the
 * encapsulated field but it is as secure as
 * @param matrix
 */
case class Graph(
  matrix: List[List[Boolean]]
) {

  /**
   * Display if this graph is empty
   * @return emptyness of this graph
   */
  def isEmpty: Boolean = matrix.isEmpty

  /**
   * Return the number of nodes in this graph
   * @return number of nodes of this graph
   */
  def nbNode: Int = matrix.size

  /**
   * Print the graph
   */
  def printGraph = {
    for (line <- matrix) {
      println("| " + line.map(b => if (b == false) {
        0
      } else {
        1
      }).mkString(" | ") + " |")
    }
  }

  /**
   * Say if there is an arc between these two nodes
   * @param s1
   * @param s2
   * @return boolean
   */
  def isArc(s1: Node, s2: Node): Boolean = matrix(s1.nodeNumber)(s2.nodeNumber)
}
