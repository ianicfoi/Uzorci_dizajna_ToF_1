/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.singleton;

import java.util.Random;

/**
 * 
 *
 * @author ivaanic2
 */
public class GeneratorSlucajnogBrojaSingleton {

    //varijabla instance
    private static GeneratorSlucajnogBrojaSingleton instanca = null;
    Random rand0 = new Random();
    public static int sjeme;
    Random rand = new Random(sjeme);

    private GeneratorSlucajnogBrojaSingleton() {
    }

    public static GeneratorSlucajnogBrojaSingleton getInstance() {
        if (instanca == null) {
            instanca = new GeneratorSlucajnogBrojaSingleton();
        }
        return instanca;
    }
    
    
    public int dajSlucajniBroj() {
        return rand.nextInt(20);
    }

//    public int dajSlucajniBroj1(int odBroja, int doBroja) {
//        if(odBroja == 1 && doBroja == 1)
//            return 1;
//        else
//            return rand.nextInt(doBroja - odBroja) + odBroja;
//    }
//    
//    
//
//    public float dajSlucajniBroj(float odBroja, float doBroja) {
//        float slucajniBroj = odBroja + rand.nextFloat() * (doBroja - odBroja);
//        return slucajniBroj;
//    }
    
    public int dajSlucajniBroj1(int odBroja, int doBroja){
        int slucajniBroj = odBroja + rand.nextInt((doBroja - odBroja) + 1);
        return slucajniBroj;
    }

    public float dajSlucajniBroj(float odBroja, float doBroja) {
        float slucajniBroj = odBroja + rand.nextFloat() * (doBroja - odBroja);
        return slucajniBroj;
    }

   

}
