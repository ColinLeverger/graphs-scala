package tools

import graph._

import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 30/10/15.
  */
object Dijkstra {

  def chooseMin(Q: List[Node], dist: MMap[Node, Int]): Node = {
    val l = for {
      n <- Q
    } yield {
      n -> dist(n)
    }
    val map = l.toMap

    map.minBy(_._2)._1
  }

  def applyDijktra(graph: Graph, source: Node) = {
    var Q = List[Node]()
    var dist = MMap[Node, Int]()
    var prev = MMap[Node, Option[Node]]()

    for {
      v <- graph.matrix
    } {
      dist(v) = 9999
      prev(v) = None
      Q = v :: Q
    }

    dist(source) = 0

    while (!Q.isEmpty) {
      val u = chooseMin(Q, dist)
      Q = Q.filter(_ != u)

      for {
        v <- u.successorsList(graph)
      } {
        val alt = dist(u) + u.dijkstraWeightOfThisSuccessor(v.nodeNumber)
        if (alt < dist(v)) {
          dist(v) = alt
          prev(v) = Option(u)
        }
      }
    }
    (dist, prev)
  }
}
