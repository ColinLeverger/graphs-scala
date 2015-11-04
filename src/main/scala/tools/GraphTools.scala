package tools

import graph._

object GraphTools {

  /**
   * Create an emptyGraph
   * @return emptyGraph
   */
  def createEmptyGraph(): Graph = new Graph(List[Node]())

  /**
   * Add a node to a graph
   * @param graph
   * @param node
   * @return newGraph
   */
  def addNode(graph: Graph, node: Node): Graph = new Graph(graph.matrix :+ node)

  /**
   * Remove the Node "nodeNumber" from a graph
   * @param graph
   * @param node
   * @return updatedGraph
   */
  def delNode(graph: Graph, node: Node): Graph = new Graph(graph.matrix.filter(_ != node))

  /**
   * Return if this graph is empty
   * @param graph
   * @return emptyness of this graph
   */
  def isEmpty(graph: Graph): Boolean = graph.matrix.isEmpty

  /**
   * Return the number of nodes in this graph
   * @param graph
   * @return number of nodes of this graph
   */
  def nbNode(graph: Graph): Int = graph.matrix.size

  /**
   * Print the graph
   * @param graph
   */
  def printGraph(graph: Graph) = graph.matrix.foreach(println)

  /**
   * Say if there is an arc between these two nodes
   * @param graph
   * @param s1
   * @param s2
   * @return boolean
   */
  def isArc(graph: Graph, s1: Int, s2: Int): Boolean =
    graph.matrix.filter(_.adjacency.keySet.contains(s1)).head.adjacency(s1).flatMap(_.toList).exists(_._1 == s2)

}
