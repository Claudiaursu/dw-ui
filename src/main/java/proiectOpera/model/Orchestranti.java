package proiectOpera.model;
import java.util.Date;

public class Orchestranti {
    private int id_orchestrant;
    private String nume;
    private String prenume;
    private Date data_nasterii;
    private Date data_angajarii;
    private int id_instrument;

     public Orchestranti() {}

    public Orchestranti(int id_orchestrant, String nume, String prenume, Date data_nasterii, Date data_angajarii, int id_instrument) {
        this.id_orchestrant = id_orchestrant;
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
        this.data_angajarii = data_angajarii;
        this.id_instrument = id_instrument;
    }

    public int getId_orchestrant() {
        return id_orchestrant;
    }

    public void setId_orchestrant(int id_orchestrant) {
        this.id_orchestrant = id_orchestrant;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public Date getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(Date data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public int getId_instrument() {
        return id_instrument;
    }

    public void setId_instrument(int id_instrument) {
        this.id_instrument = id_instrument;
    }
}
