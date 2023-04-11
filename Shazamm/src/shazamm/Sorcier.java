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
    private ArrayList<Integer> main;
    private ArrayList<Integer> sortActuel;
    private ArrayList<Integer> sortPrecedent;
    private final String couleur;
    private int position;
    private int mana;
    private int mise;

    public Sorcier(String n, String c, int p){
        
        this.nom = n;
        this.couleur = c;
        this.position = p;
        this.mana = 50;
        this.deck = new Carte[14];
        this.mise = 1;
        
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
        
        this.sortActuel = new ArrayList<>();
        this.sortPrecedent = new ArrayList<>();
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
    
    public int getMise(){
        return this.mise;
    }
    
    public Carte getInDeck(int i){
        if(i<0){
            return this.deck[0];
        }else if(i>14){
            return this.deck[13];
        }else{
            return this.deck[i];
        }
    }
    
    public ArrayList<Integer> getSortActuel(){
        return this.sortActuel;
    }
    
    public ArrayList<Integer> getSortPrecedent(){
        return this.sortPrecedent;
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
    
    public void setMise(int i){
       this.mise = i;
    }
    
    public void setSortActuel(ArrayList<Integer> s){
        this.sortActuel.addAll(s);
    }
    
    public void replaceSortActuel(ArrayList<Integer> s){
        this.sortActuel = new ArrayList(s);
    }
    
    @Override
    public String toString(){
        return "Abracadabra";
    }
    
    public void miser(){
        boolean tour = true; 
        while(tour){
            this.selectionMise();
            if(this.mise>0){
                tour = false;
            }
        }
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
        this.main = new ArrayList<>();
        for(int i=0;i<5;i++){
           this.piocher();
        }
    }
    
    public void lancerSort(){
        boolean tour = true;
        Scanner sc = new Scanner(System.in);
        String answer;
        this.sortPrecedent = new ArrayList(this.sortActuel);
        this.sortActuel.clear();
        System.out.println(this.sortPrecedent);
        while(tour){
            if(this.main.isEmpty()){
                System.out.println("Vous n'avez plus de sort à jouer.");
                tour = false;
            }else{
                System.out.println("Vous disposez des sorts suivants :");
                for (int num : this.main) {
                    System.out.printf("%d. %s\n", num, this.deck[num].getName());
                }
                System.out.println("Souhaitez vous lancer un sort ? y/n");
                answer = sc.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    this.selectionSort();
                }else{
                    System.out.println("Fin de votre phase pour lancer les sorts.");
                    tour = false;
                }   
            }
        }         
    }

    private void selectionMise(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.printf("%s, combien de points de mana souhaitez vous miser ?\n", this.nom);
            this.mise = sc.nextInt();
                if(mise<1){
                    System.out.println("Mise trop faible, veuillez rentrer un nombre plus important.");
                    this.mise = -1;
                }else if(this.mise>this.mana){
                    System.out.println("Vous n'avez pas assez de mana, veuillez entrer une mise inférieure.");
                    this.mise = -1;
                }else{
                    System.out.printf("Vous avez misé %d points de mana.\n", mise);
                }
        }catch(java.util.InputMismatchException e){
            System.out.println("Veuillez entrer un nombre entier strictement positif.");
            this.mise = -1;
        }       
}
    
    private void selectionSort(){
        int sort;
        int index;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Saisissez le numéro du sort que vous voulez lancer.");
        
        try{
            sort = sc.nextInt();
            if(main.contains(sort)){
                this.sortActuel.add(sort);
                index = main.indexOf(sort);
                main.remove(index);
                System.out.printf("Vous avez choisi le sort %s.", this.deck[sort].getName());
            }else{
                System.out.println("Vous n'avez pas ce sort dans votre main.");
            }
        }catch(java.util.InputMismatchException e){
            System.out.println("Entrée non valide.");
        }
    }
    
}
