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
        String username;
        String email;
        String password;
        String nom;
        String llin1 = "";
        String llin2 = "";

        info("Dime un nombre de usuario:");
        while (true) {
            Scanner pregLogin1 = new Scanner(System.in);
            username = pregLogin1.nextLine();
            if (username != "") {
                String listaUser = limboDAO.read(username, "username");
                if (!listaUser.isEmpty()) {
                    System.out.println("\u001B[33mEl nombre de usuario ya existe, introduzca otro.\u001B[0m");
                } else {
                    System.out.println("Email:");
                    break;
                }
            } else {
                System.out.println("\u001B[33mEl nombre de usuario no puede estar vacío.\u001B[0m");
            }
        }
        while (true) {
            Scanner pregLogin2 = new Scanner(System.in);
            email = pregLogin2.nextLine();
            if (email != "") {
                String listaEmail = limboDAO.read(email, "email");
                if (!listaEmail.isEmpty()) {
                    System.out.println("\u001B[33mEl email introducido ya existe, pruebe a iniciar sesión o introduzca otro.\u001B[0m");
                } else {
                    System.out.println("Password:");
                    Scanner pregLogin3 = new Scanner(System.in);
                    password = pregLogin3.nextLine();
                    break;
                }
            } else System.out.println("\u001B[33mEl Email no puede estar vacío.\u001B[0m");
        }
        while (true) {
            if (password != "") {
                System.out.println("Nom:");
                Scanner pregLogin4 = new Scanner(System.in);
                nom = pregLogin4.nextLine();
                break;
            } else System.out.println("\u001B[33mEl nombre no puede estar vacío.\u001B[0m");
        }
        if (nom != "") {
            System.out.println("Llinatge1:");
            Scanner pregLogin5 = new Scanner(System.in);
            llin1 = pregLogin5.nextLine();
        } else System.out.println("\u001B[33mEl Primer apellido no puede estar vacío.\u001B[0m");
        if (llin1 != "") {
            System.out.println("Llinatge2:");
            Scanner pregLogin6 = new Scanner(System.in);
            llin2 = pregLogin6.nextLine();
        }
        // Client client = new Client(username, email, password);
        limboDAO.insert(username, email, password, nom, llin1, llin2);
    }
}
