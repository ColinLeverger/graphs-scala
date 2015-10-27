package tools

import graph._

object GraphTools {

  def createEmptyGraph(): Graph = {
    println("creation of an empty graph")
    val emptyMatrix = List[Map[Node,List[Boolean]]]()
    new Graph(emptyMatrix)
  }

  /**
   * Because we are working in a functional way, it is impossible to reassign values
   * (--> good for pattern matching, functional approach...)
   * => When we want to add a graph.Node to a graph, we should return a new graph
   * @param nodeNumber
   * @param graph
   * @return newGraph
   */
  def addNode(nodeNumber: Int, graph: Graph): Graph = {
    val sizeOfNewGraph = graph.nbNode + 1
    val newLine = Map(Node(nodeNumber) -> List.fill(sizeOfNewGraph)(false))
    val tempMatrix = for {
      line <- graph.matrix
    } yield {
        val actNode = line.keys.head

        Map(actNode -> (line.get(actNode).get :+ false))
      }
    val newMatrix = tempMatrix :+ newLine
    Graph(newMatrix)
  }

  def removeNode(nodeNumber: Int, graph: Graph): Graph = {
    val tempMatrix = graph.matrix

    ???
  }

  def addArc(s1: Node, s2: Node): Graph = {
    ???
  }

  def delArc(s1: Node, s2: Node): Graph = {
    ???
  }

  //a faire : succésseurs / prédécesseurs / degrès entrant / degrès sortant
}
