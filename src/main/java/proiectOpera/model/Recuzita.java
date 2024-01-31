package proiectOpera.model;

public class Recuzita {
    private int id_recuzita;
    private String denumire;
    private String culoare;
    private int greutate;
    private int inaltime;

    public Recuzita() {}

    public Recuzita(int id_recuzita, String denumire, String culoare, int greutate, int inaltime) {
        this.id_recuzita = id_recuzita;
        this.denumire = denumire;
        this.culoare = culoare;
        this.greutate = greutate;
        this.inaltime = inaltime;
    }

    public int getId_recuzita() {
        return id_recuzita;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getCuloare() {
        return culoare;
    }

    public int getGreutate() {
        return greutate;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setId_recuzita(int id_recuzita) {
        this.id_recuzita = id_recuzita;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }
}
