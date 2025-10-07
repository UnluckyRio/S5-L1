package com.example.S5_L1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe che rappresenta un tavolo del ristorante
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int copertiMassimi;
    private StatoTavolo stato;
    
    /**
     * Costruttore per creare un tavolo libero
     */
    public Tavolo(int numero, int copertiMassimi) {
        this.numero = numero;
        this.copertiMassimi = copertiMassimi;
        this.stato = StatoTavolo.LIBERO;
    }
    
    /**
     * Occupa il tavolo
     */
    public void occupa() {
        this.stato = StatoTavolo.OCCUPATO;
    }
    
    /**
     * Libera il tavolo
     */
    public void libera() {
        this.stato = StatoTavolo.LIBERO;
    }
    
    /**
     * Verifica se il tavolo è disponibile
     */
    public boolean isDisponibile() {
        return this.stato == StatoTavolo.LIBERO;
    }
    
    @Override
    public String toString() {
        return String.format("Tavolo %d (max %d coperti) - %s", 
                           numero, copertiMassimi, stato.getDescrizione());
    }
}