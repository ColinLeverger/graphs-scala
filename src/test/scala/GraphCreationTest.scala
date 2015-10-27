import _root_.tools.GraphTools
import org.scalatest._

/**
 * Created by colinleverger on 26/10/15.
 */
class GraphCreationTest extends FunSuite with Matchers {

  test("empty graph creation") {
    val emptyGraph =  GraphTools.createEmptyGraph()

    emptyGraph.isEmpty should be(true)
    emptyGraph.nbNode should be(0)
  }

  test("add node to a graph creation") {
    val emptyGraph =  GraphTools.createEmptyGraph()

    emptyGraph.isEmpty should be(true)
    emptyGraph.nbNode should be(0)

    var notEmptyGraph = GraphTools.addNode(1,emptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)

    notEmptyGraph = GraphTools.addNode(2,notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(2)

    notEmptyGraph = GraphTools.addNode(3,notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(3)

    notEmptyGraph.printGraph
  }

  test("del node to a graph creation") {
    val emptyGraph =  GraphTools.createEmptyGraph()

    emptyGraph.isEmpty should be(true)
    emptyGraph.nbNode should be(0)

    var notEmptyGraph = GraphTools.addNode(1,emptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)

    notEmptyGraph = GraphTools.addNode(2,notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(2)

    notEmptyGraph = GraphTools.removeNode(2,notEmptyGraph)
    notEmptyGraph.isEmpty should be(false)
    notEmptyGraph.nbNode should be(1)

    notEmptyGraph.printGraph
  }
}
