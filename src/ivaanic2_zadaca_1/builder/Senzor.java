/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.builder;

import java.util.Random;

/**
 *
 * @author ivaanic2
 */
public class Senzor {
    
    private String naziv;
    private int tip;
    private int vrsta;
    private Float minVrijednost;
    private Float maxVrijednost;
    private Float vrijednost = 0.0f;
    
    
    private String komentar;
    private int status;
    private int brojGreski;

    public Senzor() {

    }

    public Senzor(String naziv, int tip, int vrsta, Float minVrijednost, Float maxVrijednost, String komentar) {
        this.naziv = naziv;
        this.tip = tip;
        this.vrsta = vrsta;
        this.minVrijednost = minVrijednost;
        this.maxVrijednost = maxVrijednost;
        this.komentar = komentar;

    }

    //uredaj vraca status 1 u 90% slucajeva
//    public static int vratiStatus() {
//        int postotak = 90;
//        Random rand = new Random();
//            if (rand.nextInt(100) < postotak) {
//            return 1;
//        } else {
//            return 0;
//    }
//    }
    public static int vratiStatus() {
        int postotak = 90;
        int rez;
        Random rand = new Random();
        if (rand.nextInt(100) < postotak) {
            return 1;
        } else {
            return 0;
        }
    }

    public Senzor(Senzor senzor) {
        this.naziv = senzor.getNaziv();
        this.tip = senzor.getTip();
        this.vrsta = senzor.getVrsta();
        this.minVrijednost = senzor.getMinVrijednost();
        this.maxVrijednost = senzor.getMaxVrijednost();
        this.vrijednost = senzor.getVrijednost();
        this.komentar = senzor.getKomentar();
        this.status = senzor.getStatus();
        this.brojGreski = senzor.getBrojGreski();
    }

    @Override
    public String toString() {
        return this.naziv + " " + this.tip + " " + this.vrsta + " " + this.minVrijednost + " " + this.maxVrijednost + " " + this.komentar;
    }
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public int getVrsta() {
        return vrsta;
    }

    public void setVrsta(int vrsta) {
        this.vrsta = vrsta;
    }

    public Float getMinVrijednost() {
        return minVrijednost;
    }

    public void setMinVrijednost(Float minVrijednost) {
        this.minVrijednost = minVrijednost;
    }

    public Float getMaxVrijednost() {
        return maxVrijednost;
    }

    public void setMaxVrijednost(Float maxVrijednost) {
        this.maxVrijednost = maxVrijednost;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getStatus() {
        int postotak = 90;
        int rez;
        Random rand = new Random();
        if (rand.nextInt(100) < postotak) {
            this.status = 1;
            return this.status;
        } else {
            this.status = 0;
            return this.status;
        }
    }
    
    public int dohvatiStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBrojGreski() {
        return brojGreski;
    }

    public void setBrojGreski(int brojGreski) {
        this.brojGreski = brojGreski;
    }

    public Float getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(Float vrijednost) {
        this.vrijednost = vrijednost;
    }
    
}
