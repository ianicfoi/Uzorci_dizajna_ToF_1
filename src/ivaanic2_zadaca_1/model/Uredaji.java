/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.model;

import java.util.Random;

/**
 *
 * @author ivaanic2
 */
public class Uredaji {

    private String naziv;
    private int tip;
    private int vrsta;
    private String minVrijednost;
    private String maxVrijednost;
    
    private String komentar;
    private int status;
    private int brojGreski;

    public Uredaji() {

    }

    public Uredaji(String naziv, int tip, int vrsta, String minVrijednost, String maxVrijednost, String komentar) {
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

    public String getMinVrijednost() {
        return minVrijednost;
    }

    public void setMinVrijednost(String minVrijednost) {
        this.minVrijednost = minVrijednost;
    }

    public String getMaxVrijednost() {
        return maxVrijednost;
    }

    public void setMaxVrijednost(String maxVrijednost) {
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

}
