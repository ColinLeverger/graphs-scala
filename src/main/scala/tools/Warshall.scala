package tools

import graph._

/**
  * Created by colinleverger on 30/10/15.
  */
object Warshall {

  /**
    * Apply Warshall to the given graph
    * @param graph
    * @return nothing, it modify the graph itself!
    */
  def applyWarshall(graph: Graph) {
    val n = graph.nbNodes

    for {
      i <- 1 to n
      x <- 1 to n
      y <- 1 to n
    } {
      if (graph.isArc(x, i) && graph.isArc(i, y) && !graph.isArc(x, y)) {
        //println("Adding an arc from node " + x + " to node " + y) //DEBUG
        graph.getNode(x).addArc(y, 1)
      }
    }
  }
}


