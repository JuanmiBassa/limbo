package es.cc.esliceu.db.limbo;

import es.cc.esliceu.db.limbo.dao.LimboDAO;
import es.cc.esliceu.db.limbo.dao.LimboDaoImpl;
import es.cc.esliceu.db.limbo.util.Color;

import java.util.ArrayList;
import java.util.List;

import static es.cc.esliceu.db.limbo.Limbo.*;

public class Opciones {
    public static void opcionesProcess(String usuarioBD) {
        LimboDAO limboDAO = new LimboDaoImpl();
        titulo("**************************");
        titulo("**       Opciones       **");
        info("Usuario: ", usuarioBD);
        titulo("**************************");
        info("c)", " Buscar productos");
        info("v)", " Ver Cesta");
        info("d)", " Datos personales");
        info("h)", " Ayuda");
        info("x)", " Salir");

        error("---------------  Productos sugeridos  ---------------");
        for (int i = 0; i < 5; i++) {
            List<Producte> listaProductos = limboDAO.readProductos();
            imprimirProductos(listaProductos);
        }
        error("-----------------------------------------------------");
        info("(0-4)", " Productos sugeridos");
        oblitatorio("Escoge una opción:");

    }

    public static void imprimirProductos(List<Producte> listaProductos) {
        for (Producte producto : listaProductos) {
            System.out.println(producto.getNom() + " | " +
                    producto.getDescripcio() + " | " +
                    Color.CYAN + producto.getMarca() + Color.RESET + " | " +
                    Color.BLUE_BOLD + producto.getPvp() + "€" + Color.RESET);
        }
    }
}
