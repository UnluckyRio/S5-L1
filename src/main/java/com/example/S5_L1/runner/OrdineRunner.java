package com.example.S5_L1.runner;

import com.example.S5_L1.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner per gestire gli ordini della pizzeria
 */
@Slf4j
@Component
@Order(2) // Esegue dopo il runner del menu
public class OrdineRunner implements CommandLineRunner {
    
    @Autowired
    private Menu menu;
    
    @Override
    public void run(String... args) throws Exception {
        log.info("=== SISTEMA GESTIONE ORDINI PIZZERIA ===");
        
        // Inizializzazione tavoli
        Tavolo tavolo1 = new Tavolo(1, 4);
        Tavolo tavolo2 = new Tavolo(2, 6);
        Tavolo tavolo3 = new Tavolo(3, 2);
        
        log.info("Tavoli inizializzati:");
        log.info("- {}", tavolo1);
        log.info("- {}", tavolo2);
        log.info("- {}", tavolo3);
        
        // Creazione di un ordine di esempio
        log.info("\n=== CREAZIONE NUOVO ORDINE ===");
        
        // Creo un nuovo ordine per il tavolo 1 con 3 coperti
        Ordine ordine = new Ordine(tavolo1, 3);
        
        // Aggiungo elementi all'ordine
        
        // 1. Pizza Hawaiian XL
        Pizza hawaiianXL = menu.getPizze().stream()
            .filter(p -> p.getNome().equals("Hawaiian Pizza") && p.isFormatoXL())
            .findFirst()
            .orElse(null);
        
        if (hawaiianXL != null) {
            ordine.aggiungiElemento(hawaiianXL);
            log.info("Aggiunta: {} - €{}", hawaiianXL.getNome() + " XL", hawaiianXL.getPrezzoTotale());
        }
        
        // 2. Pizza Margherita normale
        Pizza margherita = menu.getPizze().stream()
            .filter(p -> p.getNome().equals("Pizza Margherita") && !p.isFormatoXL())
            .findFirst()
            .orElse(null);
        
        if (margherita != null) {
            ordine.aggiungiElemento(margherita);
            log.info("Aggiunta: {} - €{}", margherita.getNome(), margherita.getPrezzoTotale());
        }
        
        // 3. Birra
        Bevanda birra = menu.getBevande().stream()
            .filter(b -> b.getNome().equals("Birra"))
            .findFirst()
            .orElse(null);
        
        if (birra != null) {
            ordine.aggiungiElemento(birra);
            log.info("Aggiunta: {} - €{}", birra.getNome(), birra.getPrezzo());
        }
        
        // 4. Coca Cola
        Bevanda cocaCola = menu.getBevande().stream()
            .filter(b -> b.getNome().equals("Coca Cola"))
            .findFirst()
            .orElse(null);
        
        if (cocaCola != null) {
            ordine.aggiungiElemento(cocaCola);
            log.info("Aggiunta: {} - €{}", cocaCola.getNome(), cocaCola.getPrezzo());
        }
        
        // Stampa dell'ordine completo
        log.info("\n=== DETTAGLIO ORDINE COMPLETO ===");
        log.info("\\n{}", ordine.getDettaglioCompleto());
        
        // Simulazione cambio stato ordine
        log.info("\n=== SIMULAZIONE GESTIONE ORDINE ===");
        log.info("Ordine creato: {}", ordine);
        
        // Simula che l'ordine è pronto
        Thread.sleep(1000); // Pausa di 1 secondo per simulare il tempo di preparazione
        ordine.cambiaStato(StatoOrdine.PRONTO);
        log.info("Ordine aggiornato: {}", ordine);
        
        // Simula che l'ordine è servito
        Thread.sleep(1000);
        ordine.cambiaStato(StatoOrdine.SERVITO);
        log.info("Ordine completato: {}", ordine);
        log.info("Stato tavolo dopo servizio: {}", tavolo1);
        
        log.info("\n=== FINE GESTIONE ORDINI ===");
    }
}