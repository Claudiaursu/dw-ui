package proiectOpera.model;

public class Piesa_Teatru_Regizor {
    private int id_piesa_teatru_regizor;
    private int id_piesa;
    private int id_teatru;
    private int id_regizor;

    public Piesa_Teatru_Regizor(int id_piesa_teatru_regizor, int id_piesa, int id_teatru, int id_regizor) {
        this.id_piesa_teatru_regizor = id_piesa_teatru_regizor;
        this.id_piesa = id_piesa;
        this.id_teatru = id_teatru;
        this.id_regizor = id_regizor;
    }

    public Piesa_Teatru_Regizor() {

    }

    public int getId_piesa_teatru_regizor() {
        return id_piesa_teatru_regizor;
    }

    public void setId_piesa_teatru_regizor(int id_piesa_teatru_regizor) {
        this.id_piesa_teatru_regizor = id_piesa_teatru_regizor;
    }

    public int getId_piesa() {
        return id_piesa;
    }

    public void setId_piesa(int id_piesa) {
        this.id_piesa = id_piesa;
    }

    public int getId_teatru() {
        return id_teatru;
    }

    public void setId_teatru(int id_teatru) {
        this.id_teatru = id_teatru;
    }

    public int getId_regizor() {
        return id_regizor;
    }

    public void setId_regizor(int id_regizor) {
        this.id_regizor = id_regizor;
    }
}
