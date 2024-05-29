public class BellmanFord {
    /**
     * Méthode qui calcule le point fixe d'un graphe g a partir d'un point n
     * @param g
     * @param n
     * @return
     */
    public static Valeur pointfixe(Graphe g, String n ){
        //création de la valeur
        Valeur val = new Valeur();
        //Initialisation de toutes les valeurs donc : 0 pour le String n et =l'infini pour le reste
        for(int i = 0;i<g.listeNoeuds().size();i++){
            if(g.listeNoeuds().get(i).equals(n)){
                val.setValeur(n,0);
            }else{
                val.setValeur(g.listeNoeuds().get(i),Double.MAX_VALUE);
            }
        }
        //boucle
        boolean arret = false;
        while(!arret){
            arret = true;
            //boucle sur les noeuds pour chaque noeud on regardes ces adjacents
            for(int j = 0;j<g.listeNoeuds().size();j++){
                //boucle pour les adjacents
                for(int k = 0;k<g.suivants(g.listeNoeuds().get(j)).size();k++){
                    //recuperation de la valuer du noeud sur lequel je me situe par exemple le noeud a
                    double noeud = val.getValeur(g.listeNoeuds().get(j));
                    //valeur du noeud adjacent donc par exemple le noeud B si il y a un chemin a vers b
                    double noeudadjacent = val.getValeur(g.suivants(g.listeNoeuds().get(j)).get(k).getDestination());
                    //calcule avec la valeur du noeud sur lequel je suis et la valeur du chemin de a vers b (attention pas la valeur de b mais du chemin de a vers b)
                    double min = noeud + g.suivants(g.listeNoeuds().get(j)).get(k).getValeur();
                    //si la valeur et plus petite que celle de l'adjacent il faut la replacer et redefinir le parent de b car peut etre que la valeur d'avant venez de d par exemple
                    if(min <noeudadjacent){
                        //remplacement de la valeur
                        val.setValeur(g.suivants(g.listeNoeuds().get(j)).get(k).getDestination(),min);
                        //remplacement du parent
                        val.setParent(g.suivants(g.listeNoeuds().get(j)).get(k).getDestination(),g.listeNoeuds().get(j));
                        //on continue de boucler car pour le moment on a changé les valeurs donc elles ne sont plus les memes que avant
                        //car si on ne modifie plus les valeurs pour tout les noeuds c'est qu'on a atteint le point fixe
                        arret = false;
                    }
                }

            }
        }
        return val;
    }
}
