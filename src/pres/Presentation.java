package pres;
import dao.DaoImpl;
import ext.DaoImpl2;
import metier.metierImpl;

public class Presentation {
    public static void main(String[] args) {
        /*
        DaoImpl dao = new DaoImpl();
        metierImpl metier = new metierImpl();
        metier.setDao(dao); //afin de satisfaire les dépendances.
        System.out.println("Le résultat est : "+metier.calcul());
         */

        //Injection des dépendances par instanciation statique => new (couplage fort)
        DaoImpl2 dao = new DaoImpl2();
        metierImpl metier = new metierImpl();
        metier.setDao(dao); //afin de satisfaire les dépendances.
        System.out.println("Le résultat est : "+metier.calcul());
    }
}
