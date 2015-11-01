import _root_.tools.GraphTools
import graph.Node
import org.scalatest._
import scala.collection.mutable.{Map => MMap}

import scala.collection.mutable.ListBuffer

/**
 * Created by colinleverger on 26/10/15.
 */
class GraphTests extends FunSuite with Matchers {

  test("empty graph creation") {
    val emptyGraph = GraphTools.createEmptyGraph()
    GraphTools.isEmpty(emptyGraph) should be(true)
    GraphTools.nbNode(emptyGraph) should be(0)
  }

  //Map[Int,List[Map[Int,Int]]]
  test("add node test") {
    val emptyGraph = GraphTools.createEmptyGraph()
    val n1 = Node(MMap(1 -> ListBuffer(Map(1 -> 1))))
    val notEmptyGraph = GraphTools.addNode(emptyGraph, n1)
    GraphTools.isEmpty(notEmptyGraph) should be(false)
    GraphTools.nbNode(notEmptyGraph) should be(1)
  }

  test("del node test") {
    val emptyGraph = GraphTools.createEmptyGraph()
    val n1 = Node(MMap(1 -> ListBuffer(Map(1 -> 1))))
    val n2 = Node(MMap(2 -> ListBuffer(Map(4 -> 1))))
    var notEmptyGraph = GraphTools.addNode(emptyGraph, n1)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph, n2)
    notEmptyGraph = GraphTools.delNode(notEmptyGraph, n2)
    GraphTools.isEmpty(notEmptyGraph) should be(false)
    GraphTools.nbNode(notEmptyGraph) should be(1)
  }

  test("connexion between nodes test") {
    val emptyGraph = GraphTools.createEmptyGraph()
    val n1 = Node(MMap(1 -> ListBuffer(Map(2 -> 1), Map(3 -> 1))))
    val n2 = Node(MMap(2 -> ListBuffer(Map(3 -> 1), Map(4 -> 1))))
    var notEmptyGraph = GraphTools.addNode(emptyGraph, n1)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph, n2)
    GraphTools.isArc(notEmptyGraph,1, 2) should be(true)
    GraphTools.isArc(notEmptyGraph,2, 1) should be(false)
  }

}
