package es.cc.esliceu.db.limbo.dao;

import es.cc.esliceu.db.limbo.Client;
import es.cc.esliceu.db.limbo.Producte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public String readRegister(String datoUser, String datoPass) {
        String url = "jdbc:mysql://localhost:3306/limbo";
        String username = "root";
        String password = "";

        String result = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String select = "SELECT * FROM client WHERE "+ datoPass +" = ?;";
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setString(1, datoUser);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = rs.getString(datoPass);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public boolean readLogin(String datoUser, String datoPassw) {
        String url = "jdbc:mysql://localhost:3306/limbo";
        String username = "root";
        String password = "";

        boolean encontrado = false;

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

    @Override
    public List<Producte> readProductos() {
        String url = "jdbc:mysql://localhost:3306/limbo";
        String username = "root";
        String password = "";

        List<Producte> listaProductos = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String select = "SELECT nom, descripcio, marca, pvp FROM producte ORDER BY RAND() LIMIT ?";
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setInt(1, 1);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nom");
                String descripcion = rs.getString("descripcio");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("pvp");

                Producte producto = new Producte();
                producto.setNom(nombre);
                producto.setDescripcio(descripcion);
                producto.setMarca(marca);
                producto.setPvp(precio);

                listaProductos.add(producto);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaProductos;
    }



}
