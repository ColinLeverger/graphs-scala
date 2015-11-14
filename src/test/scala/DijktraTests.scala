import graph._
import tools.Dijkstra
import org.scalatest._

import scala.collection.mutable.{Map => MMap}

/**
  * Created by colinleverger on 04/11/15.
  */
class DijktraTests extends FunSuite with Matchers {

  test("Dijktra algorithm test - graph provided in the lesson") {
    // Create the nodes we need
    val n1 = Node(1, MMap(2 -> 10, 5 -> 100, 4 -> 30))
    val n2 = Node(2, MMap(3 -> 50))
    val n3 = Node(3, MMap(5 -> 20))
    val n4 = Node(4, MMap(5 -> 60))
    val n5 = Node(5, MMap())

    // Add the nodes inside a new graph
    val g1 = new Graph(List(n1, n2, n3, n4, n5))

    // Apply Warshall on our gaph
    Dijkstra.applyDijktra(g1,n1)
  }

  test("Dijktra algorithm test - 2") {
    println("todo")
  }

}
