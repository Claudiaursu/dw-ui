package proiectOpera.model;

public class Aparitie {
    int id_aparitie;
    int id_obiect_vestimentar;
    int id_actor;

    int id_reprezentatie;

    public Aparitie() {}

    public Aparitie(int id_aparitie, int id_obiect_vestimentar, int id_actor, int id_reprezentatie) {
        this.id_aparitie = id_aparitie;
        this.id_obiect_vestimentar = id_obiect_vestimentar;
        this.id_actor = id_actor;
        this.id_reprezentatie = id_reprezentatie;
    }

    public int getId_aparitie() {
        return id_aparitie;
    }

    public void setId_aparitie(int id_aparitie) {
        this.id_aparitie = id_aparitie;
    }

    public int getId_obiect_vestimentar() {
        return id_obiect_vestimentar;
    }

    public void setId_obiect_vestimentar(int id_obiect_vestimentar) {
        this.id_obiect_vestimentar = id_obiect_vestimentar;
    }

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public int getId_reprezentatie() {
        return id_reprezentatie;
    }

    public void setId_reprezentatie(int id_reprezentatie) {
        this.id_reprezentatie = id_reprezentatie;
    }
}
