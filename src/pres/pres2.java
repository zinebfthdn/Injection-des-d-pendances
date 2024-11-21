package pres;

import dao.IDao;
import metier.Imetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException
    //InstantiationException : si on a pas de constructeur par défaut
    public static void main(String[] args) throws Exception {
        //Instanciation dynamique et pas statique
        Scanner scanner = new Scanner(new File("config.txt"));//Il va lire le fichier txt afin de savoir les diff classes qu'on va utiliser
        /* Pour instanciation dynamique :
        Il faut connaitre le nom de la classe
        Il faut charger classe au mémoire
        et puis instancier la classe
         */
        String dapClassName = scanner.nextLine();
        Class cDao = Class.forName(dapClassName);//On a chargé la classe dans mémoire
        IDao dao = (IDao) cDao.newInstance();//instancier une classe qui n'est pas de type idao (class cast exception)
        System.out.println(dao.getData());

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        Imetier metier = (Imetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao", IDao.class);
        //metier.set(dao) =>statique
        method.invoke(metier, dao); //invoke cad j'éxecute la methode method sur l'objet metier avec transmission de parametres dao
        System.out.println("Résultat est : " +metier.calcul());
    }
}
