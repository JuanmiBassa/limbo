package es.cc.esliceu.db.limbo;

public class Producte {
    private int id;
    private static String nom;
    private static String descripcio;
    private static double pvp;
    private static int iva;
    private static String marca;
    private static String unitat_mesura;
    private static double pes;
    private static int categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        Producte.nom = nom;
    }

    public static String getDescripcio() {
        return descripcio;
    }

    public static void setDescripcio(String descripcio) {
        Producte.descripcio = descripcio;
    }

    public static double getPvp() {
        return pvp;
    }

    public static void setPvp(double pvp) {
        Producte.pvp = pvp;
    }

    public static int getIva() {
        return iva;
    }

    public static void setIva(int iva) {
        Producte.iva = iva;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Producte.marca = marca;
    }

    public static String getUnitat_mesura() {
        return unitat_mesura;
    }

    public static void setUnitat_mesura(String unitat_mesura) {
        Producte.unitat_mesura = unitat_mesura;
    }

    public static double getPes() {
        return pes;
    }

    public static void setPes(double pes) {
        Producte.pes = pes;
    }

    public static int getCategoria() {
        return categoria;
    }

    public static void setCategoria(int categoria) {
        Producte.categoria = categoria;
    }
}
