package com.example.S5_L1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe che rappresenta una bevanda del menù
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Bevanda extends ElementoMenu {
    private double volume; // in litri
    private double gradazioneAlcolica; // percentuale di alcol
    
    public Bevanda(String nome, double prezzo, InformazioniNutrizionali informazioniNutrizionali, 
                   double volume, double gradazioneAlcolica) {
        super(nome, prezzo, informazioniNutrizionali);
        this.volume = volume;
        this.gradazioneAlcolica = gradazioneAlcolica;
    }
    
    @Override
    public String getDescrizione() {
        StringBuilder descrizione = new StringBuilder();
        descrizione.append(String.format("Volume: %.2fL", volume));
        
        if (gradazioneAlcolica > 0) {
            descrizione.append(String.format(", Alcol: %.1f%%", gradazioneAlcolica));
        }
        
        return descrizione.toString();
    }
    
    @Override
    public String toString() {
        return String.format("%-30s €%.2f\n%s\n%s", 
                           nome, prezzo, getDescrizione(), informazioniNutrizionali.toString());
    }
}