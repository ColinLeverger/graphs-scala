import _root_.tools.GraphTools
import graph.Node
import org.scalatest._

/**
 * Created by colinleverger on 26/10/15.
 */
class GraphCreationTest extends FunSuite with Matchers {

  test("empty graph creation") {
    val emptyGraph = GraphTools.createEmptyGraph()

    emptyGraph.isEmpty should be(true)
    emptyGraph.nbNode should be(0)
  }

  test("add node to a graph creation") {
    val emptyGraph = GraphTools.createEmptyGraph()

    var notEmptyGraph = GraphTools.addNode(emptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)

    notEmptyGraph = GraphTools.addNode(notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(2)

    notEmptyGraph = GraphTools.addNode(notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(3)
  }

  test("del node to a graph creation") {
    val emptyGraph = GraphTools.createEmptyGraph()

    var notEmptyGraph = GraphTools.addNode(emptyGraph)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph)

    notEmptyGraph = GraphTools.delNode(1, notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)
  }

  test("add connection between two nodes on a graph") {
    val emptyGraph = GraphTools.createEmptyGraph()

    var notEmptyGraph = GraphTools.addNode(emptyGraph)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph)

    notEmptyGraph = GraphTools.addArc(Node(1), Node(2), notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(3)

    notEmptyGraph.isArc(Node(1), Node(2)) should be(true)

  }

  test("del connection between two nodes on a graph") {
    val emptyGraph = GraphTools.createEmptyGraph()

    var notEmptyGraph = GraphTools.addNode(emptyGraph)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph)
    notEmptyGraph = GraphTools.addNode(notEmptyGraph)

    notEmptyGraph = GraphTools.addArc(Node(1), Node(2), notEmptyGraph)
    notEmptyGraph = GraphTools.delArc(Node(1), Node(2), notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(3)

    notEmptyGraph.isArc(Node(1), Node(2)) should be(false)
  }
}
