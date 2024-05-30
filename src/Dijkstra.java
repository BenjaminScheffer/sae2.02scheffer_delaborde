import java.util.*;

public class Dijkstra {
    public static Valeur resoudre(Graphe g, String depart){
        //création de la valeur
        List<String> Q= new ArrayList<String>();
        Valeur val = new Valeur();
        //Initialisation de toutes les valeurs donc : 0 pour le String n et =l'infini pour le reste
        for(int i = 0;i<g.listeNoeuds().size();i++){
            val.setValeur(g.listeNoeuds().get(i),Double.MAX_VALUE);
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
            for(int i = 0;i<Q.size();i++){
                for(int j = 0 ; j<g.suivants(u).size();j++){
                    double d = val.getValeur(u) + g.suivants(u).get(j).getValeur() ;
                    if(d<val.getValeur(g.suivants(u).get(j).getDestination())){
                        val.setValeur(g.suivants(u).get(j).getDestination(),d);
                        val.setParent(g.suivants(u).get(j).getDestination(),u);
                    }
                }
            }
        }
        return val;
    }

}
