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
    * @param keyToRemove
    */
  def delArc(keyToRemove: Int) {
    adjacency -= keyToRemove
  }

  /**
    * Return the successors keys of this node
    * @return sorted list of successors
    */
  def getSuccessorsKeys: List[Int] = {
    val successorsKeys = for {
      adj <- adjacency
    } yield {
      adj._1
    }
    successorsKeys.toList.sortWith(_ < _)
  }

  /**
    * Return a the list of the successors
    * @param graph
    * @return
    */
  def getSuccessorsList(graph: Graph): List[Node] = {
    val successorsList = for {
      adj <- adjacency
    } yield {
      graph.getNodes.filter(_.nodeNumber == adj._1).head
    }
    successorsList.toList
  }

  /**
    * Give the successors of this node
    * @return successors (Map)
    */
  def getSuccessors: Map[Int, Int] = adjacency.toMap

  /**
    * Give the weight of the successor.
    * If no connection && warshall algorithm, return -1
    * If no connection && dijkstra algorithm, return infinite
    * @param n
    * @return weight
    */
  def weightOfThisSuccessor(n: Int, algorithmCode: String): Int = {
    algorithmCode match {
      case "w" => adjacency.getOrElse(n,noConnection)
      case "d" => adjacency.getOrElse(n,infinite)
    }
  }

  /**
    * Count the number of successors
    * @return numberOfSuccessor
    */
  def numberOfSuccessor: Int = adjacency.size

  /**
    * Print the node
    */
  def printNode {
    adjacency.foreach(println)
  }
}

