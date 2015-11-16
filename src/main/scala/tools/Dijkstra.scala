package tools

import graph._

/**
  * Created by colinleverger on 30/10/15.
  */
object Dijkstra {

  def applyDijktra(graph: Graph): List[Int] = {
    val X = graph.getNodes
    var E = List(1)
    val n = graph.nbNodes

    val Dinit = for {
      i <- 2 to n
    } yield {
      graph.getNode(1).dijkstraWeightOfThisSuccessor(i)
    }

    var Dtemp = 0 :: Dinit.toList
    println("First initialized Dtemp = " + Dinit)


    for {
      i <- 2 to n
      (tWeight, tNodeNumber) = chooseT(Dtemp)
    } {
      if (!E.contains(tNodeNumber)) {
        println("\ndebug " + i)
        println("tNodeNumber : " + tNodeNumber)
        println("tWeight : " + tWeight)
        E = tNodeNumber :: E
        println("E : " + E)
        for {
          x <- graph.getNode(tNodeNumber).getSuccessorsKeys
        } {
          println("x: " +x)
          val node = graph.getNode(x)
          println("\nnode : " + node)
          println("Dtemp before : ")
          Dtemp.foreach(println)
          println("Dtemp(x) : " + Dtemp(x-1))
          println("Dtemp(tNodeNumber) : " + Dtemp(tNodeNumber))
          println("node.dijkstraWeightOfThisSuccessor(x) : " + node.dijkstraWeightOfThisSuccessor(x))
          Dtemp.patch(x - 1, List(min(Dtemp(x-1), Dtemp(tNodeNumber) + node.dijkstraWeightOfThisSuccessor(x))), 1)
          println("Dtemp after: ")
          Dtemp.foreach(println)
        }
      }
    }
    val D = 0 :: Dtemp.toList
    D
  }

  /**
    * Choose T with the shortest path.
    * Return the Weight and the nodeNumber of this node
    * @param D
    * @return
    */
  def chooseT(D: List[Int]): (Int, Int) = (D.zipWithIndex.min._1, D.zipWithIndex.min._2 + 2)

  /**
    * Choose the min between to ints
    * @param a
    * @param b
    * @return min
    */
  def min(a: Int, b: Int): Int = List(a, b).min

  /*
    permet de connaitre le poids du chemin le plus court
X = {1,2,…,n}
S= 1
P[i,j] = poids de l'arc (i,j)
D[i] = plus courte distance courante de s(i) à i
X-E = nœuds accessibles
Debut
E = {1}
pour i de 2 à n faire
D[i] <- P[1,i]
finpour

pour i de 2 à n faire
choisir t parmi X-E tel que D[t] soit min
ajouter t à E
pour chaque x successeur de t faire
D[x] = min(D[x],D[t]+P[x,t])
finpour
finpour
fin
    */

}
