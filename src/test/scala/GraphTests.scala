import _root_.tools.GraphTools
import graph.Node
import org.scalatest._

import scala.collection.mutable.{Map => MMap}

/**
 * Created by colinleverger on 26/10/15.
 */
class GraphTests extends FunSuite with Matchers {

  test("empty graph creation") {
    val emptyGraph = GraphTools.createEmptyGraph
    emptyGraph.isEmpty should be(true)
    emptyGraph.nbNode should be(0)
  }

  //Map[Int,List[Map[Int,Int]]]
  test("add node test") {
    val emptyGraph = GraphTools.createEmptyGraph
    val n1 = Node(Map(1 -> MMap(1 -> 1)))
    val notEmptyGraph = emptyGraph.addNode(n1)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)
  }

  test("del node test") {
    val emptyGraph = GraphTools.createEmptyGraph
    val n1 = Node(Map(1 -> MMap(1 -> 1)))
    val n2 = Node(Map(2 -> MMap(4 -> 1)))
    var notEmptyGraph = emptyGraph.addNode(n1)
    notEmptyGraph = notEmptyGraph.addNode(n2)
    notEmptyGraph = notEmptyGraph.delNode(n2)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)
  }

  test("connexion between nodes test") {
    val emptyGraph = GraphTools.createEmptyGraph
    val n1 = Node(Map(1 -> MMap(2 -> 1,3 -> 1)))
    val n2 = Node(Map(2 ->MMap(3 -> 1,4 -> 1)))
    var notEmptyGraph = emptyGraph.addNode(n1)
    notEmptyGraph = notEmptyGraph.addNode(n2)
    notEmptyGraph.isArc(1, 2) should be(true)
    notEmptyGraph.isArc(2, 1) should be(false)
  }

  test("weight between nodes test") {
    val emptyGraph = GraphTools.createEmptyGraph
    val n1 = Node(Map(1 -> MMap(2 -> 23, 3 -> 24)))
    val notEmptyGraph = emptyGraph.addNode(n1)

    //notEmptyGraph.weightBetweenTheseTwoArcs(1, 2) should be(23)
  }

}
