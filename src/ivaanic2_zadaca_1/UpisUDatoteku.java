/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivaanic2
 */
public class UpisUDatoteku {
    private String datoteka;
    static Writer writer;

    public UpisUDatoteku(String nazivDatoteke) throws UnsupportedEncodingException, FileNotFoundException {

        this.datoteka = nazivDatoteke;
        this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(datoteka, true), "utf-8"));

    }
    
    public static void upisiUDatoteku(String text) {
        try {
            writer.write(text);
            writer.append(System.lineSeparator());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UpisUDatoteku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UpisUDatoteku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UpisUDatoteku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void zatvoriDatoteku() {
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(UpisUDatoteku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
