package com.example.S5_L1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe che rappresenta le informazioni nutrizionali di un elemento del menù
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformazioniNutrizionali {
    private int calorie;
    private double proteine; // in grammi
    private double carboidrati; // in grammi
    private double grassi; // in grammi
    private double sodio; // in milligrammi
    
    @Override
    public String toString() {
        return String.format("Calorie: %d, Proteine: %.1fg, Carboidrati: %.1fg, Grassi: %.1fg, Sodio: %.1fmg", 
                           calorie, proteine, carboidrati, grassi, sodio);
    }
}