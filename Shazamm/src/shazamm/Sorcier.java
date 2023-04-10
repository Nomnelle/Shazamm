/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nomnelle
 */
public class Sorcier {
    
    private final String nom;
    private Carte[] deck;
    private ArrayList main;
    private final String couleur;
    private int position;
    private int mana;

    public Sorcier(String n, String c, int p){
        
        this.nom = n;
        this.couleur = c;
        this.position = p;
        this.mana = 50;
        this.deck = new Carte[14];
        
        this.deck[0] = new Mutisme();
        this.deck[1] = new Clone();
        this.deck[2] = new Larcin();
        this.deck[3] = new Fin();
        this.deck[4] = new Milieu();
        this.deck[5] = new Recyclage();
        this.deck[6] = new Boost();
        this.deck[7] = new DoubleDose();
        this.deck[8] = new PerdGagne();
        this.deck[9] = new Brasier();
        this.deck[10] = new Resistance();
        this.deck[11] = new Harpagon();
        this.deck[12] = new Reserve();
        this.deck[13] = new Aspiration();
        
        this.initMain();
        System.out.println(main.toString());
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
                if(mise<1){
                    System.out.println("Veuillez rentrer supérieur ou égal à 1.");
                }else if(mise>this.mana){
                    System.out.println("Vous n'avez pas assez de mana, veuillez rentrer une mise inférieure.");
                }else{
                    System.out.printf("Vous avez misé %d points de mana.\n", mise);
                    correcte = true;
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Veuillez rentrer un nombre entier.");
            }
        }
        return mise;
    }
    
    public void piocher(){
        Random rd = new Random();
        boolean correct = false;
        int pioche;
        
        while(!(correct)){
            pioche = rd.nextInt(14);
            if(!(main.contains(pioche))){
                main.add(pioche);
                correct = true;
            }
        }
    }
    
    private void initMain(){
        this.main = new ArrayList<Integer>();
        for(int i=0;i<5;i++){
           this.piocher();
        }
    }
    
}
