package proiectOpera.model;

public class Judet {

    private int id_judet;
    private String denumire;
    private int id_tara;

    public Judet(int id_judet, String denumire, int id_tara) {
        this.id_judet = id_judet;
        this.denumire = denumire;
        this.id_tara = id_tara;
    }

    public Judet () {

    }

    public int getId_judet() {
        return id_judet;
    }

    public void setId_judet(int id_judet) {
        this.id_judet = id_judet;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId_tara() {
        return id_tara;
    }

    public void setId_tara(int id_tara) {
        this.id_tara = id_tara;
    }
}
