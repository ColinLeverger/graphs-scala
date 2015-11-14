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
  def giveSuccessorsKeys: List[Int] = {
    val successorsKeys = for {
      successor <- adjacency
    } yield {
      successor._1
    }

    successorsKeys.toList.sortWith(_ < _)
  }

  /**
    * Give the weight of the successor
    * @param nodeNumber
    * @return weight
    */
  def giveWeightOfThisSuccessor(nodeNumber: Int): Int = adjacency.get(nodeNumber).getOrElse(-1000)

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

