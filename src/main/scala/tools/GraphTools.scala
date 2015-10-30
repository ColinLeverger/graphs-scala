package tools

import graph._

object GraphTools {

  /**
   * Create an emptyGraph
   * @return emptyGraph
   */
  def createEmptyGraph(): Graph = Graph(List[List[Boolean]]())

  /**
   * Add a node to a graph
   * @param graph
   * @return newGraph
   */
  def addNode(graph: Graph): Graph = {
    val sizeOfNewGraph = graph.nbNode + 1
    val newLine = List.fill(sizeOfNewGraph)(false)

    val tempMatrix = for {
      line <- graph.matrix
    } yield {
        line :+ false
      }
    Graph(tempMatrix :+ newLine)
  }

  /**
   * Remove the Node "nodeNumber" from a graph
   * @param nodeNumber
   * @param graph
   * @return updatedGraph
   */
  def delNode(nodeNumber: Int, graph: Graph): Graph = {
    val (x, y) = graph.matrix.splitAt(nodeNumber)

    val finalMatrix = for {
      tempLine <- (x ++ y.tail)
    } yield {
        val (x, y) = tempLine.splitAt(nodeNumber)
        x ++ y.tail
      }
    Graph(finalMatrix)
  }

  /**
   * Add connection between to nodes on a graph
   * @param s1
   * @param s2
   * @param graph
   * @return updatedGraph
   */
  def addArc(s1: Node, s2: Node, graph: Graph): Graph = {
    val (x, y) = graph.matrix.splitAt(s1.nodeNumber)
    Graph(x ++ List(y.head.patch(s2.nodeNumber, Seq(true), 1)) ++ y.tail)
  }

  /**
   * Remove connection between to nodes on a graph
   * @param s1
   * @param s2
   * @param graph
   * @return updatedGraph
   */
  def delArc(s1: Node, s2: Node, graph: Graph): Graph = {
    val (x, y) = graph.matrix.splitAt(s1.nodeNumber)
    Graph(x ++ List(y.head.patch(s2.nodeNumber, Seq(false), 1)) ++ y.tail)
  }

  //a faire : succésseurs / prédécesseurs / degrès entrant / degrès sortant
}
