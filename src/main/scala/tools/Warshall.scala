package tools

import scala.collection.mutable.{Map => MMap}

import graph._

/**
 * Created by colinleverger on 30/10/15.
 */
object Warshall {

  def doWarshall(graph: Graph): Graph = {
    val n = GraphTools.nbNode(graph)
    val graphToSendBack = graph
    for (i <- 1 to n) {
      for (x <- 1 to n) {
        if (GraphTools.isArc(graphToSendBack, x, i)) {
          for (y <- 1 to n) {
            if (GraphTools.isArc(graphToSendBack, x, y)) {
              graphToSendBack.giveMeThisNode(x).addArc(MMap(y -> 1))
            }
          }
        }
      }
    }
    graphToSendBack
  }
}
