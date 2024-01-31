package proiectOpera.model;

import java.sql.Timestamp;

public class Reprezentatie {

    private int id_reprezentatie;
    private int id_piesa_teatru_regizor;
    private Timestamp data_ora_reprezentatie;
    private int nr_locuri;

    public Reprezentatie() {}

    public Reprezentatie(int id_reprezentatie, int id_piesa_teatru_regizor, Timestamp data_ora_reprezentatie, int nr_locuri) {
        this.id_reprezentatie = id_reprezentatie;
        this.id_piesa_teatru_regizor = id_piesa_teatru_regizor;
        this.data_ora_reprezentatie = data_ora_reprezentatie;
        this.nr_locuri = nr_locuri;
    }

    public int getId_reprezentatie() {
        return id_reprezentatie;
    }

    public void setId_reprezentatie(int id_reprezentatie) {
        this.id_reprezentatie = id_reprezentatie;
    }

    public int getId_piesa_teatru_regizor() {
        return id_piesa_teatru_regizor;
    }

    public void setId_piesa_teatru_regizor(int id_piesa_teatru_regizor) {
        this.id_piesa_teatru_regizor = id_piesa_teatru_regizor;
    }

    public Timestamp getData_ora_reprezentatie() {
        return data_ora_reprezentatie;
    }

    public void setData_ora_reprezentatie(Timestamp data_ora_reprezentatie) {
        this.data_ora_reprezentatie = data_ora_reprezentatie;
    }

    public int getNr_locuri() {
        return nr_locuri;
    }

    public void setNr_locuri(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }


}
