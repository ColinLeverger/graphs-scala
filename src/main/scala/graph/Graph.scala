package graph

/**
  * Define a graph which is basically a list of nodes.
  * @param _nodes
  */
class Graph(
  _nodes: List[Node]
) {

  /**
    * Add a node to a graph
    * @param node
    * @return updatedGraph
    */
  def addNode(node: Node): Graph = new Graph(getNodes :+ node)

  /**
    * Remove the Node "nodeNumber" from a graph
    * @param node
    * @return updatedGraph
    */
  def delNode(node: Node): Graph = new Graph(_nodes.filter(_ != node))

  /**
    * Return if this graph is empty
    * @return emptiness of this graph
    */
  def isEmpty: Boolean = _nodes.isEmpty

  /**
    * Return the number of nodes in this graph
    * @return number of nodes of this graph
    */
  def nbNodes: Int = _nodes.size

  /**
    * Print the graph
    */
  def printGraph = _nodes.foreach(println)

  /**
    * Say if there is an arc between these two nodes
    * @param s1
    * @param s2
    * @return boolean
    */
  def isArc(s1: Int, s2: Int): Boolean = _nodes.filter(_.nodeNumber == s1).head.adjacency.keySet.toList.contains(s2)

  /**
    * Return the node numbered by the param nodeNumber
    * @param n nodeNumber
    * @return Node
    */
  def getNode(n: Int): Node = _nodes.filter(_.nodeNumber == n).head

  /**
    * Return the node numbered by the param nodeNumber
    * @return ListOfNodes
    */
  def getNodes: List[Node] = _nodes

  /**
    * Return the sucessors of the given node in this graph
    * @param node
    * @return Map[Int,Int] which represents the successors
    */
  def getSuccessors(node: Node): Map[Int, Int] = {
    getNode(node.nodeNumber).getSuccessors
  }

  /**
    * Get all the nodes keys of this graph in a list
    * @return nodesKeys
    */
  def getNodesKeys: List[Int] = {
    val nodesKeys = for {
      n <- _nodes
    } yield {
      n.nodeNumber
    }
    nodesKeys.toList.sortWith(_ < _)
  }

  /**
    * Return the positive weight between the two given nodes keys
    * If there is no connection between the two nodes given, return infinite
    * @param node1
    * @param node2
    * @return weight
    */
  def dijkstraWeightBetweenTheseTwoNodes(node1: Int, node2: Int): Int = {
    getNode(node1).weightOfThisSuccessor(node2)
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
}
