/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1;

import ivaanic2_zadaca_1.dretve.DretvaProvjeraMjesta;
import ivaanic2_zadaca_1.singleton.GeneratorSlucajnogBrojaSingleton;
import ivaanic2_zadaca_1.singleton.Mjesta;
import ivaanic2_zadaca_1.singleton.StatistikaSingleton;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author ivaanic2
 */
public class Ivaanic2_zadaca_1 {

    public static String datotekaMjesta;
    public static String datotekaSenzora;
    public static String datotekaAktuatora;
    public static String datotekaRezultata;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        UpisUDatoteku zapis = new UpisUDatoteku("izlaz.txt");
        GeneratorSlucajnogBrojaSingleton generator = GeneratorSlucajnogBrojaSingleton.getInstance();
        StatistikaSingleton stat = StatistikaSingleton.getInstance();
        Random rand = new Random();

        
        if (args.length != 8) {
            System.out.println("Mora biti 8 argumenata.");
            UpisUDatoteku.upisiUDatoteku("Mora biti 8 argumenata.");
        } else if (args[0].length() < 3) {
            System.out.println("Minimalni broj znamenki za sjeme je 3.");
            UpisUDatoteku.upisiUDatoteku("Minimalni broj znamenki za sjeme je 3.");
            System.exit(0);
        }
        
        /*Izvrsavanje: seed za generator (min 3 znamenke), datoteka mjesta, datoteka senzora, datoteka aktuatora,
        algoritam provjere, trajanje ciklusa dretve u sek, broj ciklusa dretve, datoteka rez
	> dkermek_zadaca_1 717 DZ_1_mjesta.txt DZ_1_senzori.txt DZ_1_aktuatori.txt  AlgoritamAbecedno 5 20 izlaz.txt
         */
       
        int sjeme = 0;
        sjeme = Integer.parseInt(args[0]);
        System.out.println("Sjeme: " + sjeme);
        rand.setSeed(sjeme);
        datotekaMjesta = args[1];
        System.out.println("Datoteka mjesta: " + datotekaMjesta);
        UpisUDatoteku.upisiUDatoteku("Datoteka mjesta: " + datotekaMjesta);
        datotekaSenzora = args[2];
        System.out.println("Datoteka senzora: " + datotekaSenzora);
        UpisUDatoteku.upisiUDatoteku("Datoteka senzora: " + datotekaSenzora);
        datotekaAktuatora = args[3];
        System.out.println("Datoteka aktuatora:" + datotekaAktuatora);
        UpisUDatoteku.upisiUDatoteku("Datoteka aktuatora:" + datotekaAktuatora);
        String algoritamProvjere = args[4];
        System.out.println("Algoritam: " + algoritamProvjere);
        UpisUDatoteku.upisiUDatoteku("Algoritam: " + algoritamProvjere);
        int trajanjeCiklusaDretve = Integer.parseInt(args[5]);
        System.out.println("Trajanje ciklusa: " + trajanjeCiklusaDretve);
        UpisUDatoteku.upisiUDatoteku("Trajanje ciklusa: " + trajanjeCiklusaDretve);
        int brojCiklusaDretve = Integer.parseInt(args[6]);
        System.out.println("Broj ciklusa: " + brojCiklusaDretve);
        UpisUDatoteku.upisiUDatoteku("Broj ciklusa: " + brojCiklusaDretve);
        datotekaRezultata = args[7];
        System.out.println("Datoteka rezultata: " + datotekaRezultata);
        UpisUDatoteku.upisiUDatoteku("Datoteka rezultata: " + datotekaRezultata);
        
        GeneratorSlucajnogBrojaSingleton.sjeme = sjeme;


        int randomTest = rand.nextInt(50) + 1;
        System.out.println(randomTest);
        System.out.println(generator.dajSlucajniBroj());
        
        Mjesta ms = Mjesta.getInstance();
        ms.konfigurirajSustav();
        ms.inicijalizirajSustav();
        
        DretvaProvjeraMjesta dretva = new DretvaProvjeraMjesta(brojCiklusaDretve, trajanjeCiklusaDretve, algoritamProvjere);
        dretva.start();
        
        UpisUDatoteku.zatvoriDatoteku();

    }

}
