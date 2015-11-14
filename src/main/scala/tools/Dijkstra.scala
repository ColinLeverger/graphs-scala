package tools

import graph._

/**
  * Created by colinleverger on 30/10/15.
  */
object Dijkstra {

  def applyDijktra(graph: Graph, startingNode: Node) = {
    val X = graph.giveNodes
    var E = startingNode.nodeNumber
    val n = graph.nbNodes

    val D = for {
      i <- 2 to n
    } yield {
      graph.giveNode(E).giveWeightOfThisSuccessor(i)
    }
    D.foreach(println)

  }

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
