package es.cc.esliceu.db.limbo;

public class Client {
    private String numero_client;
    private static String email;
    private static String nom;
    private static String cognom1;
    private static String cognom2;
    private static String username;
    private static String contrasenya;

    public String getNumero_client() {
        return numero_client;
    }

    public void setNumero_client(String numero_client) {
        this.numero_client = numero_client;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public static String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}
