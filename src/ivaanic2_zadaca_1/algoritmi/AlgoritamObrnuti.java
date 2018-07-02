/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.algoritmi;

import ivaanic2_zadaca_1.Ivaanic2_zadaca_1;
import ivaanic2_zadaca_1.UpisUDatoteku;
import ivaanic2_zadaca_1.model.Aktuatori;
import ivaanic2_zadaca_1.model.Senzori;
import ivaanic2_zadaca_1.builder.Aktuator;
import ivaanic2_zadaca_1.builder.Senzor;
import ivaanic2_zadaca_1.singleton.GeneratorSlucajnogBrojaSingleton;
import ivaanic2_zadaca_1.singleton.Mjesta;
import ivaanic2_zadaca_1.singleton.StatistikaSingleton;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ivaanic2
 */
public class AlgoritamObrnuti {
    
    GeneratorSlucajnogBrojaSingleton generator = GeneratorSlucajnogBrojaSingleton.getInstance();
    StatistikaSingleton stat = StatistikaSingleton.getInstance();
    
    

    public void provjeriMjesta() throws UnsupportedEncodingException, FileNotFoundException {
        
        Mjesta ms = Mjesta.getInstance();

        List<Senzor> neispravniSenzori = new ArrayList<>();
        List<Senzor> zamjenskiSenzori = new ArrayList<>();

        List<Aktuator> neispravniAktuatori = new ArrayList<>();
        List<Aktuator> zamjenskiAktuatori = new ArrayList<>();
        Random rand = new Random();

        UpisUDatoteku zapis = new UpisUDatoteku(Ivaanic2_zadaca_1.datotekaRezultata);

        for (int i = ms.getListaMjesta().size() - 1; i >= 0; i--) {
            for (Senzor senzori : ms.getListaMjesta().get(i).getListaSenzoraZaMjesto()) {
                if (senzori.getStatus() == 0) {
                    senzori.setBrojGreski(senzori.getBrojGreski() + 1);
                }
                if (senzori.getBrojGreski() == 3) {
                    System.out.println("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", neispravan senzor: " + senzori.getNaziv() + ", greski: " + senzori.getBrojGreski());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", neispravan senzor: " + senzori.getNaziv() + ", greski: " + senzori.getBrojGreski());
                    neispravniSenzori.add(senzori);
                    stat.setBrojNeispravnihSenzora(stat.getBrojNeispravnihSenzora()+1);

                    Senzor senz = null;
                    
                    while (senz == null || senz.getTip() != senzori.getTip()) {
                        int random = rand.nextInt(ms.getListaSenzora().size());
                        senz = ms.getListaSenzora().get(random);
                        int status = senz.vratiStatus();
                        senz.setStatus(status);
                        //System.out.println("Mjesto: " + mjestaSingleton.getNaziv() + ", zamjenski senzor " + senz.getNaziv());
                    }
                    zamjenskiSenzori.add(senz);
                    stat.setZamjenaSenzora(stat.getZamjenaSenzora()+1);
                    System.out.println("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", zamjenski senzor " + senz.getNaziv());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", zamjenski senzor " + senz.getNaziv());

                }
            }
            ms.getListaMjesta().get(i).getListaSenzoraZaMjesto().removeAll(neispravniSenzori);
            neispravniSenzori.clear();
            ms.getListaMjesta().get(i).getListaSenzoraZaMjesto().addAll(zamjenskiSenzori);
            zamjenskiSenzori.clear();
        }
        
        
        for (int i = ms.getListaMjesta().size() - 1; i >= 0; i--) {
            for (Aktuator aktuatori : ms.getListaMjesta().get(i).getListaAktuatoraZaMjesto()) {
                if (aktuatori.getStatus() == 0) {
                    aktuatori.setBrojGreski(aktuatori.getBrojGreski() + 1);
                }
                if (aktuatori.getBrojGreski() == 3) {
                    System.out.println("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", neispravan aktuator: " + aktuatori.getNaziv() + ", greski: " + aktuatori.getBrojGreski());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", neispravan aktuator: " + aktuatori.getNaziv() + ", greski: " + aktuatori.getBrojGreski());
                    neispravniAktuatori.add(aktuatori);
                    stat.setBrojNeispravnihAktuatora(stat.getBrojNeispravnihAktuatora()+1);

                    Aktuator akt = null;

                    while (akt == null || akt.getTip() != akt.getTip()) {
                        int random = rand.nextInt(ms.getListaAktuatora().size());
                        akt = ms.getListaAktuatora().get(random);
                        int status = akt.vratiStatus();
                        akt.setStatus(status);
                        //System.out.println("Mjesto: " + mjestaSingleton.getNaziv() + ", zamjenski senzor " + senz.getNaziv());
                    }
                    zamjenskiAktuatori.add(akt);
                    stat.setZamjenaAktuatora(stat.getZamjenaAktuatora()+1);
                    System.out.println("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", zamjenski aktuator " + akt.getNaziv());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + ms.getListaMjesta().get(i).getNaziv() + ", zamjenski aktuator " + akt.getNaziv());

                }
            }
            ms.getListaMjesta().get(i).getListaSenzoraZaMjesto().removeAll(neispravniSenzori);
            neispravniSenzori.clear();
            ms.getListaMjesta().get(i).getListaSenzoraZaMjesto().addAll(zamjenskiSenzori);
            zamjenskiSenzori.clear();
        }
        
        
        
        

    }

}
