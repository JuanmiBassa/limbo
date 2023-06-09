package es.cc.esliceu.db.limbo.dao;

import es.cc.esliceu.db.limbo.Client;
import es.cc.esliceu.db.limbo.Limbo;
import es.cc.esliceu.db.limbo.Login;

import java.util.List;

public interface LimboDAO {
    public void insert(Login user);
    public String read(String dato);
}