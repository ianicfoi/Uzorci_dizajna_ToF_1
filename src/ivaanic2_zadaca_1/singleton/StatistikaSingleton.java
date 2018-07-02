/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.singleton;

/**
 *
 * @author ivaanic2
 */
public class StatistikaSingleton {
    
    private static StatistikaSingleton instanca = new StatistikaSingleton();

    
    private int brojIspravnihSenzora = 0;
    private int brojNeispravnihSenzora = 0;
    private int zamjenaSenzora = 0;
    private int brojDodijeljenihSenzora = 0;
    
    private int brojIspravnihAktuatora = 0;
    private int brojNeispravnihAktuatora = 0;
    private int zamjenaAktuatora = 0;
    private int brojDodijeljenihAktuatora = 0;
    
    private int brojIspravnihMjesta = 0;
    private int brojNeispravnihMjesta = 0;
    
    
    private StatistikaSingleton(){
    }
    
    public static StatistikaSingleton getInstance(){
        if (instanca == null) {
            instanca = new StatistikaSingleton();
        }
        return instanca;
    }

    public int getBrojDodijeljenihSenzora() {
        return brojDodijeljenihSenzora;
    }

    public void setBrojDodijeljenihSenzora(int brojDodijeljenihSenzora) {
        this.brojDodijeljenihSenzora = brojDodijeljenihSenzora;
    }

    public int getBrojNeispravnihSenzora() {
        return brojNeispravnihSenzora;
    }

    public void setBrojNeispravnihSenzora(int brojNeispravnihSenzora) {
        this.brojNeispravnihSenzora = brojNeispravnihSenzora;
    }

    public int getBrojDodijeljenihAktuatora() {
        return brojDodijeljenihAktuatora;
    }

    public void setBrojDodijeljenihAktuatora(int brojDodijeljenihAktuatora) {
        this.brojDodijeljenihAktuatora = brojDodijeljenihAktuatora;
    }

    public int getBrojNeispravnihAktuatora() {
        return brojNeispravnihAktuatora;
    }

    public void setBrojNeispravnihAktuatora(int brojNeispravnihAktuatora) {
        this.brojNeispravnihAktuatora = brojNeispravnihAktuatora;
    }

    public int getZamjenaSenzora() {
        return zamjenaSenzora;
    }

    public void setZamjenaSenzora(int zamjenaSenzora) {
        this.zamjenaSenzora = zamjenaSenzora;
    }

    public int getZamjenaAktuatora() {
        return zamjenaAktuatora;
    }

    public void setZamjenaAktuatora(int zamjenaAktuatora) {
        this.zamjenaAktuatora = zamjenaAktuatora;
    }

    public int getBrojIspravnihSenzora() {
        return brojIspravnihSenzora;
    }

    public void setBrojIspravnihSenzora(int brojIspravnihSenzora) {
        this.brojIspravnihSenzora = brojIspravnihSenzora;
    }

    public int getBrojIspravnihAktuatora() {
        return brojIspravnihAktuatora;
    }

    public void setBrojIspravnihAktuatora(int brojIspravnihAktuatora) {
        this.brojIspravnihAktuatora = brojIspravnihAktuatora;
    }

    public int getBrojIspravnihMjesta() {
        return brojIspravnihMjesta;
    }

    public void setBrojIspravnihMjesta(int brojIspravnihMjesta) {
        this.brojIspravnihMjesta = brojIspravnihMjesta;
    }

    public int getBrojNeispravnihMjesta() {
        return brojNeispravnihMjesta;
    }

    public void setBrojNeispravnihMjesta(int brojNeispravnihMjesta) {
        this.brojNeispravnihMjesta = brojNeispravnihMjesta;
    }
    
    
    
    
    
    
}
