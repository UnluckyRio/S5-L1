# S5-L1

### Requisiti Implementati:

1.1 Gerarchia di Classi:

- `ElementoMenu.java` - Classe base astratta per tutti gli elementi
- `Pizza.java` - Gestisce pizze con base margherita e toppings multipli
- `Topping.java` - Ingredienti aggiuntivi per le pizze
- `Bevanda.java` - Bevande con volume e gradazione alcolica
- `Menu.java` - Contenitore per tutti gli elementi del menù
- `InformazioniNutrizionali.java` - Informazioni nutrizionali complete
  1.2 Classe di Configurazione:

- `MenuConfig.java` - Contiene tutti i Beans Spring per:

  - 6 toppings diversi (Prosciutto, Ananas, Funghi, Salame, Olive, Peperoni)
  - 6 pizze predefinite (Margherita, Hawaiian, Salami - anche in formato XL)
  - 5 bevande (Acqua, Coca Cola, Birra, Vino, Limonata)
  - Bean Menu completo
    1.3 Classe Main:

- `S5L1Application.java` - Utilizza il Bean Menu e stampa il contenuto all'avvio
  Funzionalità Opzionale - Formato XL:

- ✅ Implementato supporto per pizze formato XL con prezzo moltiplicato per 1.5x
- ✅ Informazioni nutrizionali scalate automaticamente per il formato XL

### 🔧 Caratteristiche Tecniche:

- Lombok : Utilizzato per ridurre il boilerplate code con @Data , @AllArgsConstructor , @NoArgsConstructor
- Spring Boot : Configurazione con @Configuration e @Bean
- Dependency Injection : Il Bean Menu viene iniettato automaticamente
- Informazioni Nutrizionali : Calorie, proteine, carboidrati, grassi e sodio per ogni elemento
- Toppings Multipli : Possibilità di aggiungere più volte lo stesso topping
- Calcolo Automatico : Prezzo e valori nutrizionali calcolati dinamicamente

### 📋 Output del Menù:

L'applicazione stampa un menù completo e ben formattato che include:

- Sezione pizze con prezzi e informazioni nutrizionali totali
- Lista toppings disponibili con relativi costi
- Sezione bevande con volume e gradazione alcolica
- Formattazione professionale con emoji e separatori visivi
