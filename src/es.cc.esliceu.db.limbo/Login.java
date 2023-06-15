package es.cc.esliceu.db.limbo;

import es.cc.esliceu.db.limbo.dao.LimboDAO;
import es.cc.esliceu.db.limbo.dao.LimboDaoImpl;
import es.cc.esliceu.db.limbo.util.Color;

import java.util.Scanner;

import static es.cc.esliceu.db.limbo.Limbo.*;

public class Login {
    public static void loginProcess() {
        LimboDAO limboDAO = new LimboDaoImpl();
        String username;
        String password;
        String usuarioBD;

        titulo("**************************");
        titulo("**         Login        **");
        titulo("**************************");
        while (true) {
            oblitatorio("Nombre de usuario:");
            Scanner pregLogin1 = new Scanner(System.in);
            username = pregLogin1.nextLine();
            if (!username.isEmpty()) {
                usuarioBD = limboDAO.readRegister(username, "username");
                if (!usuarioBD.isEmpty()) {
                    info("Usuario encontrado en el sistema.", "");
                    break;
                } else {
                    error("El usuario no existe, introduzca otro.");
                }
            } else {
                error("El nombre de usuario no puede estar vacío.");
            }
        }

        int contIntentos = 3;
        while (true) {
            oblitatorio("Contraseña:");
            Scanner pregLogin2 = new Scanner(System.in);
            password = GeneradorHash.generaHash(pregLogin2.nextLine());
            if (!password.isEmpty()) {
                boolean loginCorrecto = limboDAO.readLogin(username, password);
                if (loginCorrecto) {
                    info("Inicio de sesión correcto.", "");
                    Opciones.opcionesProcess(usuarioBD);
                    break;
                } else {
                    contIntentos -= 1;
                    if (contIntentos > 0) {
                        error("Contraseña incorrecta, quedan "+contIntentos+" intentos.");
                    }else {
                        error("Limite de intentos alcanzados, saliendo del sistema.");
                        break;
                    }
                }
            } else {
                error("La contraseña no puede estar vacía.");
            }
        }
    }
}