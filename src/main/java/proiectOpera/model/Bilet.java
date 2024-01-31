package proiectOpera.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Bilet {

    private int id_bilet;
    private int id_reprezentatie;
    private int id_categorie;
    private int loc;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date data_achizitie;

    public Bilet () {}

    public Bilet(int id_bilet, int id_reprezentatie, int id_categorie, int loc, Date data_achizitie) {
        this.id_bilet = id_bilet;
        this.id_reprezentatie = id_reprezentatie;
        this.id_categorie = id_categorie;
        this.loc = loc;
        this.data_achizitie = data_achizitie;
    }

    public int getId_bilet() {
        return id_bilet;
    }

    public void setId_bilet(int id_bilet) {
        this.id_bilet = id_bilet;
    }

    public int getId_reprezentatie() {
        return id_reprezentatie;
    }

    public void setId_reprezentatie(int id_reprezentatie) {
        this.id_reprezentatie = id_reprezentatie;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public Date getData_achizitie() {
        return data_achizitie;
    }

    public void setData_achizitie(Date data_achizitie) {
        this.data_achizitie = data_achizitie;
    }
}
