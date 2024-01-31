package proiectOpera.model;
public class Acte {
    private int id_act;
    private int durata;

    private int id_piesa_teatru_regizor;

    public Acte() {
    }

    public Acte(int id_act, int durata, int id_piesa_teatru_regizor) {
        this.id_act = id_act;
        this.durata = durata;
        this.id_piesa_teatru_regizor = id_piesa_teatru_regizor;
    }

    public int getId_act() {
        return id_act;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getId_piesa_teatru_regizor() {
        return id_piesa_teatru_regizor;
    }

    public void setId_piesa_teatru_regizor(int id_piesa_teatru_regizor) {
        this.id_piesa_teatru_regizor = id_piesa_teatru_regizor;
    }
}