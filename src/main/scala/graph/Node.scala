package graph

import scala.collection.mutable.{Map => MMap}

/**
  * Define a Node
  * Represented by the variable adjacency, which is a mutable Map (MMap) composed of
  * an Int (the number of the node) followed by a mutable list which contain
  * the descendants of this node.
  */
case class Node(
  nodeNumber: Int,
  adjacency: MMap[Int, Int]
) {
  def successorsList(graph: Graph):List[Node] = {
    val l = for {
      adj <- adjacency
    } yield {
      graph.matrix.filter(_.nodeNumber == adj._1).head
    }
    l.toList
  }

  val infinite = 999999
  val noConnection = -1

  /**
    * Establish a link between two arcs
    * @param key
    * @param value
    */
  def addArc(key: Int, value: Int) {
    adjacency(key) = value
  }

  /**
    * Remove a link between two arcs
    * @param key to remove
    */
  def delArc(key: Int) {
    adjacency -= key
  }

  /**
    * Return the successors keys of this node
    * @return sorted list of successors
    */
  def getSuccessorsKeys: List[Int] = {
    val successorsKeys = for {
      successor <- adjacency
    } yield {
      successor._1
    }

    successorsKeys.toList.sortWith(_ < _)
  }

  /**
    * Give the weight of the successor.
    * If no connection, return -1
    * @param n
    * @return weight
    */
  def positiveWeightOfThisSuccessor(n: Int): Int = adjacency.get(n).getOrElse(noConnection)

  /**
    * Give the weight of the successor
    * If no connection yet, return 99999
    * @param n
    * @return weight
    */
  def dijkstraWeightOfThisSuccessor(n: Int): Int = adjacency.get(n).getOrElse(infinite)

  /**
    * Give the successors of this node
    * @return successors (Map)
    */
  def successors: Map[Int, Int] = adjacency.toMap

  /**
    * Count the number of successors
    * @return numberOfSuccessor
    */
  def numberOfSuccessor: Int = adjacency.size

  /**
    * Print the node
    */
  def printNode = adjacency.foreach(println)
}

