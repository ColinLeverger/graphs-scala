package graph

import scala.collection.mutable.{ListBuffer, Map => MMap}

/**
 * Define a Node
 * Represented by an integer which is basically the number of the node in the graph.
 */
case class Node(
  var adjacency: MMap[Int, ListBuffer[Map[Int, Int]]]
) {
  lazy val nodeNumber = adjacency.keys.head

  /**
   * Establish a link between two arcs
   * @param adj
   */
  def addArc(adj: Map[Int, Int]) {
    adjacency(nodeNumber) = adjacency.get(nodeNumber).get :+ adj
  }

  /**
   * Remove a link between two arcs
   * @param adj
   */
  def delArc(adj: Map[Int, Int]) {
    adjacency(nodeNumber) = adjacency.get(nodeNumber).get - adj
  }

  def giveSuccessors: List[Int] = {
    val listOfSuccessors = adjacency.get(nodeNumber).get.toList

    val successorsKeys = for {
      successor <- listOfSuccessors
    } yield {
        successor.keys.head
      }

    successorsKeys.sortWith(_ < _)
  }

  /**
   * Count the number of successors
   * @return numberOfSuccessor
   */
  def numberOfSuccessor: Int = adjacency(nodeNumber).size

  /**
   * Print the graph
   */
  def printNode = adjacency.foreach(println)
}

