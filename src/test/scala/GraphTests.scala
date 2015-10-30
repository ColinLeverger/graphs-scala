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
    emptyGraph.isEmpty should be(true)
    emptyGraph.nbNode should be(0)
  }

  //Map[Int,List[Map[Int,Int]]]
  test("add node test") {
    val emptyGraph = GraphTools.createEmptyGraph()
    val n1 = Node(MMap(1 -> ListBuffer(MMap(1 -> 1))))
    val notEmptyGraph = GraphTools.addNode(emptyGraph, n1)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)
  }

  test("del node test") {
    val emptyGraph = GraphTools.createEmptyGraph()
    val n1 = Node(MMap(1 -> ListBuffer(MMap(1 -> 1))))
    val n2 = Node(MMap(2 -> ListBuffer(MMap(4 -> 1))))
    var notEmptyGraph = GraphTools.addNode(emptyGraph, n1)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph, n2)
    notEmptyGraph = GraphTools.delNode(notEmptyGraph, n2)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)
  }

  test("connexion between nodes test") {
    val emptyGraph = GraphTools.createEmptyGraph()
    val n1 = Node(MMap(1 -> ListBuffer(MMap(2 -> 1), MMap(3 -> 1))))
    val n2 = Node(MMap(2 -> ListBuffer(MMap(3 -> 1), MMap(4 -> 1))))
    var notEmptyGraph = GraphTools.addNode(emptyGraph, n1)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph, n2)
    notEmptyGraph.isArc(n1, n2) should be(true)
    notEmptyGraph.isArc(n2, n1) should be(false)
  }

}
