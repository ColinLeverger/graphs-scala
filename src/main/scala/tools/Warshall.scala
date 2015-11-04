package tools

import graph._

import scala.collection.mutable.{Map => MMap}

/**
 * Created by colinleverger on 30/10/15.
 */
object Warshall {

  def doWarshall(graph: Graph): Graph = {
    val graphToSendBack = graph
    val n = GraphTools.nbNode(graphToSendBack)

    for (i <- 1 to n) {
      for (x <- 1 to n) {
        if (GraphTools.isArc(graphToSendBack, x, i)) {
          for (y <- 1 to n) {
            if (GraphTools.isArc(graphToSendBack, i, y)) {
              if (!GraphTools.isArc(graphToSendBack, x, y)) {
                println("adding an arc between " + x + " and " + y)
                graphToSendBack.giveMeThisNode(x).addArc(Map(y -> 1))
              }
            }
          }
        }
      }
    }
    graphToSendBack
  }
}
