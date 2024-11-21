package metier;

import dao.IDao;

public class metierImpl implements Imetier {
    private IDao dao; //couplage faible
    @Override
    public double calcul() {
        double tmp = dao.getData();
        double res = tmp*540/Math.cos(tmp*Math.PI); //un algo compliqué
        return res;
    }

//Set est une méthode qui permet d'injecter dans la var dao unn objet d'une classe qui implémente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
