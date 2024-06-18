import java.util.*;

public class Dijkstra {
    /*
    * Entrées :
G un graphe orient´e avec une pond´eration positive des arcs (co^ut ou poids)
A un sommet (d´epart) de G

Début
    Q <- {} // utilisation d’une liste de noeuds `a traiter
    Pour chaque sommet v de G faire
        v.valeur <- Infini
        v.parent <- Ind´efini
        Q <- Q U {v} // ajouter le sommet v `a la liste Q
    Fin Pour
    A.valeur <- 0
    Tant que Q est un ensemble non vide faire
        u <- un sommet de Q telle que u.valeur est minimal
        // enlever le sommet u de la liste Q
        Q <- Q \ {u}
        Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
            d <- u.valeur + poids(u,v)
            Si d < v.valeur
                // le chemin est plus interessant
                Alors v.valeur <- d
                    v.parent <- u
            Fin Si
        Fin Pour
    Fin Tant que
Fin
* */
    public static Valeur resoudre(Graphe g, String depart){
        //création de la valeur
        List<String> Q= new ArrayList<String>();
        Valeur val = new Valeur();
        //Initialisation de toutes les valeurs donc : 0 pour le String n et =l'infini pour le reste
        for(int i = 0;i<g.listeNoeuds().size();i++){
            val.setValeur(g.listeNoeuds().get(i),Double.MAX_VALUE);
            val.setParent(g.listeNoeuds().get(i),null);
            Q.add(g.listeNoeuds().get(i));
        }
        val.setValeur(depart,0);
        while(!Q.isEmpty()){
            double min = Double.MAX_VALUE;
            int indice = 0;

            for(int i = 0; i < Q.size();i++){
                if(val.getValeur(Q.get(i))<min){
                    indice = i;
                }
            }
            String u = Q.get(indice);
            Q.remove(indice);
            if(g.suivants(u)==null){
                return val;
            }
                for(int j = 0 ; j<g.suivants(u).size();j++){
                    double d = val.getValeur(u) + g.suivants(u).get(j).getValeur() ;
                    if(d<val.getValeur(g.suivants(u).get(j).getDestination())){
                        val.setValeur(g.suivants(u).get(j).getDestination(),d);
                        val.setParent(g.suivants(u).get(j).getDestination(),u);
                    }
                }

        }
        return val;
    }

}
