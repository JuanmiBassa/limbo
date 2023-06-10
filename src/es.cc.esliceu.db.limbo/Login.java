package es.cc.esliceu.db.limbo;

import es.cc.esliceu.db.limbo.dao.LimboDAO;
import es.cc.esliceu.db.limbo.dao.LimboDaoImpl;

import java.util.Scanner;

import static es.cc.esliceu.db.limbo.Limbo.info;

public class Login {
    public static void loginProcess() {
        LimboDAO limboDAO = new LimboDaoImpl();
        String username;
        String password;

        System.out.println("***********************");
        System.out.println("**      Login        **");
        System.out.println("***********************");
        while (true) {
            info("Nombre de usuario:");
            Scanner pregLogin1 = new Scanner(System.in);
            username = pregLogin1.nextLine();
            if (username != "") {
                String listaUser = limboDAO.readRegister(username, "username");
                if (!listaUser.isEmpty()) {
                    System.out.println("\u001B[33mUsuario encontrado en el sistema.\u001B[0m");
                    break;
                } else {
                    System.out.println("\u001B[33mEl usuario no existe, introduzca otro.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[33mEl nombre de usuario no puede estar vacío.\u001B[0m");
            }
        }

        int contIntentos = 3;
        info("Contraseña:");
        while (true) {
            Scanner pregLogin2 = new Scanner(System.in);
            password = pregLogin2.nextLine();
            if (username != "") {
                boolean loginCorrecto = limboDAO.readLogin(username, password);
                if (loginCorrecto) {
                    System.out.println("\u001B[33mInicio de sesión correcto.\u001B[0m");
                    Opciones.opcionesProcess();
                    break;
                } else {
                    contIntentos -= 1;
                    if (contIntentos > 0) {
                        System.out.println("\u001B[33mContraseña incorrecta, quedan "+contIntentos+" intentos.\u001B[0m");
                        info("Contraseña:");
                    }else {
                        System.out.println("\u001B[33mLimite de intentos alcanzados, saliendo del sistema.\u001B[0m");
                        break;
                    }
                }
            }
        }
    }
}