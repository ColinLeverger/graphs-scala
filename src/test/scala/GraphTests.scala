import graph._
import org.scalatest._

import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 26/10/15.
  */
class GraphTests extends FunSuite with Matchers {

  //Map[Int,List[Map[Int,Int]]]
  test("add node test") {
    val n1 = Node(1,MMap(1 -> 1))
    val n2 = Node(2,MMap(4 -> 1))
    val graph = new Graph(List(n1))
    graph.isEmpty should be(false)
    graph.nbNodes should be(1)
    val updatedGraph = graph.addNode(n2)
    updatedGraph.nbNodes should be(2)
  }

  test("getNodesKeys test") {
    val n1 = Node(1,MMap(1 -> 1))
    val n2 = Node(2,MMap(4 -> 1))
    val graph = new Graph(List(n1,n2))
    graph.getNodesKeys should be (List(1,2))
  }

  test("del node test") {
    val n1 = Node(1,MMap(1 -> 1))
    val n2 = Node(2,MMap(4 -> 1))
    val n3 = Node(3,MMap(5 -> 1))
    val graph = new Graph(List(n1, n2, n3))
    graph.nbNodes should be(3)

    var updatedGraph = graph.delNode(n1)
    updatedGraph.nbNodes should be(2)
    updatedGraph = updatedGraph.delNode(n2)
    updatedGraph.nbNodes should be(1)
  }

  test("connexion between nodes test") {
    val n1 = Node(1,MMap(2 -> 1, 3 -> 1))
    val n2 = Node(2,MMap(3 -> 1, 4 -> 1))
    val graph = new Graph(List(n1, n2))
    graph.isArc(1, 2) should be(true)
    graph.isArc(2, 1) should be(false)
  }

  test("nbNode test") {
    val n1 = Node(1,MMap(2 -> 1, 3 -> 1))
    val n2 = Node(2,MMap(3 -> 1, 4 -> 1))
    val graph = new Graph(List(n1, n2))
    graph.nbNodes should be(2)
  }

  test("positive weight between nodes test") {
    val n1 = Node(1,MMap(2 -> 23, 3 -> 24))
    val graph = new Graph(List(n1))

    graph.warshallWeightBetweenTheseTwoNodes(1, 2) should be(23)
    graph.warshallWeightBetweenTheseTwoNodes(1, 3) should be(24)
    graph.warshallWeightBetweenTheseTwoNodes(1, 4) should be(-1)
  }

}
