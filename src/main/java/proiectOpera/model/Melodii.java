package proiectOpera.model;

public class Melodii {
    private int id_melodie;
    private String titlu;
    private String autor;
    private float durata;
    private String gen;
    private int id_act;

    public Melodii() {}

    public Melodii(int id_melodie, String titlu, String autor, float durata, String gen, int id_act) {
        this.id_melodie = id_melodie;
        this.titlu = titlu;
        this.autor = autor;
        this.durata = durata;
        this.gen = gen;
        this.id_act = id_act;
    }

    public int getId_melodie() {
        return id_melodie;
    }

    public void setId_melodie(int id_melodie) {
        this.id_melodie = id_melodie;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getId_act() {
        return id_act;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }
}
