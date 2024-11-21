package dao;

public class DaoImpl  implements IDao{
    @Override
    public double getData(){
        //connection à la base de données afin de recuperer la temperature
        System.out.println("Version BDD");
        double temp = Math.random()*40;
        return temp;
    }
}
