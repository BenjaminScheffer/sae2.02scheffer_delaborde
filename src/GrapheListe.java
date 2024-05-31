import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements  Graphe{

    /** Attribut
     * Liste de noeuds du graphe
     */
    private ArrayList<String> noeuds;

    /** Attribut
     * liste des arcs qui partent de chaque noeud du graphe
     */
    private ArrayList<Arcs> adjacence;

    /**
     * constructeur de la classe GrapheListe
     */
    public GrapheListe () {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }
    /**
    *Constructeur qui prend en parametre le nom d'un fichier et qui construit le graphe correspondant
     * @param s string du nom du fichier
     */
    public GrapheListe(String s ) throws IOException {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(s));
        String ligne = br.readLine();
        while(ligne != null){
            String []lignesplit = ligne.split("\t");
            String sommetdep = lignesplit[0];
            String sommetdestination = lignesplit[1];
            double val = Double.parseDouble(lignesplit[2]);
            this.ajouterArc(sommetdep,sommetdestination,val);
            ligne = br.readLine();
        }
        br.close();
    }
    /**
     * Méthode qui permet d'ajouter un arc
     * @param depart noeud de depart de l'arc
     * @param destination noeud d'arriver de l'arc
     * @param cout valeur de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        if (!noeuds.contains(depart)){
            noeuds.add(depart);
            int indice  = getIndice(depart);
            this.adjacence.add(indice, new Arcs());
        }
        if (!noeuds.contains(destination)){
            noeuds.add(destination);
            int indice  = getIndice(destination);
            this.adjacence.add(indice, new Arcs());
        }
        int indexDepart = getIndice(depart);

        try{
            Arcs list = this.adjacence.get(indexDepart);
            int i = 0;
            boolean arret = false;
            while (!arret && i!=list.getArcs().size()){
                if(list.getArcs().get(i).getDestination().equals(destination)){
                    arret = true;
                }
                i++;
            }
            if(arret){
                list.getArcs().get(i).setValeur(cout);
            }else{
                list.getArcs().add(new Arc(destination,cout));
            }
        }catch(IndexOutOfBoundsException e ){
            Arcs arc = new Arcs();
            arc.ajouterArc(new Arc(destination, cout));
            this.adjacence.add(indexDepart, arc);
        }
    }



    /**
     * Méthode qui permet de recuperer l'indice d'un noeud dans la liste de noeud
     * @param n noeud dont on souhaite recupérer l'indice
     * @return l'indice du noeud n
     */
    public int getIndice(String n){
        return this.noeuds.indexOf(n);
    }

    /**
     * To string qui affiche le graphe
     * @return
     */
    public String toString(){
            String s = "";
            for (int i = 0; i < this.noeuds.size(); i++) {
                s = s + this.noeuds.get(i) + "=> ";
                for (int j = 0; j < this.adjacence.get(i).getArcs().size(); j++) {
                    s = s + this.adjacence.get(i).getArcs().get(j).getDestination() + "(" + this.adjacence.get(i).getArcs().get(j).getValeur() + ")" + ", ";
                }
                s = s + "\n";
            }
            return s;
    }


    /**
     * Méthode qui permet de récuperer la liste de noeuds
     * @return la liste de noeuds
     */
    @Override
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     * Méthode qui permet de connaitre les arcs que possède un noeud
     * @param n noeud dont on veut connaitre ses arcs
     * @return la liste des arcs partant du nœud n passée en paramètre.
     */
    @Override
    public List<Arc> suivants(String n) {
        int index = getIndice(n);
        return this.adjacence.get(index).getArcs();
    }
}
