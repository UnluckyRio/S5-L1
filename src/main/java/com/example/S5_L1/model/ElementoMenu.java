package com.example.S5_L1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe base astratta per tutti gli elementi del menù
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ElementoMenu {
    protected String nome;
    protected double prezzo;
    protected InformazioniNutrizionali informazioniNutrizionali;
    
    /**
     * Metodo astratto per ottenere la descrizione dell'elemento
     */
    public abstract String getDescrizione();
    
    @Override
    public String toString() {
        return String.format("%-30s €%.2f\n%s\n%s", 
                           nome, prezzo, getDescrizione(), informazioniNutrizionali.toString());
    }
}