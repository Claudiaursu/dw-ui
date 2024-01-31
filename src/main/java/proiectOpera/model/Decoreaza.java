package proiectOpera.model;

public class Decoreaza {
    int id_act;
    int id_recuzita;

    public Decoreaza() {}

    public Decoreaza(int id_act, int id_recuzita) {
        this.id_act = id_act;
        this.id_recuzita = id_recuzita;
    }

    public int getId_act() {
        return id_act;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public int getId_recuzita() {
        return id_recuzita;
    }

    public void setId_recuzita(int id_recuzita) {
        this.id_recuzita = id_recuzita;
    }
}
