/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.algoritmi;

import ivaanic2_zadaca_1.Ivaanic2_zadaca_1;
import ivaanic2_zadaca_1.UpisUDatoteku;
import ivaanic2_zadaca_1.builder.Aktuator;
import ivaanic2_zadaca_1.builder.Senzor;
import ivaanic2_zadaca_1.model.Aktuatori;
import ivaanic2_zadaca_1.model.Senzori;
import ivaanic2_zadaca_1.singleton.GeneratorSlucajnogBrojaSingleton;
import ivaanic2_zadaca_1.singleton.Mjesta;
import ivaanic2_zadaca_1.singleton.StatistikaSingleton;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Temeljem odabranog algoritma provjere (potrebno je implementirati min 3
 * različita algoritma) dretva u zadanim ciklusima provjerava po jedno mjesto s
 * time da jedno mjesto ne može biti dva puta provjereno dok nisu sva ostala
 * mjesta provjerena. Provjera mjesta polazi od utvrđivanja statusa njegovih
 * uređaja. Uređaj koji 3 puta u nizu (3 slijedna ciklusa dretve za isto mjesto)
 * vrati pogrešku, označava se kao neispravan te ga je potrebno odmah zamijeniti
 * novim uređajem istog modela i inicijalizirati. Potrebno je ispisati
 * informacije u obavljanim poslovima.
 *
 * @author ivaanic2
 */
public class AlgoritamAbecedni {
    
    
    GeneratorSlucajnogBrojaSingleton generator = GeneratorSlucajnogBrojaSingleton.getInstance();
    StatistikaSingleton stat = StatistikaSingleton.getInstance();
    
    
    public void provjeriMjesta() throws UnsupportedEncodingException, FileNotFoundException {
        UpisUDatoteku zapis = new UpisUDatoteku(Ivaanic2_zadaca_1.datotekaRezultata);
        Mjesta ms = Mjesta.getInstance();
        List<Senzor> neispravniSenzori = new ArrayList<>();
        List<Senzor> zamjenskiSenzori = new ArrayList<>();
        
        List<Aktuator> neispravniAktuatori = new ArrayList<>();
        List<Aktuator> zamjenskiAktuatori = new ArrayList<>();
        Random rand = new Random();
        
        
        //listaMjestaAlg.addAll(Mjesta.listaMjesta);
      
        Collections.sort(ms.getListaMjesta());
        
        for (Mjesta mjestaSingleton : ms.getListaMjesta()) {
            System.out.println("abecedno: " + mjestaSingleton.getNaziv());
        }
        
        for (Mjesta mjestaSingleton : ms.getListaMjesta()) {
            for (Senzor senzori : mjestaSingleton.getListaSenzoraZaMjesto()) {
                if (senzori.getStatus() == 0) {
                    senzori.setBrojGreski(senzori.getBrojGreski()+1); 
                }
                if (senzori.getBrojGreski() == 3) {
                    System.out.println("Mjesto: " + mjestaSingleton.getNaziv() + ", neispravan senzor: " + senzori.getNaziv() + ", greski: " + senzori.getBrojGreski());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + mjestaSingleton.getNaziv() + ", neispravan senzor: " + senzori.getNaziv() + ", greski: " + senzori.getBrojGreski());
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
                    System.out.println("Mjesto: " + mjestaSingleton.getNaziv() + ", zamjenski senzor " + senz.getNaziv());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + mjestaSingleton.getNaziv() + ", zamjenski senzor " + senz.getNaziv());
                    
                }
            }
            
            mjestaSingleton.getListaSenzoraZaMjesto().removeAll(neispravniSenzori);
            neispravniSenzori.clear();
            mjestaSingleton.getListaSenzoraZaMjesto().addAll(zamjenskiSenzori);
            zamjenskiSenzori.clear();
        }
        
        
        for (Mjesta mjestaSingleton : ms.getListaMjesta()) {
            for (Aktuator aktuatori : mjestaSingleton.getListaAktuatoraZaMjesto()) {
                if (aktuatori.getStatus() == 0) {
                    aktuatori.setBrojGreski(aktuatori.getBrojGreski()+1); 
                }
                if (aktuatori.getBrojGreski() == 3) {
                    System.out.println("Mjesto: " + mjestaSingleton.getNaziv() + ", neispravan aktuator: " + aktuatori.getNaziv() + ", greski: " + aktuatori.getBrojGreski());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + mjestaSingleton.getNaziv() + ", neispravan aktuator: " + aktuatori.getNaziv() + ", greski: " + aktuatori.getBrojGreski());
                    neispravniAktuatori.add(aktuatori);
                    stat.setBrojNeispravnihAktuatora(stat.getBrojNeispravnihAktuatora()+1);
                    
                    Aktuator akt = null;
                    
                    
                    while (akt == null || akt.getTip() != akt.getTip()) {
                        int random = rand.nextInt(ms.getListaAktuatora().size());
                        akt = ms.getListaAktuatora().get(random);
                        int status = akt.vratiStatus();
                        akt.setStatus(status);
                    }
                    zamjenskiAktuatori.add(akt);
                    stat.setZamjenaAktuatora(stat.getZamjenaAktuatora()+1);
                    System.out.println("Mjesto: " + mjestaSingleton.getNaziv() + ", zamjenski aktuator " + akt.getNaziv());
                    UpisUDatoteku.upisiUDatoteku("Mjesto: " + mjestaSingleton.getNaziv() + ", zamjenski aktuator " + akt.getNaziv());
                    
                }
            }
            
            mjestaSingleton.getListaAktuatoraZaMjesto().removeAll(neispravniAktuatori);
            neispravniAktuatori.clear();
            mjestaSingleton.getListaAktuatoraZaMjesto().addAll(zamjenskiAktuatori);
            zamjenskiAktuatori.clear();
        }
   
    }
    
    

}
