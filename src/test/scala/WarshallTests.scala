import graph._
import tools._
import org.scalatest._

import scala.collection.mutable.{ListBuffer, Map => MMap}

/**
 * Created by colinleverger on 04/11/15.
 */
class WarshallTests extends FunSuite with Matchers {

  test("Warshall algorithm test - use of the Graph provided in the lesson") {
    val n1 = Node(MMap(1 -> ListBuffer(Map(2 -> 1),Map(4 -> 1))))
    val n2 = Node(MMap(2 -> ListBuffer(Map(3 -> 1),Map(5 -> 1))))
    val n3 = Node(MMap(3 -> ListBuffer(Map(5 -> 1))))
    val n4 = Node(MMap(4 -> ListBuffer(Map(3 -> 1))))
    val n5 = Node(MMap(5 -> ListBuffer(Map(4 -> 1))))
    val n6 = Node(MMap(6 -> ListBuffer(Map(3 -> 1),Map(5 -> 1))))

    val g1 = new Graph(List(n1, n2, n3, n4, n5, n6))

    Warshall.applyWarshall(g1)

    g1.giveMeThisNode(1).giveSuccessors should be(List(2, 3, 4, 5))
    g1.giveMeThisNode(2).giveSuccessors should be(List(3, 4, 5))
    g1.giveMeThisNode(3).giveSuccessors should be(List(3, 4, 5))
    g1.giveMeThisNode(4).giveSuccessors should be(List(3, 4, 5))
    g1.giveMeThisNode(5).giveSuccessors should be(List(3, 4, 5))
    g1.giveMeThisNode(6).giveSuccessors should be(List(3, 4, 5))
  }

}
