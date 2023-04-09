/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.Scanner;

/**
 *
 * @author nomnelle
 */
public class Sorcier {
    
    private String nom;
    private String[] deck;
    private String couleur;
    private int position;
    private int mana;

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
    
    public void setPosition(int i){
        if(i<0){
            this.position = 0;
        }else if(i>18){
            this.position = 18;
        }else{
            this.position = i;
        }
    }
    
    public void setMana(int i){
        this.mana = i;
    }
    
    @Override
    public String toString(){
        return "Abracadabra";
    }
    
    public int miser(){
        Scanner sc = new Scanner(System.in);
        boolean correcte = false;
        int mise = 0;
        while(!(correcte)){
            try{
                System.out.printf("%s, combien de points de mana souhaitez vous miser ?\n", this.nom);
                mise = sc.nextInt();
                if(mise<0){
                    System.out.println("Veuillez rentrer un nombre positif.");
                }else if(mise>this.mana){
                    System.out.println("Vous n'avez pas assez de mana, veuillez rentrer une mise inférieure.");
                }else{
                    System.out.printf("Vous avez misé %d points de mana\n", mise);
                    correcte = true;
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Veuillez rentrer un nombre entier.");
            }
        }
        return mise;
    }
    
}
