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

    val Dtemp = for {
      i <- 2 to n
    } yield {
      graph.getNode(1).dijkstraWeightOfThisSuccessor(i)
    }

    for {
      i <- 2 to n
      (tWeight, tNodeNumber) = chooseT(Dtemp)
      if (!E.contains(tNodeNumber))
    } {
      E = tNodeNumber :: E
      for {
        xKey <- graph.getNode(tNodeNumber).getSuccessorsKeys
      } {
        println("xKey : " + xKey)
        val x = graph.getNode(xKey)
        val t = graph.getNode(tNodeNumber)
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
  def chooseT(D: IndexedSeq[Int]): (Int, Int) = (D.zipWithIndex.min._1, D.zipWithIndex.min._2 + 2)

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
