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

    for (i <- 1 to n) {
      for (x <- 1 to n) {
        if (graph.isArc(x, i)) {
          for (y <- 1 to n) {
            if (graph.isArc(i, y)) {
              if (!graph.isArc(x, y)) {
                println("Adding an arc from node " + x + " to node " + y)
                graph.giveMeThisNode(x).addArc(y, 1)
              }
            }
          }
        }
      }
    }
  }
}
