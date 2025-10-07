package com.example.S5_L1.model;

/**
 * Enum che rappresenta lo stato di un tavolo
 */
public enum StatoTavolo {
    LIBERO("Libero"),
    OCCUPATO("Occupato");
    
    private final String descrizione;
    
    StatoTavolo(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    @Override
    public String toString() {
        return descrizione;
    }
}