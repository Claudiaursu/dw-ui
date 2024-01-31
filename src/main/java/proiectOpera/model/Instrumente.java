package proiectOpera.model;

public class Instrumente {
    private int id_instrument;
    private String denumire;
    private int greutate;
    private String tip;

    public Instrumente() {}

    public Instrumente(int id_instrument, String denumire, int greutate, String tip) {
        this.id_instrument = id_instrument;
        this.denumire = denumire;
        this.greutate = greutate;
        this.tip = tip;
    }

    public int getId_instrument() {
        return id_instrument;
    }

    public void setId_instrument(int id_instrument) {
        this.id_instrument = id_instrument;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
