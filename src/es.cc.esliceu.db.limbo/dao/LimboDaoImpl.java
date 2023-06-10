package es.cc.esliceu.db.limbo.dao;

import java.sql.*;

public class LimboDaoImpl implements LimboDAO {

    @Override
    public String insert(String user, String email, String pass, String nom, String llin1, String llin2) {
        String url = "jdbc:mysql://localhost:3306/limbo";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String consulta = "INSERT INTO `client` (`email`, `nom`, `cognom1`, `cognom2`, `username`, `contrasenya`) " +
                    "VALUES ('"+email+"','"+nom+"','"+llin1+"','"+llin2+"','"+user+"','"+pass+"');";
            System.out.println("Usuario "+user+" creado correctamente, ID:");
            statement.execute(consulta);
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return url;
    }

    @Override
    public String readRegister(String datoUser, String datoBD) {
        String result = "";
        String url = "jdbc:mysql://localhost:3306/limbo";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String select = "SELECT username FROM client WHERE "+ datoBD +" = ?";
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setString(1, datoUser);
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

    @Override
    public boolean readLogin(String datoUser, String datoPassw) {
        boolean encontrado = false;
        String url = "jdbc:mysql://localhost:3306/limbo";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String select = "SELECT * FROM `client` WHERE username = ? AND contrasenya = ?;";
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setString(1, datoUser);
            statement.setString(2, datoPassw);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                encontrado = true;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return encontrado;
    }


}
