package proiectOpera.model;

public class Categorie {
    private int id_categorie;

    private String tip_spectator;

    private int pret;

    public Categorie(int id_categorie, String tip_spectator, int pret) {
        this.id_categorie = id_categorie;
        this.tip_spectator = tip_spectator;
        this.pret = pret;
    }

    public Categorie () {

    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getTip_spectator() {
        return tip_spectator;
    }

    public void setTip_spectator(String tip_spectator) {
        this.tip_spectator = tip_spectator;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}
