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

    // Apply Warshall on our gaph
    val (dist, prev) = Dijkstra.applyDijkstra(g1, n1)

    // Check the output
    Dijkstra.giveShortestPathWeight(n5,dist) should be (60)
    Dijkstra.giveShortestPathWeight(n4,dist) should be (30)
    Dijkstra.giveShortestPathWeight(n3,dist) should be (50)
    Dijkstra.giveShortestPathWeight(n2,dist) should be (10)
    Dijkstra.giveShortestPathWeight(n1,dist) should be (0)

    Dijkstra.giveShortestPath(n5.nodeNumber,prev) should be (List(4,3,5))
    Dijkstra.giveShortestPath(n4.nodeNumber,prev) should be (List(4))
    Dijkstra.giveShortestPath(n3.nodeNumber,prev) should be (List(4,3))
    Dijkstra.giveShortestPath(n2.nodeNumber,prev) should be (List(2))
    Dijkstra.giveShortestPath(n1.nodeNumber,prev) should be (List())
  }

  test("Dijktra algorithm test - second graph provided in the lesson") {
    // Create the nodes we need
    val S = Node(1, MMap(2 -> 10, 5 -> 100, 4 -> 30))
    val n2 = Node(2, MMap(3 -> 50))
    val n3 = Node(3, MMap(5 -> 10))
    val n4 = Node(4, MMap(5 -> 60, 3 -> 20))
    val n5 = Node(5, MMap())
  }

}
