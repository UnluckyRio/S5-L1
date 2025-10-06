package com.example.S5_L1;

import com.example.S5_L1.model.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe principale dell'applicazione Spring Boot per la gestione del menù pizzeria
 */
@SpringBootApplication
public class S5L1Application {

	@Autowired
	private Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(S5L1Application.class, args);
	}

	/**
	 * CommandLineRunner per eseguire la stampa del menù all'avvio dell'applicazione
	 */
	@Bean
	public CommandLineRunner run() {
		return args -> {
			System.out.println("\n🍕 Benvenuti alla nostra Pizzeria! 🍕\n");
			
			// Stampa il menù completo utilizzando il Bean Menu
			menu.stampaMenu();
			
			System.out.println("\nGrazie per aver visitato il nostro menù!");
			System.out.println("Per ordinare, contattaci al numero: 📞 123-456-7890");
		};
	}
}
