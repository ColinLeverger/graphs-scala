import _root_.tools.Dijkstra
import graph._
import org.scalatest._

import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 04/11/15.
  */
class DijktraTests extends FunSuite with Matchers {

  test("Dijktra algorithm test - first graph provided in the lesson") {
    // Create the nodes we need
    val n1 = Node(1, MMap(2 -> 10, 5 -> 100, 4 -> 30))
    val n2 = Node(2, MMap(3 -> 50))
    val n3 = Node(3, MMap(5 -> 10))
    val n4 = Node(4, MMap(5 -> 60, 3 -> 20))
    val n5 = Node(5, MMap())

    // Add the nodes inside a new graph
    val g1 = new Graph(List(n1, n2, n3, n4, n5))

    // Apply Dijktra on our gaph
    val (dist, prev) = Dijkstra.applyDijkstra(g1, n1)

    // Check the output
    Dijkstra.giveShortestPathWeight(n5, dist) should be(60)
    Dijkstra.giveShortestPathWeight(n4, dist) should be(30)
    Dijkstra.giveShortestPathWeight(n3, dist) should be(50)
    Dijkstra.giveShortestPathWeight(n2, dist) should be(10)
    Dijkstra.giveShortestPathWeight(n1, dist) should be(0)

    Dijkstra.giveShortestPath(n5.nodeNumber, prev) should be(List(4, 3, 5))
    Dijkstra.giveShortestPath(n4.nodeNumber, prev) should be(List(4))
    Dijkstra.giveShortestPath(n3.nodeNumber, prev) should be(List(4, 3))
    Dijkstra.giveShortestPath(n2.nodeNumber, prev) should be(List(2))
    Dijkstra.giveShortestPath(n1.nodeNumber, prev) should be(List())
  }

  test("Dijktra algorithm test - second graph provided in the lesson") {
    // Create the nodes we need
    val n1 = Node(1, MMap(2 -> 2, 3 -> 5, 4 -> 4))
    val n2 = Node(2, MMap(5 -> 7, 3 -> 2, 1 -> 2))
    val n3 = Node(3, MMap(5 -> 4, 2 -> 2, 1 -> 5, 4 -> 1, 6 -> 3))
    val n4 = Node(4, MMap(6 -> 4, 3 -> 1, 1 -> 4))
    val n5 = Node(5, MMap(2 -> 7, 3 -> 4, 6 -> 1, 7 -> 5))
    val n6 = Node(6, MMap(3 -> 3, 7 -> 7, 5 -> 1))
    val n7 = Node(7, MMap(5 -> 5, 6 -> 7))

    // Add the nodes inside a new graph
    val g1 = new Graph(List(n1, n2, n3, n4, n5, n6, n7))

    // Apply Dijktra on our graph
    val (dist, prev) = Dijkstra.applyDijkstra(g1, n1)

    // Check the output
    Dijkstra.giveShortestPathWeight(n7, dist) should be(13)
    Dijkstra.giveShortestPathWeight(n6, dist) should be(7)
    Dijkstra.giveShortestPathWeight(n5, dist) should be(8)
    Dijkstra.giveShortestPathWeight(n4, dist) should be(4)
    Dijkstra.giveShortestPathWeight(n3, dist) should be(4)
    Dijkstra.giveShortestPathWeight(n2, dist) should be(2)
    Dijkstra.giveShortestPathWeight(n1, dist) should be(0)

    Dijkstra.giveShortestPath(n7.nodeNumber, prev) should be(List(2, 3, 5, 7))
    Dijkstra.giveShortestPath(n6.nodeNumber, prev) should be(List(2, 3, 6))
  }

}
