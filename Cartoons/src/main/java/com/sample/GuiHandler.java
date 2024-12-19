package com.sample;

import javax.swing.*;
import java.awt.*;
import com.sample.Cartoons.Question;


public class GuiHandler {
    
    public int showDialog(String text, Object[] options) {
    	
    	UIManager.put("OptionPane.background", new Color(173, 216, 230)); // Jasny niebieski
        UIManager.put("Panel.background", new Color(173, 216, 230)); // Panel z takim samym t³em
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14)); // Pogrubienie tekstu pytania
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 14)); // Zmiana czcionki przycisków
        

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\Seba\\eclipse-workspace\\Cartoons\\Pika.png"); 
        Image img = originalIcon.getImage(); 

        // Zmniejszenie obrazu 
        Image scaledImg = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH); 

        // przeskalowanym obrazem
        Icon customIcon = new ImageIcon(scaledImg);
        
        return JOptionPane.showOptionDialog(
            null, 
            text, 
            "", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            customIcon, 
            options, 
            options[0]
        );
    }

   
    public Question makeQuestion(String txt, Object[] opt) {
        int i = showDialog(txt, opt); 
        String chosenOne = (String) opt[i]; 
        return new Question(txt, chosenOne); 
    }

    // Wyœwietlanie odpowiedzi
    public void makeAnswer(String text) {
        JOptionPane.showMessageDialog(null, text); 
        System.out.println(text); 
    }
}
