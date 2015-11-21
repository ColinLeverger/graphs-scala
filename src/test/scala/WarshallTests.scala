import graph._
import tools._
import org.scalatest._

import scala.collection.mutable.{Map => MMap}

/**
 * Created by colinleverger on 04/11/15.
 */
class WarshallTests extends FunSuite with Matchers {

  test("Warshall algorithm test - graph provided in the lesson") {
    // Create the nodes we need
    val n1 = Node(1,MMap(2 -> 1, 4 -> 1))
    val n2 = Node(2,MMap(3 -> 1, 5 -> 1))
    val n3 = Node(3,MMap(5 -> 1))
    val n4 = Node(4,MMap(3 -> 1))
    val n5 = Node(5,MMap(4 -> 1))
    val n6 = Node(6,MMap(3 -> 1, 5 -> 1))

    // Add the nodes inside a new graph
    val g1 = new Graph(List(n1, n2, n3, n4, n5, n6))

    // Apply Warshall on our graph
    Warshall.applyWarshall(g1)

    // Check the output: is my Warshall function doing the good things ?
    g1.getNode(1).getSuccessorsKeys should be(List(2, 3, 4, 5))
    g1.getNode(2).getSuccessorsKeys should be(List(3, 4, 5))
    g1.getNode(3).getSuccessorsKeys should be(List(3, 4, 5))
    g1.getNode(4).getSuccessorsKeys should be(List(3, 4, 5))
    g1.getNode(5).getSuccessorsKeys should be(List(3, 4, 5))
    g1.getNode(6).getSuccessorsKeys should be(List(3, 4, 5))
  }

  test("Warshall algorithm test - graph provided in the exam") {
    // Create the nodes we need
    val n1 = Node(1,MMap(2 -> 1,3 ->1))
    val n2 = Node(2,MMap(3 -> 1, 4 -> 1))
    val n3 = Node(3,MMap(4 -> 1))
    val n4 = Node(4,MMap())

    // Add the nodes inside a new graph
    val g1 = new Graph(List(n1, n2, n3, n4))

    // Apply Warshall on our graph
    Warshall.applyWarshall(g1)

    // Check the output: is my Warshall function doing the good things ?
    g1.getNode(1).getSuccessorsKeys should be(List(2, 3, 4))
    g1.getNode(2).getSuccessorsKeys should be(List(3, 4))
    g1.getNode(3).getSuccessorsKeys should be(List(4))
    g1.getNode(4).getSuccessorsKeys should be(List())
  }

}
