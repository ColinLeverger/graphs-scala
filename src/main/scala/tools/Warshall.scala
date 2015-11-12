package tools

import graph._

import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 30/10/15.
  */
object Warshall {

  /**
    * Apply Warshall to the given graph
    * @param graph
    */
  def applyWarshall(graph: Graph) {
    val n = graph.nbNode

    for {
      i <- 1 to n
      x <- 1 to n
      y <- 1 to n
    } {
      if (graph.isArc(x, i) && graph.isArc(i, y) && !graph.isArc(x, y)) {
        println("Adding an arc from node " + x + " to node " + y)
        graph.giveNode(x).addArc(y, 1)
      }
    }
  }
}


