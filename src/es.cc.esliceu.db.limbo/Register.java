package es.cc.esliceu.db.limbo;

import es.cc.esliceu.db.limbo.dao.LimboDAO;
import es.cc.esliceu.db.limbo.dao.LimboDaoImpl;

import java.util.List;
import java.util.Scanner;

import static es.cc.esliceu.db.limbo.Limbo.info;

public class Register {
    public static void registerProcess() {
        LimboDAO limboDAO = new LimboDaoImpl();

        System.out.println("**************************");
        System.out.println("**      Registre        **");
        System.out.println("**************************");
        String username = "";
        String email = "";
        info("Dime un nombre de usuario:");
        while (true) {
            Scanner pregLogin1 = new Scanner(System.in);
            username = pregLogin1.nextLine();
            if (username != "") {
                String listaUser = limboDAO.read(username);
                System.out.println(listaUser);
                if (!listaUser.isEmpty()) {
                    System.out.println("\u001B[33mEl nombre de usuario ya existe, Introduce otro.\u001B[0m");
                } else {
                    System.out.println("Email:");
                    Scanner pregLogin2 = new Scanner(System.in);
                    email = pregLogin2.nextLine();
                    break;
                }
            } else {
                System.out.println("\u001B[33mEl nombre de usuario no puede estar vacío.\u001B[0m");
            }
        }
        String password = "";
        if (email != "") {
            System.out.println("Password:");
            Scanner pregLogin3 = new Scanner(System.in);
            password = pregLogin3.nextLine();
        } else System.out.println("\u001B[33mEl Email no puede estar vacío.\u001B[0m");
        String nom = "";
        if (password != "") {
            System.out.println("Nom:");
            Scanner pregLogin4 = new Scanner(System.in);
            nom = pregLogin4.nextLine();
        } else System.out.println("\u001B[33mEl nombre no puede estar vacío.\u001B[0m");
        String llin1 = "";
        if (nom != "") {
            System.out.println("Llinatge1:");
            Scanner pregLogin5 = new Scanner(System.in);
            llin1 = pregLogin5.nextLine();
        } else System.out.println("\u001B[33mEl Primer apellido no puede estar vacío.\u001B[0m");
        String llin2 = "";
        if (llin1 != "") {
            System.out.println("Llinatge1:");
            Scanner pregLogin6 = new Scanner(System.in);
            llin2 = pregLogin6.nextLine();
        }
    }
}
