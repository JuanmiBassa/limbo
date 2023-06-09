package es.cc.esliceu.db.limbo.dao;

import es.cc.esliceu.db.limbo.Producte;

import java.util.List;

public interface LimboDAO {
    public String insert(String user, String email, String pass, String nom, String llin1, String llin2);
    public String readRegister(String datoUser, String datoBD);
    public boolean readLogin(String datoUser, String datoPass);
    public List<Producte> readProductos();
}