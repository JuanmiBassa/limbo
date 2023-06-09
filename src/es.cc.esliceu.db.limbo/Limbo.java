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

        // info("username " + USERNAME);
        // Scanner scanner = new Scanner(System.in);


        System.out.println("**************************");
        System.out.println("**      Limbo App       **");
        System.out.println("**************************");
        System.out.println("1) Login");
        System.out.println("2) Registrar-se");
        System.out.println("h) Ajuda");
        System.out.println("x) Sortir");
        info("Escollir una opció:");
        Scanner preg1 = new Scanner(System.in);
        String resp1 = preg1.nextLine();

        if (Objects.equals(resp1, "1")) {
            Login.loginProcess();
        } else if (Objects.equals(resp1, "2")) {
            Register.registerProcess();
        } else if (Objects.equals(resp1, "h")) {

        } else if (Objects.equals(resp1, "x")) {

        } else {
            System.out.println("Respuesta no valida.");
        }
    }

    public static void info(String texte){
        System.out.println(Color.BLUE_BOLD + "\t" + texte + Color.RESET);
    }
    public static void errada(String texte){
        System.out.println(Color.RED_BOLD + "\t" + texte + Color.RESET);
    }
}
