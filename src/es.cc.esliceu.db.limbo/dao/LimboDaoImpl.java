package es.cc.esliceu.db.limbo.dao;

import es.cc.esliceu.db.limbo.Client;
import es.cc.esliceu.db.limbo.Limbo;
import es.cc.esliceu.db.limbo.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LimboDaoImpl implements LimboDAO {

    @Override
    public void insert(Login user) {

    }

    @Override
    public String read(String dato) {
        System.out.println(dato);
        String result = "";
        String url = "jdbc:mysql://localhost:3307/limbo";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String select = "SELECT username FROM client WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setString(1, dato);
            //System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = rs.getString("username");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }


}
