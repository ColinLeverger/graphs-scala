import graph._
import tools._
import org.scalatest._

import scala.collection.mutable.{ListBuffer, Map => MMap}

/**
 * Created by colinleverger on 04/11/15.
 */
class WarshallTests extends FunSuite with Matchers {

  test("Warshall algorithm test"){
    val n1 = Node(MMap(1 -> ListBuffer(Map(2 -> 1),Map(4 -> 1))))
    val n2 = Node(MMap(2 -> ListBuffer(Map(3 -> 1),Map(5 -> 1))))
    val n3 = Node(MMap(3 -> ListBuffer(Map(5 -> 1))))
    val n4 = Node(MMap(4 -> ListBuffer(Map(3 -> 1))))
    val n5 = Node(MMap(5 -> ListBuffer(Map(4 -> 1))))
    val n6 = Node(MMap(6 -> ListBuffer(Map(3 -> 1),Map(5 -> 1))))

    val g1 = Graph(List(n1,n2,n3,n4,n5,n6))

    println("\nprint g1 first")
    g1.printGraph

    val g2 = Warshall.doWarshall(g1)

    println("\nprint g1 second")
    g1.printGraph

    println("\nprint g2 first")
    g2.printGraph
  }

}
