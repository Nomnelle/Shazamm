/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Sorcier {
    
    String nom;
    Carte[] deck;
    String couleur;
    int position;
    int mana;

    public Sorcier(String n, String c, int p){
        
        this.nom = n;
        this.couleur = c;
        this.position = p;
        this.mana = 50;
        
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getCouleur(){
        return this.couleur;
        
    }
    
    public int getMana(){
        return this.mana;
    }
    
    public int getPosition(){
        return this.position;
    }

    public void setNom(String s){
        this.nom = s;
    }
    
    public void setPosition(int i){
        this.position = i;
    }
    
    public void setMana(int i){
        this.mana = i;
    }
    
    @Override
    public String toString(){
        return "Abracadabra";
    }
    
}
