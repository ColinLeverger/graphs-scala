package graph

/**
 * Define a graph which is basically a list of nodes.
 * @param matrix
 */
case class Graph(
  matrix: List[Node]
) {
  def giveMeThisNode(nodeNumber: Int): Node = matrix.filter(_.adjacency.keySet.contains(nodeNumber)).head
}
