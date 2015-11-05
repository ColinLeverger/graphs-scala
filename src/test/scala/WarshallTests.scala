import graph._
import tools._
import org.scalatest._

import scala.collection.mutable.{Map => MMap}

/**
 * Created by colinleverger on 04/11/15.
 */
class WarshallTests extends FunSuite with Matchers {

  test("Warshall algorithm test - use of the Graph provided in the lesson") {
    // Create the nodes we need
    val n1 = Node(Map(1 -> MMap(2 -> 1, 4 -> 1)))
    val n2 = Node(Map(2 -> MMap(3 -> 1, 5 -> 1)))
    val n3 = Node(Map(3 -> MMap(5 -> 1)))
    val n4 = Node(Map(4 -> MMap(3 -> 1)))
    val n5 = Node(Map(5 -> MMap(4 -> 1)))
    val n6 = Node(Map(6 -> MMap(3 -> 1, 5 -> 1)))

    // Add the nodes inside a new graph
    val g1 = new Graph(List(n1, n2, n3, n4, n5, n6))

    // Apply Warshall on our gaph
    Warshall.applyWarshall(g1)

    // Check the output: is my Warshall function doing the good things ?
    g1.giveNode(1).giveSuccessorsKeys should be(List(2, 3, 4, 5))
    g1.giveNode(2).giveSuccessorsKeys should be(List(3, 4, 5))
    g1.giveNode(3).giveSuccessorsKeys should be(List(3, 4, 5))
    g1.giveNode(4).giveSuccessorsKeys should be(List(3, 4, 5))
    g1.giveNode(5).giveSuccessorsKeys should be(List(3, 4, 5))
    g1.giveNode(6).giveSuccessorsKeys should be(List(3, 4, 5))
  }

}
