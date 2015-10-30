package tools

import graph._

object GraphTools {

  /**
   * Create an emptyGraph
   * @return emptyGraph
   */
  def createEmptyGraph(): Graph = Graph(List[Node]())

  /**
   * Add a node to a graph
   * @param graph
   * @param node
   * @return newGraph
   */
  def addNode(graph: Graph, node: Node): Graph = Graph(graph.matrix :+ node)

  /**
   * Remove the Node "nodeNumber" from a graph
   * @param graph
   * @param node
   * @return updatedGraph
   */
  def delNode(graph: Graph, node: Node): Graph = Graph(graph.matrix.filter(_ != node))

}
