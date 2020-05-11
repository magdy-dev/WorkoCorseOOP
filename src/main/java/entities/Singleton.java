package entities;

import dao.DAO;

public class Singleton {

    private static DAO firstInstance = null;

    private Singleton(){}

    public static DAO getInstance(){
        if (firstInstance == null){
            firstInstance = new DAO();
        }
        return firstInstance;
    }

}
