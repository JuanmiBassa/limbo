package es.cc.esliceu.db.limbo.dao;

import es.cc.esliceu.db.limbo.Client;

import java.sql.*;

public class LimboDaoImpl implements LimboDAO {

    @Override
    public String insert(String user, String email, String pass, String nom, String llin1, String llin2) {
        String url = "jdbc:mysql://localhost:3307/limbo";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String consulta = "INSERT INTO `client` (`email`, `nom`, `cognom1`, `cognom2`, `username`, `contrasenya`) " +
                    "VALUES ('"+email+"','"+nom+"','"+llin1+"','"+llin2+"','"+user+"','"+pass+"');";
            System.out.println("Insertando a la BBDD el nuevo usuario: "+user);
            statement.execute(consulta);
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return url;
    }

    @Override
    public String read(String datoUser, String datoBD) {
        System.out.println(datoUser);
        String result = "";
        String url = "jdbc:mysql://localhost:3307/limbo";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String select = "SELECT username FROM client WHERE "+ datoBD +" = ?";
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setString(1, datoUser);
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
