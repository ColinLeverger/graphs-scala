package graph

import scala.collection.mutable.{ListBuffer, Map => MMap}

/**
 * Define a Node
 * Represented by the variable adjacency, which is a mutable Map (MMap) composed of
 * an Int (the number of the node) followed by a mutable list which contain
 * the descendants of this node.
 */
case class Node(
  var adjacency: MMap[Int, ListBuffer[Map[Int, Int]]]
) {
  lazy val nodeNumber = adjacency.keys.head
  lazy val listOfSuccessors = adjacency.get(nodeNumber).get.toList

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

  /**
   * Return the successors keys of this node
   * @return sorted list of successors
   */
  def giveSuccessorsKeys: List[Int] = {
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

