package com.example.S5_L1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta una pizza con base margherita e toppings aggiuntivi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Pizza extends ElementoMenu {
    private List<Topping> toppings;
    private boolean formatoXL;
    private static final double MOLTIPLICATORE_XL = 1.5; // Prezzo XL è 1.5x quello normale
    
    public Pizza(String nome, double prezzo, InformazioniNutrizionali informazioniNutrizionali) {
        super(nome, prezzo, informazioniNutrizionali);
        this.toppings = new ArrayList<>();
        this.formatoXL = false;
    }
    
    public Pizza(String nome, double prezzo, InformazioniNutrizionali informazioniNutrizionali, boolean formatoXL) {
        this(nome, prezzo, informazioniNutrizionali);
        this.formatoXL = formatoXL;
    }
    
    /**
     * Aggiunge un topping alla pizza
     */
    public void aggiungiTopping(Topping topping) {
        this.toppings.add(topping);
    }
    
    /**
     * Calcola il prezzo totale della pizza includendo i toppings e il formato XL
     */
    public double getPrezzoTotale() {
        double prezzoBase = this.prezzo;
        double prezzoToppings = toppings.stream().mapToDouble(Topping::getPrezzo).sum();
        double prezzoTotale = prezzoBase + prezzoToppings;
        
        if (formatoXL) {
            prezzoTotale *= MOLTIPLICATORE_XL;
        }
        
        return prezzoTotale;
    }
    
    /**
     * Calcola le informazioni nutrizionali totali includendo i toppings
     */
    public InformazioniNutrizionali getInformazioniNutrizionaliTotali() {
        InformazioniNutrizionali totali = new InformazioniNutrizionali(
            informazioniNutrizionali.getCalorie(),
            informazioniNutrizionali.getProteine(),
            informazioniNutrizionali.getCarboidrati(),
            informazioniNutrizionali.getGrassi(),
            informazioniNutrizionali.getSodio()
        );
        
        for (Topping topping : toppings) {
            InformazioniNutrizionali nutTopping = topping.getInformazioniNutrizionali();
            totali.setCalorie(totali.getCalorie() + nutTopping.getCalorie());
            totali.setProteine(totali.getProteine() + nutTopping.getProteine());
            totali.setCarboidrati(totali.getCarboidrati() + nutTopping.getCarboidrati());
            totali.setGrassi(totali.getGrassi() + nutTopping.getGrassi());
            totali.setSodio(totali.getSodio() + nutTopping.getSodio());
        }
        
        // Se è formato XL, moltiplica i valori nutrizionali
        if (formatoXL) {
            totali.setCalorie((int)(totali.getCalorie() * MOLTIPLICATORE_XL));
            totali.setProteine(totali.getProteine() * MOLTIPLICATORE_XL);
            totali.setCarboidrati(totali.getCarboidrati() * MOLTIPLICATORE_XL);
            totali.setGrassi(totali.getGrassi() * MOLTIPLICATORE_XL);
            totali.setSodio(totali.getSodio() * MOLTIPLICATORE_XL);
        }
        
        return totali;
    }
    
    @Override
    public String getDescrizione() {
        StringBuilder descrizione = new StringBuilder();
        descrizione.append("Base: pomodoro e mozzarella");
        
        if (!toppings.isEmpty()) {
            descrizione.append("\nToppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                if (i > 0) descrizione.append(", ");
                descrizione.append(toppings.get(i).getNome());
            }
        }
        
        if (formatoXL) {
            descrizione.append(" (Formato XL)");
        }
        
        return descrizione.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String nomeCompleto = nome + (formatoXL ? " XL" : "");
        sb.append(String.format("%-30s €%.2f\n", nomeCompleto, getPrezzoTotale()));
        sb.append(getDescrizione()).append("\n");
        sb.append(getInformazioniNutrizionaliTotali().toString());
        return sb.toString();
    }
}