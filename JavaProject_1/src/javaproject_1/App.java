/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject_1;



import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Diego A. Vivolo / Gabriel Orozco
 */
 */



public class App {
    private File dataFile;
    public static App instance;
    
    
    
    
    public App() {
        initComponents();
    }
    
    public Grafo getGrafo(){
        return grafo;
    }
    
    public Grafo setGrafo(Grafo grafo){
        this.grafo = grafo; 
        return null;
    }
    
    public File getDataFile() {
        return dataFile;
    }

    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
        
    }  

    
  
    


    
    public static void main(String args[]) {
        new Ventana1().setVisible(true);

    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
       
    
 
    
    
    
    
    
    
