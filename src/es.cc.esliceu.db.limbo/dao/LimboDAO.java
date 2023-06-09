package es.cc.esliceu.db.limbo.dao;

import es.cc.esliceu.db.limbo.Client;
import es.cc.esliceu.db.limbo.Limbo;
import es.cc.esliceu.db.limbo.Login;

import java.util.List;

public interface LimboDAO {
    public String insert(String user, String email, String pass, String nom, String llin1, String llin2);
    public String read(String datoUser, String datoBD);
}