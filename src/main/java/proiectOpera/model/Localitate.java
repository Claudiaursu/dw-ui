package proiectOpera.model;

public class Localitate {
    private int id_localitate;
    private String denumire;
    private int id_judet;

    public Localitate(int id_localitate, String denumire, int id_judet) {
        this.id_localitate = id_localitate;
        this.denumire = denumire;
        this.id_judet = id_judet;
    }

    public Localitate () {

    }

    public int getId_localitate() {
        return id_localitate;
    }

    public void setId_localitate(int id_localitate) {
        this.id_localitate = id_localitate;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId_judet() {
        return id_judet;
    }

    public void setId_judet(int id_judet) {
        this.id_judet = id_judet;
    }
}


