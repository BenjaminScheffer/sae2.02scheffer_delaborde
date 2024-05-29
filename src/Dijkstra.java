public class Dijkstra {
    public Valeur resoudre(Graphe g, String depart){
        //création de la valeur
        String []Q= new String[g.listeNoeuds().size()];
        Valeur val = new Valeur();
        //Initialisation de toutes les valeurs donc : 0 pour le String n et =l'infini pour le reste
        for(int i = 0;i<g.listeNoeuds().size();i++){
            Q[i] = g.listeNoeuds().get(i);
            if(g.listeNoeuds().get(i).equals(depart)){
                val.setValeur(depart,0);
            }else{
                val.setValeur(g.listeNoeuds().get(i),Double.MAX_VALUE);
            }
        }
        while(!Q.)
    }

}
