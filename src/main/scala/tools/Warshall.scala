package tools

import graph._
import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 30/10/15.
  */
object Warshall {

  def initRouting(n: Int): MMap[Map[Int, Int], Int] = {
    val initMMap = MMap[Map[Int, Int], Int]()
    for {
      i <- 1 to n
      j <- 1 to n
    } {
      initMMap(Map(i -> j)) = 0
    }
    initMMap
  }

  /**
    * Apply Warshall to the given graph
    * @param graph
    * @return nothing, it modify the graph itself!
    */
  def applyWarshall(graph: Graph): MMap[Map[Int, Int], Int] = {
    val n = graph.nbNodes
    val routing = initRouting(n)

    for {
      i <- 1 to n
      x <- 1 to n
      y <- 1 to n
    } {
      if (graph.isArc(x, i)) {
        if (routing(Map(x -> i)) == 0) {
          routing(Map(x -> i)) = i
        }
        if (graph.isArc(i, y) && !graph.isArc(x, y)) {
          //println("Adding an arc from node " + x + " to node " + y) //DEBUG
          graph.getNode(x).addArc(y, 1)
          routing(Map(x -> y)) = i
        }
      }
    }
    routing
  }
}


