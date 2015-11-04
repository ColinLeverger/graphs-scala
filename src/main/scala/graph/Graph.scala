package graph

/**
 * Define a graph which is basically a list of nodes.
 * @param _matrix
 */
class Graph(
  _matrix: List[Node]
) {
  /**
   * Return the node numbered by the param nodeNumber
   * @param nodeNumber
   * @return Node
   */
  def giveMeThisNode(nodeNumber: Int): Node = _matrix.filter(_.adjacency.keySet.contains(nodeNumber)).head

  /**
   * Getter for _matrix
   * @return _matrix
   */
  def matrix: List[Node] = _matrix
}
