package com.example.S5_L1.model;

/**
 * Enum che rappresenta lo stato di un ordine
 */
public enum StatoOrdine {
    IN_CORSO("In corso"),
    PRONTO("Pronto"),
    SERVITO("Servito");
    
    private final String descrizione;
    
    StatoOrdine(String descrizione) {
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