package proiectOpera.model;

public class Melodie_Orchestrant {
    int id_melodie;
    int id_orchestrant;

    public Melodie_Orchestrant() {}

    public Melodie_Orchestrant(int id_melodie, int id_orchestrant) {
        this.id_melodie = id_melodie;
        this.id_orchestrant = id_orchestrant;
    }

    public int getId_melodie() {
        return id_melodie;
    }

    public void setId_melodie(int id_melodie) {
        this.id_melodie = id_melodie;
    }

    public int getId_orchestrant() {
        return id_orchestrant;
    }

    public void setId_orchestrant(int id_orchestrant) {
        this.id_orchestrant = id_orchestrant;
    }
}
