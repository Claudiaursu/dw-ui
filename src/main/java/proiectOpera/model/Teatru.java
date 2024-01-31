package proiectOpera.model;

public class Teatru {
    private int id_teatru;
    private String denumire;
    private String adresa;
    private int id_localitate;

    public Teatru(int id_teatru, String denumire, String adresa, int id_localitate) {
        this.id_teatru = id_teatru;
        this.denumire = denumire;
        this.adresa = adresa;
        this.id_localitate = id_localitate;
    }

    public Teatru () {

    }

    public int getId_teatru() {
        return id_teatru;
    }

    public void setId_teatru(int id_teatru) {
        this.id_teatru = id_teatru;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getId_localitate() {
        return id_localitate;
    }

    public void setId_localitate(int id_localitate) {
        this.id_localitate = id_localitate;
    }
}
