/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivaanic2_zadaca_1.builder;

/**
 *
 * @author ivaanic2
 */
public class SenzorBuilderImpl implements SenzorBuilder {
    
    private Senzor senzor;
    
    public SenzorBuilderImpl() {
        senzor = new Senzor();
    }

    @Override
    public Senzor build() {
        return senzor;
    }

    @Override
    public SenzorBuilder setNaziv(String naziv) {
        senzor.setNaziv(naziv);
        return this;
    }

    @Override
    public SenzorBuilder setTip(int tip) {
        senzor.setTip(tip);
        return this;
    }

    @Override
    public SenzorBuilder setVrsta(int vrsta) {
        senzor.setVrsta(vrsta);
        return this;
    }

    @Override
    public SenzorBuilder setMinVrijednost(Float minVrijednost) {
        senzor.setMinVrijednost(minVrijednost);
        return this;
    }

    @Override
    public SenzorBuilder setMaxVrijednost(Float maxVrijednost) {
        senzor.setMaxVrijednost(maxVrijednost);
        return this;
    }

    @Override
    public SenzorBuilder setKomentar(String komentar) {
        senzor.setKomentar(komentar);
        return this;
    }

    @Override
    public SenzorBuilder setStatus(int status) {
        senzor.setStatus(status);
        return this;
    }

    @Override
    public SenzorBuilder setBrojGreski(int brojGreski) {
        senzor.setBrojGreski(brojGreski);
        return this;
    }

    @Override
    public SenzorBuilder setVrijednost(Float vrijednost) {
        senzor.setVrijednost(vrijednost);
        return this;
    }

   
}
