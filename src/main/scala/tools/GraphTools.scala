package tools

import graph._

object GraphTools {

  def createEmptyGraph(): Graph = {
    val emptyMatrix = List[List[Boolean]]()
    new Graph(emptyMatrix)
  }

  /**
   * Because we are working in a functional way, it is impossible to reassign values
   * (--> good for pattern matching, functional approach...)
   * => When we want to add a graph.Node to a graph, we should return a new graph
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
   * Because we are working in a functional way, it is impossible to reassign values
   * (--> good for pattern matching, functional approach...)
   * => When we want to add a graph.Node to a graph, we should return a new graph
   * @param graph
   * @return newGraph
   */
  def addNodes(graph: Graph, numberOfNodes: Int): Graph = {
    ???
  }

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

  def addArc(s1: Node, s2: Node, graph: Graph): Graph = {
    val (x, y) = graph.matrix.splitAt(s1.nodeNumber)
    Graph(x ++ List(y.head.patch(s2.nodeNumber, Seq(true), 1)) ++ y.tail)
  }

  def delArc(s1: Node, s2: Node, graph: Graph): Graph = {
    val (x, y) = graph.matrix.splitAt(s1.nodeNumber)
    Graph(x ++ List(y.head.patch(s2.nodeNumber, Seq(false), 1)) ++ y.tail)
  }


  //a faire : succésseurs / prédécesseurs / degrès entrant / degrès sortant
}
