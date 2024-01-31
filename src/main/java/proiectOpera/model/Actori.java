package proiectOpera.model;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Actori {
    private int id_actor;
    private String nume;
    private String prenume;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date data_nasterii;

    @DateTimeFormat(pattern =  "dd-MMM-yyyy")
    private Date data_angajarii;
    private String sex;

    public Actori() {
    }

    public Actori(String nume, String prenume, Date data_nasterii, Date data_angajarii, String tip_actor) {
        this.nume=nume;
        this.prenume = prenume;
        this.data_nasterii= data_nasterii;
        this.data_angajarii=data_angajarii;
        this.sex= tip_actor;
    }

    public int getId_actor() {
        return id_actor;
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

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
