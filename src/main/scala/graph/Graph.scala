package graph

/**
 * Define a graph which is basically a list of nodes.
 * @param matrix
 */
case class Graph(
  matrix: List[Node]
) {

  /**
   * Return if this graph is empty
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
  def printGraph = matrix.foreach(println)

  /**
   * Say if there is an arc between these two nodes
   * @param s1
   * @param s2
   * @return boolean
   */
  def isArc(s1: Node, s2: Node): Boolean = matrix.filter(_==s1).head.adjacency(s1.nodeNumber).flatMap(_.toList).exists(_._1 == s2.nodeNumber)

}
