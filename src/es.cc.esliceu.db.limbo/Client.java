package es.cc.esliceu.db.limbo;

public class Client {
    private String numero_client;
    private String email;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String username;
    private String contrasenya;

    public Client(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getNumero_client() {
        return numero_client;
    }

    public void setNumero_client(String numero_client) {
        this.numero_client = numero_client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}
