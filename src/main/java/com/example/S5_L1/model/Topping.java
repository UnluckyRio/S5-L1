package com.example.S5_L1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe che rappresenta un topping per la pizza
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Topping extends ElementoMenu {
    
    public Topping(String nome, double prezzo, InformazioniNutrizionali informazioniNutrizionali) {
        super(nome, prezzo, informazioniNutrizionali);
    }
    
    @Override
    public String getDescrizione() {
        return "Topping aggiuntivo";
    }
    
    @Override
    public String toString() {
        return String.format("+ %s (€%.2f)", nome, prezzo);
    }
}