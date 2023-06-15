package es.cc.esliceu.db.limbo;

import es.cc.esliceu.db.limbo.dao.LimboDAO;
import es.cc.esliceu.db.limbo.dao.LimboDaoImpl;

import java.util.List;
import java.util.Scanner;

import static es.cc.esliceu.db.limbo.Limbo.*;

public class Register {
    public static void registerProcess() {
        LimboDAO limboDAO = new LimboDaoImpl();
        String username;
        String email;
        String password;
        String nom;
        String llin1 = "";
        String llin2 = "";

        titulo("**************************");
        titulo("**       Registre       **");
        titulo("**************************");
        while (true) {
            oblitatorio("Nombre de usuario:");
            Scanner pregRegis1 = new Scanner(System.in);
            username = pregRegis1.nextLine();
            if (!username.isEmpty()) {
                String listaUser = limboDAO.readRegister(username, "username");
                if (!listaUser.isEmpty()) {
                    error("El nombre de usuario ya existe, introduzca otro.");
                } else {
                    break;
                }
            } else {
                error("El nombre de usuario no puede estar vacío.");
            }
        }

        while (true) {
            oblitatorio("Email:");
            Scanner pregRegis2 = new Scanner(System.in);
            email = pregRegis2.nextLine();
            if (!email.isEmpty()) {
                String listaEmail = limboDAO.readRegister(email, "email");
                if (!listaEmail.isEmpty()) {
                    error("El email introducido ya existe, pruebe a iniciar sesión o introduzca otro.");
                } else {
                    break;
                }
            } else error("El Email no puede estar vacío.");
        }

        while (true) {
            oblitatorio("Contraseña:");
            Scanner pregRegis3 = new Scanner(System.in);
            password = GeneradorHash.generaHash(pregRegis3.nextLine());
            if (!password.isEmpty()) {
                oblitatorio("Nombre:");
                Scanner pregRegis4 = new Scanner(System.in);
                nom = pregRegis4.nextLine();
                break;
            } else error("El nombre no puede estar vacío.");
        }

        if (!nom.isEmpty()) {
            System.out.println("(Opcional) Primer Apellido:");
            Scanner pregRegis5 = new Scanner(System.in);
            llin1 = pregRegis5.nextLine();
        }

        if (!llin1.isEmpty()) {
            System.out.println("(Opcional) Segundo Apellido:");
            Scanner pregRegis6 = new Scanner(System.in);
            llin2 = pregRegis6.nextLine();
        }
        // Si quiero llamar a constructor sería:
        // Client client = new Client(username, email, password, etc);
        limboDAO.insert(username, email, password, nom, llin1, llin2);
    }
}
