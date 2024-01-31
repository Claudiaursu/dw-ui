package proiectOpera.model;

public class Act_Orchestrant {
    private int id_act;
    private int id_orchestrant;

    public Act_Orchestrant() {}

    public Act_Orchestrant(int id_act, int id_orchestrant) {
        this.id_act = id_act;
        this.id_orchestrant = id_orchestrant;
    }

    public int getId_act() {
        return id_act;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public int getId_orchestrant() {
        return id_orchestrant;
    }

    public void setId_orchestrant(int id_orchestrant) {
        this.id_orchestrant = id_orchestrant;
    }
}
