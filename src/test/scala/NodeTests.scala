import graph.Node
import org.scalatest._

import scala.collection.mutable.{ListBuffer, Map => MMap}

/**
 * Created by colinleverger on 26/10/15.
 */
class NodeTests extends FunSuite with Matchers {
  //REMINDER : Node is adjacency: MMap[Int, ListBuffer[MMap[Int, Int]]]

  test("number of successor test") {
    val n1 = Node(MMap(1 -> ListBuffer(MMap(1 -> 1))))
    n1.addArc(MMap(2 -> 3))
    n1.numberOfSuccessor should be(2)
    n1.addArc(MMap(22 -> 3))
    n1.numberOfSuccessor should be(3)
  }

  test("remove a node test") {
    val n1 = Node(MMap(1 -> ListBuffer(MMap(1 -> 1))))
    n1.addArc(MMap(2 -> 3))
    n1.delArc(MMap(2 -> 3))
    n1.numberOfSuccessor should be(1)
    n1.addArc(MMap(23 -> 3))
    n1.addArc(MMap(24 -> 3))
    n1.delArc(MMap(23 -> 3))
    n1.numberOfSuccessor should be(2)
  }

}