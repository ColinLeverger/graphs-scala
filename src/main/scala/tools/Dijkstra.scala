package tools

import graph._

import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 30/10/15.
  */
object Dijkstra {

  val infinite = 99999

  /**
    * Choose the minimum value between a node and its predecessor
    * @param Q
    * @param dist
    * @return minimumDistance
    */
  def chooseMin(Q: List[Int], dist: MMap[Int, Int]): Int = {
    val l = for {
      n <- Q
    } yield {
      n -> dist(n)
    }
    l.toMap.minBy(_._2)._1
  }

  /**
    * Give the shortest path weight to go to given n from the source;
    * you can use it after the Dijkstra execution
    * @param n
    * @param dist
    * @return minDist
    */
  def giveShortestPathWeight(n: Node, dist: MMap[Int, Int]): Int = dist(n.nodeNumber)

  /**
    * Recursive function to give the shortest path to go to the given node n
    * @param n
    * @param prev
    * @return
    */
  def giveShortestPath(n: Int, prev: MMap[Int, Option[Int]]): List[Int] = {
    prev(n) match {
      case None => Nil
      case n2 => giveShortestPath(n2.get, prev) :+ n
    }
  }

  /**
    * Apply the Dijkstra algorithm to the given graph, starting
    * by the givent source (node)
    * @param graph
    * @param source
    * @return (dist,prev)
    */
  def applyDijkstra(graph: Graph, source: Node) = {
    var Q = List[Int]()
    val dist = MMap[Int, Int]()
    val prev = MMap[Int, Option[Int]]()

    for {
      v <- graph.getNodes
      nodeNumber = v.nodeNumber
    } {
      dist(nodeNumber) = infinite
      prev(nodeNumber) = None
      Q = nodeNumber :: Q
    }

    dist(source.nodeNumber) = 0

    while (!Q.isEmpty) {
      val u = chooseMin(Q, dist)
      Q = Q.filter(_ != u)

      for {
        v <- graph.getNode(u).successorsList(graph)
        nodeNumber = v.nodeNumber
      } {
        val alt = dist(u) + graph.getNode(u).weightOfThisSuccessor(nodeNumber, "d")
        if (alt < dist(nodeNumber)) {
          dist(nodeNumber) = alt
          prev(nodeNumber) = Option(u)
        }
      }
    }
    (dist, prev)
  }
}
