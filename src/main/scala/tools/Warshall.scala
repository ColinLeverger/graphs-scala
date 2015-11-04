package tools

import graph._

import scala.collection.mutable.{Map => MMap}

/**
 * Created by colinleverger on 30/10/15.
 */
object Warshall {

  /**
   * Aply Warshall to the graph given in parameter
   * @param graph
   */
  def applyWarshall(graph: Graph): Unit = {
    val n = GraphTools.nbNode(graph)

    for (i <- 1 to n) {
      for (x <- 1 to n) {
        if (GraphTools.isArc(graph, x, i)) {
          for (y <- 1 to n) {
            if (GraphTools.isArc(graph, i, y)) {
              if (!GraphTools.isArc(graph, x, y)) {
                println("adding an arc between " + x + " and " + y)
                graph.giveMeThisNode(x).addArc(Map(y -> 1))
              }
            }
          }
        }
      }
    }
  }
}
