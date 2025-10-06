package com.example.S5_L1.config;

import com.example.S5_L1.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

/**
 * Classe di configurazione Spring per la creazione dei Beans del menù
 */
@Configuration
public class MenuConfig {
    
    // ===== BEANS PER I TOPPINGS =====
    
    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 2.50, 
            new InformazioniNutrizionali(120, 18.0, 0.5, 4.0, 800.0));
    }
    
    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 1.50, 
            new InformazioniNutrizionali(35, 0.5, 8.0, 0.1, 2.0));
    }
    
    @Bean
    public Topping funghi() {
        return new Topping("Funghi", 2.00, 
            new InformazioniNutrizionali(25, 2.0, 3.0, 0.2, 5.0));
    }
    
    @Bean
    public Topping salame() {
        return new Topping("Salame", 3.00, 
            new InformazioniNutrizionali(180, 15.0, 1.0, 12.0, 950.0));
    }
    
    @Bean
    public Topping olive() {
        return new Topping("Olive", 1.80, 
            new InformazioniNutrizionali(80, 1.0, 2.0, 7.0, 400.0));
    }
    
    @Bean
    public Topping peperoni() {
        return new Topping("Peperoni", 1.70, 
            new InformazioniNutrizionali(20, 1.0, 4.0, 0.2, 3.0));
    }
    
    // ===== BEANS PER LE PIZZE =====
    
    @Bean
    public Pizza margherita() {
        return new Pizza("Pizza Margherita", 6.50, 
            new InformazioniNutrizionali(800, 35.0, 90.0, 25.0, 1200.0));
    }
    
    @Bean
    public Pizza margheritaXL() {
        return new Pizza("Pizza Margherita", 6.50, 
            new InformazioniNutrizionali(800, 35.0, 90.0, 25.0, 1200.0), true);
    }
    
    @Bean
    public Pizza hawaiian() {
        Pizza pizza = new Pizza("Hawaiian Pizza", 6.50, 
            new InformazioniNutrizionali(800, 35.0, 90.0, 25.0, 1200.0));
        pizza.aggiungiTopping(prosciutto());
        pizza.aggiungiTopping(ananas());
        return pizza;
    }
    
    @Bean
    public Pizza hawaiianXL() {
        Pizza pizza = new Pizza("Hawaiian Pizza", 6.50, 
            new InformazioniNutrizionali(800, 35.0, 90.0, 25.0, 1200.0), true);
        pizza.aggiungiTopping(prosciutto());
        pizza.aggiungiTopping(ananas());
        return pizza;
    }
    
    @Bean
    public Pizza salamiPizza() {
        Pizza pizza = new Pizza("Salami Pizza", 6.50, 
            new InformazioniNutrizionali(800, 35.0, 90.0, 25.0, 1200.0));
        pizza.aggiungiTopping(salame());
        pizza.aggiungiTopping(olive());
        return pizza;
    }
    
    @Bean
    public Pizza salamiPizzaXL() {
        Pizza pizza = new Pizza("Salami Pizza", 6.50, 
            new InformazioniNutrizionali(800, 35.0, 90.0, 25.0, 1200.0), true);
        pizza.aggiungiTopping(salame());
        pizza.aggiungiTopping(olive());
        return pizza;
    }
    
    // ===== BEANS PER LE BEVANDE =====
    
    @Bean
    public Bevanda acqua() {
        return new Bevanda("Acqua Naturale", 1.50, 
            new InformazioniNutrizionali(0, 0.0, 0.0, 0.0, 0.0), 0.5, 0.0);
    }
    
    @Bean
    public Bevanda cocaCola() {
        return new Bevanda("Coca Cola", 2.50, 
            new InformazioniNutrizionali(140, 0.0, 39.0, 0.0, 40.0), 0.33, 0.0);
    }
    
    @Bean
    public Bevanda birra() {
        return new Bevanda("Birra", 4.00, 
            new InformazioniNutrizionali(150, 1.5, 13.0, 0.0, 10.0), 0.33, 5.0);
    }
    
    @Bean
    public Bevanda vino() {
        return new Bevanda("Vino Rosso", 8.00, 
            new InformazioniNutrizionali(600, 0.5, 15.0, 0.0, 5.0), 0.75, 13.0);
    }
    
    @Bean
    public Bevanda limonata() {
        return new Bevanda("Limonata", 2.00, 
            new InformazioniNutrizionali(120, 0.2, 30.0, 0.0, 15.0), 0.33, 0.0);
    }
    
    // ===== LISTA DEI TOPPINGS =====
    
    @Bean
    public List<Topping> toppingsDisponibili() {
        return Arrays.asList(
            prosciutto(),
            ananas(), 
            funghi(),
            salame(),
            olive(),
            peperoni()
        );
    }
    
    // ===== LISTA DELLE PIZZE =====
    
    @Bean
    public List<Pizza> pizzeDisponibili() {
        return Arrays.asList(
            margherita(),
            margheritaXL(),
            hawaiian(),
            hawaiianXL(),
            salamiPizza(),
            salamiPizzaXL()
        );
    }
    
    // ===== LISTA DELLE BEVANDE =====
    
    @Bean
    public List<Bevanda> bevandeDisponibili() {
        return Arrays.asList(
            acqua(),
            cocaCola(),
            birra(),
            vino(),
            limonata()
        );
    }
    
    // ===== BEAN DEL MENU COMPLETO =====
    
    @Bean
    public Menu menu() {
        return new Menu(pizzeDisponibili(), toppingsDisponibili(), bevandeDisponibili());
    }
}