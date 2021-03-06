import graph._
import org.scalatest._

import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 26/10/15.
  */
class NodeTests extends FunSuite with Matchers {

  test("number of successor test") {
    val n1 = Node(adjacency = MMap(1 -> 1), nodeNumber = 1)
    n1.addArc(2, 3)
    n1.numberOfSuccessor should be(2)
    n1.addArc(22, 3)
    n1.numberOfSuccessor should be(3)
  }

  test("successorsList test") {
    val n1 = Node(adjacency = MMap(2 -> 1, 3 -> 1), nodeNumber = 1)
    val n2 = Node(adjacency = MMap(1 -> 1), nodeNumber = 2)
    val n3 = Node(adjacency = MMap(1 -> 1), nodeNumber = 3)

    val graph = new Graph(List(n1, n2, n3))
    n1.getSuccessorsList(graph) should be(List(n2, n3))
  }

  test("remove a node test") {
    val n1 = Node(adjacency = MMap(1 -> 1), nodeNumber = 1)
    n1.addArc(2, 3)
    n1.delArc(2)
    n1.numberOfSuccessor should be(1)
    n1.addArc(23, 3)
    n1.addArc(24, 3)
    n1.delArc(23)
    n1.numberOfSuccessor should be(2)
  }

  test("give me this node test") {
    val n1 = Node(adjacency = MMap(1 -> 1), nodeNumber = 1)
    val n2 = Node(adjacency = MMap(1 -> 1), nodeNumber = 2)
    val n3 = Node(adjacency = MMap(1 -> 1), nodeNumber = 3)
    val graph = new Graph(List(n1, n2, n3))
    graph.getNode(1).nodeNumber should be(1)
  }

  test("give the successor of this node test") {
    val n1 = Node(adjacency = MMap(2 -> 1, 3 -> 1, 4 -> 1), nodeNumber = 1)
    n1.getSuccessorsKeys should equal(List(2, 3, 4))
  }

}
