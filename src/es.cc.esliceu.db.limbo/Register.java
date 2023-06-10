package es.cc.esliceu.db.limbo;

import es.cc.esliceu.db.limbo.dao.LimboDAO;
import es.cc.esliceu.db.limbo.dao.LimboDaoImpl;

import java.util.List;
import java.util.Scanner;

import static es.cc.esliceu.db.limbo.Limbo.info;

public class Register {
    public static void registerProcess() {
        LimboDAO limboDAO = new LimboDaoImpl();
        String username;
        String email;
        String password;
        String nom;
        String llin1 = "";
        String llin2 = "";

        System.out.println("**************************");
        System.out.println("**      Registre        **");
        System.out.println("**************************");
        while (true) {
            info("Nombre de usuario:");
            Scanner pregRegis1 = new Scanner(System.in);
            username = pregRegis1.nextLine();
            if (username != "") {
                String listaUser = limboDAO.readRegister(username, "username");
                if (!listaUser.isEmpty()) {
                    System.out.println("\u001B[33mEl nombre de usuario ya existe, introduzca otro.\u001B[0m");
                } else {
                    break;
                }
            } else {
                System.out.println("\u001B[33mEl nombre de usuario no puede estar vacío.\u001B[0m");
            }
        }

        while (true) {
            info("Email:");
            Scanner pregRegis2 = new Scanner(System.in);
            email = pregRegis2.nextLine();
            if (email != "") {
                String listaEmail = limboDAO.readRegister(email, "email");
                if (!listaEmail.isEmpty()) {
                    System.out.println("\u001B[33mEl email introducido ya existe, pruebe a iniciar sesión o introduzca otro.\u001B[0m");
                } else {
                    break;
                }
            } else System.out.println("\u001B[33mEl Email no puede estar vacío.\u001B[0m");
        }

        while (true) {
            info("Contraseña:");
            Scanner pregRegis3 = new Scanner(System.in);
            password = pregRegis3.nextLine();
            if (password != "") {
                info("Nom:");
                Scanner pregRegis4 = new Scanner(System.in);
                nom = pregRegis4.nextLine();
                break;
            } else System.out.println("\u001B[33mEl nombre no puede estar vacío.\u001B[0m");
        }

        if (nom != "") {
            info("(Opcional) Llinatge1:");
            Scanner pregRegis5 = new Scanner(System.in);
            llin1 = pregRegis5.nextLine();
        } else System.out.println("\u001B[33mEl Primer apellido no puede estar vacío.\u001B[0m");

        if (llin1 != "") {
            info("(Opcional) Llinatge2:");
            Scanner pregRegis6 = new Scanner(System.in);
            llin2 = pregRegis6.nextLine();
        }
        // Si quiero llamar a constructor
        // Client client = new Client(username, email, password);
        limboDAO.insert(username, email, password, nom, llin1, llin2);
    }
}
