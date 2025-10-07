package com.example.S5_L1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un ordine del ristorante
 */
@Data
@NoArgsConstructor
@Component
public class Ordine {
    private static int contatore = 1;
    
    private int numeroOrdine;
    private StatoOrdine stato;
    private Tavolo tavolo;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private List<ElementoMenu> elementi;
    
    @Value("${pizzeria.costo.coperto:2.50}")
    private double costoCoperto;
    
    /**
     * Costruttore per creare un nuovo ordine
     */
    public Ordine(Tavolo tavolo, int numeroCoperti) {
        this.numeroOrdine = contatore++;
        this.stato = StatoOrdine.IN_CORSO;
        this.tavolo = tavolo;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = LocalDateTime.now();
        this.elementi = new ArrayList<>();
        
        // Occupa il tavolo quando viene creato l'ordine
        if (tavolo != null) {
            tavolo.occupa();
        }
    }
    
    /**
     * Aggiunge un elemento al menù all'ordine
     */
    public void aggiungiElemento(ElementoMenu elemento) {
        this.elementi.add(elemento);
    }
    
    /**
     * Rimuove un elemento dal menù dall'ordine
     */
    public void rimuoviElemento(ElementoMenu elemento) {
        this.elementi.remove(elemento);
    }
    
    /**
     * Calcola l'importo totale dell'ordine (elementi + coperti)
     */
    public double getImportoTotale() {
        double totaleElementi = elementi.stream()
            .mapToDouble(elemento -> {
                if (elemento instanceof Pizza) {
                    return ((Pizza) elemento).getPrezzoTotale();
                } else {
                    return elemento.getPrezzo();
                }
            })
            .sum();
        
        double totaleCoperti = numeroCoperti * costoCoperto;
        
        return totaleElementi + totaleCoperti;
    }
    
    /**
     * Calcola il totale dei soli elementi del menù
     */
    public double getTotaleElementi() {
        return elementi.stream()
            .mapToDouble(elemento -> {
                if (elemento instanceof Pizza) {
                    return ((Pizza) elemento).getPrezzoTotale();
                } else {
                    return elemento.getPrezzo();
                }
            })
            .sum();
    }
    
    /**
     * Calcola il totale dei coperti
     */
    public double getTotaleCoperti() {
        return numeroCoperti * costoCoperto;
    }
    
    /**
     * Cambia lo stato dell'ordine
     */
    public void cambiaStato(StatoOrdine nuovoStato) {
        this.stato = nuovoStato;
        
        // Se l'ordine è servito, libera il tavolo
        if (nuovoStato == StatoOrdine.SERVITO && tavolo != null) {
            tavolo.libera();
        }
    }
    
    /**
     * Restituisce una rappresentazione formattata dell'ordine
     */
    public String getDettaglioCompleto() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        sb.append("=".repeat(60)).append("\n");
        sb.append(String.format("ORDINE #%d - %s\n", numeroOrdine, stato.getDescrizione()));
        sb.append("=".repeat(60)).append("\n");
        sb.append(String.format("Tavolo: %s\n", tavolo != null ? tavolo.toString() : "N/A"));
        sb.append(String.format("Coperti: %d\n", numeroCoperti));
        sb.append(String.format("Ora acquisizione: %s\n", oraAcquisizione.format(formatter)));
        sb.append("-".repeat(60)).append("\n");
        sb.append("ELEMENTI ORDINATI:\n");
        sb.append("-".repeat(60)).append("\n");
        
        if (elementi.isEmpty()) {
            sb.append("Nessun elemento ordinato\n");
        } else {
            for (int i = 0; i < elementi.size(); i++) {
                ElementoMenu elemento = elementi.get(i);
                sb.append(String.format("%d. ", i + 1));
                
                if (elemento instanceof Pizza) {
                    Pizza pizza = (Pizza) elemento;
                    sb.append(String.format("%s - €%.2f\n", 
                        pizza.getNome() + (pizza.isFormatoXL() ? " XL" : ""), 
                        pizza.getPrezzoTotale()));
                    if (!pizza.getToppings().isEmpty()) {
                        sb.append("   Toppings: ");
                        for (int j = 0; j < pizza.getToppings().size(); j++) {
                            if (j > 0) sb.append(", ");
                            sb.append(pizza.getToppings().get(j).getNome());
                        }
                        sb.append("\n");
                    }
                } else {
                    sb.append(String.format("%s - €%.2f\n", elemento.getNome(), elemento.getPrezzo()));
                }
            }
        }
        
        sb.append("-".repeat(60)).append("\n");
        sb.append(String.format("Subtotale elementi: €%.2f\n", getTotaleElementi()));
        sb.append(String.format("Coperti (%d x €%.2f): €%.2f\n", 
                  numeroCoperti, costoCoperto, getTotaleCoperti()));
        sb.append("=".repeat(60)).append("\n");
        sb.append(String.format("TOTALE: €%.2f\n", getImportoTotale()));
        sb.append("=".repeat(60));
        
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return String.format("Ordine #%d - %s - Tavolo %d - €%.2f", 
                           numeroOrdine, stato.getDescrizione(), 
                           tavolo != null ? tavolo.getNumero() : 0, 
                           getImportoTotale());
    }
}