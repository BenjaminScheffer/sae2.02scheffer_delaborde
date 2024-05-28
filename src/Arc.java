public class Arc {
    /** Attributs
     * un attribut de destinations et de valeur.
     */
    private String destination;
    private double valeur;

    /**
     * Constructeur qui initialise un Arc avec ça destination et la valeur de l'arc
     * @param d
     * @param v
     */
    public Arc(String d, double v){
        this.destination = d;
        this.valeur = v;
    }

    /**
     * Getter de la destination
     * @return
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Getter de la valeur de l'arc
     * @return
     */
    public double getValeur() {
        return valeur;
    }
}
