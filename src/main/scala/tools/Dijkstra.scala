package tools

import graph._

import scala.collection.mutable.ListBuffer

/**
 * Created by colinleverger on 30/10/15.
 */
object Dijkstra {

  def doDijtra(graph: Graph, startingNode: Node) = {
    val s = startingNode
    val n = graph.nbNode
    val allNodes = graph.matrix
    var E = ListBuffer(s)
  }

}
