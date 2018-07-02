/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.dretve;

import ivaanic2_zadaca_1.Ivaanic2_zadaca_1;
import ivaanic2_zadaca_1.UpisUDatoteku;
import ivaanic2_zadaca_1.model.Senzori;
import ivaanic2_zadaca_1.algoritmi.AlgoritamAbecedni;
import ivaanic2_zadaca_1.algoritmi.AlgoritamObrnuti;
import ivaanic2_zadaca_1.algoritmi.AlgoritamSlijedni;
import ivaanic2_zadaca_1.builder.Aktuator;
import ivaanic2_zadaca_1.builder.Senzor;
import ivaanic2_zadaca_1.singleton.GeneratorSlucajnogBrojaSingleton;
import ivaanic2_zadaca_1.singleton.Mjesta;
import ivaanic2_zadaca_1.singleton.StatistikaSingleton;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivaanic2
 */
public class DretvaProvjeraMjesta extends Thread {

    StatistikaSingleton stat = StatistikaSingleton.getInstance();
    GeneratorSlucajnogBrojaSingleton generatorBrojeva = GeneratorSlucajnogBrojaSingleton.getInstance();
    private int brojCiklusa = 0;
    private int trajanjeCiklusa = 0;
    private String odabraniAlgoritam = null;

    long vrijemePocetka = 0;
    long vrijemeZavrsetka = 0;
    private long trajanjeObrade = 0;

    Mjesta ms = Mjesta.getInstance();

    public DretvaProvjeraMjesta(int brojCiklusa, int trajanjeCiklusa, String odabraniAlgoritam) {
        this.brojCiklusa = brojCiklusa;
        this.trajanjeCiklusa = trajanjeCiklusa;
        this.odabraniAlgoritam = odabraniAlgoritam;
    }

    //nakon sto prode zadano vrijeme dretva se vise ne izvrsava
    @Override
    public void run() {
        try {
            UpisUDatoteku zapis = new UpisUDatoteku(Ivaanic2_zadaca_1.datotekaRezultata);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cik = 1;
        while (brojCiklusa >= 1) {

            System.out.println("Dretva je pokrenuta, ovo je " + cik + " ciklus.");
            UpisUDatoteku.upisiUDatoteku("Dretva je pokrenuta, ovo je " + cik + " ciklus.");
            vrijemePocetka = System.currentTimeMillis();

            System.out.println("Dretva u tijeku.");
            UpisUDatoteku.upisiUDatoteku("Dretva u tijeku.");

            if (this.odabraniAlgoritam.equals("AlgoritamSlijedni")) {
                AlgoritamSlijedni algSl = new AlgoritamSlijedni();
                try {
                    algSl.provjeriMjesta();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (this.odabraniAlgoritam.equals("AlgoritamObrnuti")) {
                AlgoritamObrnuti algObr = new AlgoritamObrnuti();
                try {
                    algObr.provjeriMjesta();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (this.odabraniAlgoritam.equals("AlgoritamAbecedni")) {
                AlgoritamAbecedni algAbc = new AlgoritamAbecedni();
                try {
                    algAbc.provjeriMjesta();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Krivo uneseno ime algoritma.");
                UpisUDatoteku.upisiUDatoteku("Krivo uneseno ime algoritma.");
            }

            ocitajVrijednostSenzora();
            ocitajVrijednostAktuatora();

            try {
                vrijemeZavrsetka = System.currentTimeMillis();
                trajanjeObrade = vrijemeZavrsetka - vrijemePocetka;
                System.out.println("Trajanje obrade: " + trajanjeObrade);
                UpisUDatoteku.upisiUDatoteku("Trajanje obrade: " + trajanjeObrade);
                long vrijeme = trajanjeCiklusa * 1000 - trajanjeObrade;
                if (vrijeme < 0) {
                    vrijeme = 0;
                }
                sleep(vrijeme);
            } catch (InterruptedException ex) {
                Logger.getLogger(DretvaProvjeraMjesta.class.getName()).log(Level.SEVERE, null, ex);
            }

            brojCiklusa--;
            cik++;
        }

        prikaziStatistiku();
        UpisUDatoteku.zatvoriDatoteku();

    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("start metoda");
    }

    public void prikaziStatistiku() {
        System.out.println("Ispis statistike: ");
        UpisUDatoteku.upisiUDatoteku("Ispis statistike: ");
        System.out.println("Broj ispravnih senzora: " + stat.getBrojIspravnihSenzora());
        UpisUDatoteku.upisiUDatoteku("Broj ispravnih senzora: " + stat.getBrojIspravnihSenzora());
        System.out.println("Broj neispravnih senzora: " + stat.getBrojNeispravnihSenzora());
        UpisUDatoteku.upisiUDatoteku("Broj neispravnih senzora: " + stat.getBrojNeispravnihSenzora());
        System.out.println("Broj ispravnih aktuatora: " + stat.getBrojIspravnihAktuatora());
        UpisUDatoteku.upisiUDatoteku("Broj ispravnih aktuatora: " + stat.getBrojIspravnihAktuatora());
        System.out.println("Broj neispravnih aktuatora: " + stat.getBrojNeispravnihAktuatora());
        UpisUDatoteku.upisiUDatoteku("Broj neispravnih aktuatora: " + stat.getBrojNeispravnihAktuatora());
        System.out.println("Broj ispravnih mjesta: " + stat.getBrojIspravnihMjesta());
        UpisUDatoteku.upisiUDatoteku("Broj ispravnih mjesta: " + stat.getBrojIspravnihMjesta());
        System.out.println("Broj neispravnih mjesta: " + stat.getBrojNeispravnihMjesta());
        UpisUDatoteku.upisiUDatoteku("Broj neispravnih mjesta: " + stat.getBrojNeispravnihMjesta());

        System.out.println("Broj dodijeljenih senzora: " + stat.getBrojDodijeljenihSenzora());
        UpisUDatoteku.upisiUDatoteku("Broj dodijeljenih senzora: " + stat.getBrojDodijeljenihSenzora());
        System.out.println("Broj dodijeljenih aktuatora: " + stat.getBrojDodijeljenihAktuatora());
        UpisUDatoteku.upisiUDatoteku("Broj dodijeljenih aktuatora: " + stat.getBrojDodijeljenihAktuatora());

        System.out.println("Broj zamjena senzora: " + stat.getZamjenaSenzora());
        UpisUDatoteku.upisiUDatoteku("Broj zamjena senzora: " + stat.getZamjenaSenzora());
        System.out.println("Broj zamjena aktuatora: " + stat.getZamjenaAktuatora());
        UpisUDatoteku.upisiUDatoteku("Broj zamjena aktuatora: " + stat.getZamjenaAktuatora());

    }

   public void ocitajVrijednostSenzora() {

        System.out.println("Zapoceto ocitanje senzora: ");

        for (Mjesta mjestaSingleton : ms.getListaMjesta()) {
            for (Senzor senzori : mjestaSingleton.getListaSenzoraZaMjesto()) {
                if (senzori.getStatus() == 1) {
                    if (senzori.getVrsta() == 0) {
                        //0=od-do cjelobrojno
                        int min = senzori.getMinVrijednost().intValue();
                        int max = senzori.getMaxVrijednost().intValue();
                        int vrijednost = generatorBrojeva.dajSlucajniBroj1(min, max);
                        float pom = (float) vrijednost;
                        senzori.setVrijednost(pom);
                        System.out.println("Senzor: " + senzori.getNaziv() + ", min vrijednost: " + senzori.getMinVrijednost() + ", max vrijednost: " + senzori.getMaxVrijednost() + ", vrijednost: " + senzori.getVrijednost().intValue());
                    } else if (senzori.getVrsta() == 1) {
                        //1=od-do razlomljeno 1 decimala
                        Float min = senzori.getMinVrijednost();
                        Float max = senzori.getMaxVrijednost();
                        float vrijednost = generatorBrojeva.dajSlucajniBroj(min, max);
                        senzori.setVrijednost(Float.parseFloat(String.format("%.1f", vrijednost).replace(",", ".")));
                        System.out.println("Senzor: " + senzori.getNaziv() + ", min vrijednost: " + senzori.getMinVrijednost() + ", max vrijednost: " + senzori.getMaxVrijednost() + ", vrijednost: " + senzori.getVrijednost());
                    } else if (senzori.getVrsta() == 2) {
                        //2=od-do razlomljeno 5 decimala
                        Float min = senzori.getMinVrijednost();
                        Float max = senzori.getMaxVrijednost();
                        float vrijednost = generatorBrojeva.dajSlucajniBroj(min, max);
                        senzori.setVrijednost(Float.parseFloat(String.format("%.5f", vrijednost).replace(",", ".")));
                        System.out.println("Senzor: " + senzori.getNaziv() + ", min vrijednost: " + senzori.getMinVrijednost() + ", max vrijednost: " + senzori.getMaxVrijednost() + ", vrijednost: " + senzori.getVrijednost());
                    } else if (senzori.getVrsta() == 3) {
                        //3=0(ne) ili 1(da)
                        int min = senzori.getMinVrijednost().intValue();
                        int max = senzori.getMaxVrijednost().intValue();
                        int vrijednost = generatorBrojeva.dajSlucajniBroj1(min, max);
                        float pom = (float) vrijednost;
                        senzori.setVrijednost(pom);
                        System.out.println("Senzor: " + senzori.getNaziv() + ", min vrijednost: " + senzori.getMinVrijednost() + ", max vrijednost: " + senzori.getMaxVrijednost() + ", vrijednost: " + senzori.getVrijednost().intValue());

//                        if (senzori.getVrsta() == 0 || senzori.getVrsta() == 3) {
//                            System.out.println("Senzor: " + senzori.getNaziv() + ", min vrijednost: " + senzori.getMinVrijednost() + ", max vrijednost: " + senzori.getMaxVrijednost() + ", vrijednost: " + senzori.getVrijednost().intValue());
//                        } else {
//                            System.out.println("Senzor: " + senzori.getNaziv() + ", min vrijednost: " + senzori.getMinVrijednost() + ", max vrijednost: " + senzori.getMaxVrijednost() + ", vrijednost: " + senzori.getVrijednost());
//
//                        }
                    }
                }
            }
        }
    }
    
    
    
    
    
    public void ocitajVrijednostAktuatora() {
        for (Mjesta mjestaSingleton : ms.getListaMjesta()) {
            for (Aktuator aktuator : mjestaSingleton.getListaAktuatoraZaMjesto()) {
                if (aktuator.getStatus() == 1) {
                    if (aktuator.getStanje()) {//uvijek ce biti false
                        if (aktuator.getVrsta() == 0 || aktuator.getVrsta() == 3) {//od-do cjelobrojno i dan/ne
                            System.out.println("Aktuator: " + aktuator.getNaziv() + ", min vrijednost: " + aktuator.getMinVrijednost() + ", max vrijednost: " + aktuator.getMaxVrijednost() + ", vrijednost: " + aktuator.getVrijednost().intValue());
                        } else {
                            System.out.println("Aktuator: " + aktuator.getNaziv() + ", min vrijednost: " + aktuator.getMinVrijednost() + ", max vrijednost: " + aktuator.getMaxVrijednost() + ", vrijednost: " + aktuator.getVrijednost());
                        }
                        Float staraVrijednost = aktuator.getVrijednost();
                        Boolean smjer = aktuator.getSmjer();
                        int vrijednostInt;
                        float vrijednostFloat;
                        if (aktuator.getVrsta() == 0) {//od-do cjelobrojno
                            int min = aktuator.getMinVrijednost().intValue();
                            int max = aktuator.getMaxVrijednost().intValue();
                            if (smjer) {
                                vrijednostInt = generatorBrojeva.dajSlucajniBroj1(staraVrijednost.intValue()+1, max);//
                                if (vrijednostInt == max) {
                                    aktuator.setSmjer(false);
                                }
                            } else {
                                vrijednostInt = generatorBrojeva.dajSlucajniBroj1(min, staraVrijednost.intValue());
                                if (vrijednostInt == min) {
                                    aktuator.setSmjer(true);
                                }
                            }
                            float pom = (float) vrijednostInt;
                            aktuator.setVrijednost(pom);

                        } else if (aktuator.getVrsta() == 1) {
                            float min = aktuator.getMinVrijednost();
                            float max = aktuator.getMaxVrijednost();
                            if (smjer) {
                                vrijednostFloat = generatorBrojeva.dajSlucajniBroj(staraVrijednost, max);
                                if (vrijednostFloat == max) {
                                    aktuator.setSmjer(false);
                                }
                            } else {
                                vrijednostFloat = generatorBrojeva.dajSlucajniBroj(min, staraVrijednost);
                                if (vrijednostFloat == min) {
                                    aktuator.setSmjer(true);
                                }
                            }
                            aktuator.setVrijednost(Float.parseFloat(String.format("%.1f", vrijednostFloat).replace(",", ".")));
                        } else if (aktuator.getVrsta() == 2) {
                            float min = aktuator.getMinVrijednost();
                            float max = aktuator.getMaxVrijednost();
                            if (smjer) {
                                vrijednostFloat = generatorBrojeva.dajSlucajniBroj(staraVrijednost, max);
                                if (vrijednostFloat == max) {
                                    aktuator.setSmjer(false);
                                }
                            } else {
                                vrijednostFloat = generatorBrojeva.dajSlucajniBroj(min, staraVrijednost);
                                if (vrijednostFloat == min) {
                                    aktuator.setSmjer(true);
                                }
                            }
                            aktuator.setVrijednost(Float.parseFloat(String.format("%.5f", vrijednostFloat).replace(",", ".")));

                        } else if (aktuator.getVrsta() == 3) {//binarno-suprotnja radnja tren stanju
                            if (staraVrijednost.intValue() == 0) {
                                vrijednostInt = 1;
                            } else {
                                vrijednostInt = 0;
                            }
                            float pom = (float) vrijednostInt;
                            aktuator.setVrijednost(pom);

                            if (aktuator.getVrsta() == 0 || aktuator.getVrsta() == 3) {
                                System.out.println("Aktuator: " + aktuator.getNaziv() + ", min vrijednost: " + aktuator.getMinVrijednost() + ", max vrijednost: " + aktuator.getMaxVrijednost() + ", vrijednost: " + aktuator.getVrijednost().intValue());
                            } else {
                                System.out.println("Aktuator: " + aktuator.getNaziv() + ", min vrijednost: " + aktuator.getMinVrijednost() + ", max vrijednost: " + aktuator.getMaxVrijednost() + ", vrijednost: " + aktuator.getVrijednost());

                            }
                        }
                    }
                }
            }
        }

    }
    
    
    

}
