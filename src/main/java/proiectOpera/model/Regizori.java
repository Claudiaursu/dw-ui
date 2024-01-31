package proiectOpera.model;

import java.util.Date;

public class Regizori {
    private int id_regizor;
    private String nume;
    private String prenume;
    private Date data_nasterii;
    private Date data_angajarii;

    public Regizori() {
    }

    public Regizori(String nume, String prenume, Date data_nasterii, Date data_angajarii) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
        this.data_angajarii = data_angajarii;
    }

    public int getId_regizor() {
        return id_regizor;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public Date getData_angajarii() {
        return data_angajarii;
    }

    public void setId_regizor(int id_regizor) {
        this.id_regizor = id_regizor;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public void setData_angajarii(Date data_angajarii) {
        this.data_angajarii = data_angajarii;
    }
}

