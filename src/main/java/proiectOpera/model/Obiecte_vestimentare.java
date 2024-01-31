package proiectOpera.model;

public class Obiecte_vestimentare {
    private int id_obiect_vestimentar;
    private String denumire;
    private String culoare;
    private String material;
    private String marime;

    public Obiecte_vestimentare() {}

    public Obiecte_vestimentare(int id_obiect_vestimentar, String denumire, String culoare, String material, String marime) {
        this.id_obiect_vestimentar = id_obiect_vestimentar;
        this.denumire = denumire;
        this.culoare = culoare;
        this.material = material;
        this.marime = marime;
    }

    public int getId_obiect_vestimentar() {
        return id_obiect_vestimentar;
    }

    public void setId_obiect_vestimentar(int id_obiect_vestimentar) {
        this.id_obiect_vestimentar = id_obiect_vestimentar;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMarime() {
        return marime;
    }

    public void setMarime(String marime) {
        this.marime = marime;
    }
}
