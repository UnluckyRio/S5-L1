package com.example.S5_L1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta il menù completo della pizzeria
 */
@Data
@NoArgsConstructor
public class Menu {
    private List<Pizza> pizze;
    private List<Topping> toppings;
    private List<Bevanda> bevande;
    
    public Menu(List<Pizza> pizze, List<Topping> toppings, List<Bevanda> bevande) {
        this.pizze = pizze != null ? pizze : new ArrayList<>();
        this.toppings = toppings != null ? toppings : new ArrayList<>();
        this.bevande = bevande != null ? bevande : new ArrayList<>();
    }
    
    /**
     * Stampa il menù completo formattato
     */
    public void stampaMenu() {
        System.out.println("=".repeat(80));
        System.out.println("                           MENU PIZZERIA");
        System.out.println("=".repeat(80));
        
        // Sezione Pizze
        System.out.println("\n🍕 PIZZE");
        System.out.println("-".repeat(80));
        for (Pizza pizza : pizze) {
            System.out.println(pizza);
            System.out.println();
        }
        
        // Sezione Toppings
        System.out.println("\n🧀 TOPPINGS DISPONIBILI");
        System.out.println("-".repeat(80));
        for (Topping topping : toppings) {
            System.out.printf("%-20s €%.2f - %s\n", 
                            topping.getNome(), 
                            topping.getPrezzo(), 
                            topping.getInformazioniNutrizionali().toString());
        }
        
        // Sezione Bevande
        System.out.println("\n🥤 BEVANDE");
        System.out.println("-".repeat(80));
        for (Bevanda bevanda : bevande) {
            System.out.println(bevanda);
            System.out.println();
        }
        
        System.out.println("=".repeat(80));
    }
    
    @Override
    public String toString() {
        return String.format("Menu: %d pizze, %d toppings, %d bevande", 
                           pizze.size(), toppings.size(), bevande.size());
    }
}