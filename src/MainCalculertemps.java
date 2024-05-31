import java.io.File;
import java.io.IOException;

public class MainCalculertemps {
    public static void main(String[] args) throws Exception {
        String chemin = "graphes/";
        File repertoire =new File(chemin);
        String [] list = repertoire.list();
        long debuttime=System.nanoTime();
        for(int i = 0 ; i<list.length;i++){
            GrapheListe g = new GrapheListe(chemin+list[i]);
            Valeur v = BellmanFord.pointfixe(g,"1");
        }
        long fintime = System.nanoTime();
        long temps = fintime-debuttime;
        System.out.println(temps/1000000000);
        debuttime = System.nanoTime();
        for (int i = 0;i< list.length;i++){
            GrapheListe g = new GrapheListe(chemin+list[i]);
            Valeur v = Dijkstra.resoudre(g,"1");
        }
        fintime=System.nanoTime();
        temps = fintime-debuttime;
        System.out.println(temps/1000000000);
    }
}
