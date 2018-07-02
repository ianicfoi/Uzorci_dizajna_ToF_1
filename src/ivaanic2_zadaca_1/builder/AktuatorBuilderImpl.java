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
public class AktuatorBuilderImpl implements AktuatorBuilder {
    
    private Aktuator aktuator;

    public AktuatorBuilderImpl() {
        aktuator = new Aktuator();
    }
    
    

    @Override
    public Aktuator build() {
        return aktuator;
    }

    @Override
    public AktuatorBuilder setNaziv(String naziv) {
        aktuator.setNaziv(naziv);
        return this;
    }

    @Override
    public AktuatorBuilder setTip(int tip) {
        aktuator.setTip(tip);
        return this;
    }

    @Override
    public AktuatorBuilder setVrsta(int vrsta) {
        aktuator.setVrsta(vrsta);
        return this;
    }

    @Override
    public AktuatorBuilder setMinVrijednost(Float minVrijednost) {
        aktuator.setMinVrijednost(minVrijednost);
        return this;
    }

    @Override
    public AktuatorBuilder setMaxVrijednost(Float maxVrijednost) {
        aktuator.setMaxVrijednost(maxVrijednost);
        return this;
    }

    @Override
    public AktuatorBuilder setKomentar(String komentar) {
        aktuator.setKomentar(komentar);
        return this;
    }

    @Override
    public AktuatorBuilder setStatus(int status) {
        aktuator.setStatus(status);
        return this;
    }

    @Override
    public AktuatorBuilder setBrojGreski(int brojGreski) {
        aktuator.setBrojGreski(brojGreski);
        return this;
    }

    @Override
    public AktuatorBuilder setVrijednost(Float vrijednost) {
        aktuator.setVrijednost(vrijednost);
        return this;
    }
    
}
