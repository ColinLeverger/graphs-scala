import graph.{Graph, Node}
import org.scalatest._

import scala.collection.mutable.{ListBuffer, Map => MMap}

/**
 * Created by colinleverger on 26/10/15.
 */
class NodeTests extends FunSuite with Matchers {
  //REMINDER : Node is adjacency: MMap[Int, ListBuffer[MMap[Int, Int]]]

  test("number of successor test") {
    val n1 = Node(MMap(1 -> ListBuffer(Map(1 -> 1))))
    n1.addArc(Map(2 -> 3))
    n1.numberOfSuccessor should be(2)
    n1.addArc(Map(22 -> 3))
    n1.numberOfSuccessor should be(3)
  }

  test("remove a node test") {
    val n1 = Node(MMap(1 -> ListBuffer(Map(1 -> 1))))
    n1.addArc(Map(2 -> 3))
    n1.delArc(Map(2 -> 3))
    n1.numberOfSuccessor should be(1)
    n1.addArc(Map(23 -> 3))
    n1.addArc(Map(24 -> 3))
    n1.delArc(Map(23 -> 3))
    n1.numberOfSuccessor should be(2)
  }

  test("give me this node test") {
    val n1 = Node(MMap(1 -> ListBuffer(Map(1 -> 1))))
    val n2 = Node(MMap(2 -> ListBuffer(Map(1 -> 1))))
    val n3 = Node(MMap(3 -> ListBuffer(Map(1 -> 1))))
    val graph = new Graph(List(n1, n2, n3))
    graph.giveMeThisNode(1).nodeNumber should be (1)
    graph.giveMeThisNode(1).printNode
  }

  test("give the successor of this node test") {
    val n1 = Node(MMap(1 -> ListBuffer(Map(2 -> 1), Map(3 -> 1), Map(4 -> 1))))
    n1.giveSuccessors should equal(List(2, 3, 4))
  }

}
