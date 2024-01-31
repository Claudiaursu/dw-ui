package proiectOpera.model;

public class Piese {
    private int id_piesa;
    private String gen_piesa;
    private String titlu_piesa;
    private String descriere;

    public Piese() {
    }

    public Piese(String titlu_piesa,String gen_piesa, String descriere) {
        this.titlu_piesa=titlu_piesa;
        this.gen_piesa = gen_piesa;
        this.descriere= descriere;
    }

    public int getId_piesa() {
        return id_piesa;
    }

    public void setId_piesa(int id_piesa) {
        this.id_piesa = id_piesa;
    }

    public String getGen_piesa() {
        return gen_piesa;
    }

    public void setGen_piesa(String gen_piesa) {
        this.gen_piesa = gen_piesa;
    }

    public String getTitlu_piesa() {
        return titlu_piesa;
    }

    public void setTitlu_piesa(String titlu_piesa) {
        this.titlu_piesa = titlu_piesa;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}

