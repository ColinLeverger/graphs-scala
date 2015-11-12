package graph

/**
  * Define a graph which is basically a list of nodes.
  * @param _matrix
  */
class Graph(
  _matrix: List[Node]
) {

  /**
    * Add a node to a graph
    * @param node
    * @return newGraph
    */
  def addNode(node: Node): Graph = new Graph(matrix :+ node)

  /**
    * Remove the Node "nodeNumber" from a graph
    * @param node
    * @return updatedGraph
    */
  def delNode(node: Node): Graph = new Graph(matrix.filter(_ != node))

  /**
    * Return if this graph is empty
    * @return emptyness of this graph
    */
  def isEmpty: Boolean = _matrix.isEmpty

  /**
    * Return the number of nodes in this graph
    * @return number of nodes of this graph
    */
  def nbNode: Int = _matrix.size

  /**
    * Print the graph
    */
  def printGraph = _matrix.foreach(println)

  /**
    * Say if there is an arc between these two nodes
    * @param s1
    * @param s2
    * @return boolean
    */
  def isArc(s1: Int, s2: Int): Boolean = {
    _matrix.filter(_.nodeNumber == s1).head.adjacency.keySet.toList.contains(s2)
  }

  /**
    * Return the node numbered by the param nodeNumber
    * @param n nodeNumber
    * @return Node
    */
  def giveNode(n: Int): Node = _matrix.filter(_.nodeNumber == n).head

  /**
    * Return the sucessors of this node
    * @param node
    * @return Map[Int,Int] wich represents the successors
    */
  def giveSuccessors(node: Node): Map[Int, Int] = {
    giveNode(node.nodeNumber).successors
  }

  /**
    * Return the weight between these two nodes
    * @param node1
    * @param node2
    * @return weight
    * @throws NoSuchElementException if there is no connection between the nodes provided
    */
  def weightBetweenTheseTwoNodes(node1: Int, node2: Int): Int = {
    giveNode(node1).giveWeightOfThisSuccessor(node2)
  }

  /**
    * Find the biggest element in a list of int
    * @param xs
    * @return
    */
  def max(xs: List[Int]): Int = {
    if (xs.isEmpty) throw new NoSuchElementException
    xs.reduceLeft((x, y) => if (x > y) x else y)
  }

  /**
    * Getter for _matrix
    * @return _matrix
    */
  def matrix: List[Node] = _matrix
}
