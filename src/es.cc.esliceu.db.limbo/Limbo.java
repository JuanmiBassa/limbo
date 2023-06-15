package es.cc.esliceu.db.limbo;

import es.cc.esliceu.db.limbo.util.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Limbo {

    public static void main(String[] args) throws IOException {

        FileInputStream input = new FileInputStream("resources/limbo.properties");
        Properties props = new Properties();
        props.load(input);
        String URL = props.getProperty("url");
        String USERNAME = props.getProperty("user");
        String PASSWORD = props.getProperty("password");

        titulo("**************************");
        titulo("**      Limbo App       **");
        titulo("**************************");
        info("1)", " Login");
        info("2)", " Registrar-se");
        info("h)", " Ayuda");
        info("x)", " Salir");

        while (true) {
            oblitatorio("Escoge una opción:");
            Scanner preg1 = new Scanner(System.in);
            String respUsuari = preg1.nextLine();
            if (Objects.equals(respUsuari, "1")) {
                Login.loginProcess();
                break;
            } else if (Objects.equals(respUsuari, "2")) {
                Register.registerProcess();
                break;
            } else if (Objects.equals(respUsuari, "h")) {
                break;
            } else if (Objects.equals(respUsuari, "x")) {
                break;
            } else {
                error("Respuesta no valida.");
            }
        }

    }

    public static void info(String texte, String texte2) {
        System.out.println(Color.BLUE_BOLD + "\t" + texte + Color.RESET + texte2);
    }
    public static void error(String texte) {
        System.out.println(Color.RED_BOLD + "\t" + texte + Color.RESET);
    }
    public static void oblitatorio(String texte) {
        System.out.println(Color.MAGENTA + texte + Color.RESET);
    }
    public static void titulo(String texte) {
        System.out.println(Color.YELLOW_BOLD + texte + Color.RESET);
    }
}
