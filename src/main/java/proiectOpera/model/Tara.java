package proiectOpera.model;

public class Tara {
    private int id_tara;
    private String denumire;

    public Tara() {

    }

    public Tara(String denumire) {
        this.denumire = denumire;
    }

    public int getId_tara() {
        return id_tara;
    }

    public void setId_tara(int id_tara) {
        this.id_tara = id_tara;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}
