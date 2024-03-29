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
    
    private final String nom; //nom du joueur
    private final Carte[] deck; //sorts disponibles 
    private ArrayList<Integer> main; //index dans le decks correspondant aux sorts pouvant être lancés par le joueur
    private ArrayList<Integer> sortActuel; //sorts lancés par le joueur durant le tour en cours
    private ArrayList<Integer> sortPrecedent; //sorts lancés par le joueur durant le tour précédent 
    private int position; //position du sorcier sur le pont in-game 
    private final String couleur;  //couleur du sorcier incarné par le joueur
    private int mana; //nombre de points de mana disponibles 
    private int mise; //nombre de points de mana misés à ce tour 

    public Sorcier(String n, int p, String c){ //constructeur : prend en paramètre un nom, et la position du sorcier au début de la game 
        
        this.nom = n;
        this.position = p;
        this.couleur = c;
        this.mana = 50;  //nombre initial de points de mana 
        this.deck = new Carte[14];  //initialisation du tableau représentant les sorts dispos
        this.mise = 1;  //initialisation de la mise à sa valeur la plus basse 
        
        this.deck[0] = new Mutisme(); //On rajoute chacune des classes modélisant les différents sorts dans le deck
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
        
        this.initMain();  //initialise la main avec 5 sorts différents 
        
        this.sortActuel = new ArrayList<>(); //initialisation 
        this.sortPrecedent = new ArrayList<>(); //initialisation 
        }
    
    public String getNom(){ //getter
        return this.nom;
    }
    
    public int getMana(){ //getter
        return this.mana;
    }
    
    public int getPosition(){ //getter
        return this.position;
    }
    
    public String getCouleur() {
        return this.couleur;
    }
    
    public int getMise(){ //getter
        return this.mise;
    }
    
    public Carte getInDeck(int i){ //getter : permet d'obtenir le ième sort dans le deck 
        if(i<0){  //vérifie que l'on demande pas un index négatif 
            return this.deck[0];  //si c'est le cas, on renvoie le premier sort du deck 
        }else if(i>14){  //vérifie que l'on demande pas un index hors des bornes du tableau 
            return this.deck[13];  //si c'est le cas, on renvoit le dernier sort du deck
        }else{
            return this.deck[i];
        }
    }
    
    public int getInDeck(String s){
        int result = -1;
        for(int i = 0; i<deck.length;i++){
            if(s.equals(deck[i].name)){
                result = i;
            }
        }
        return result;
    }
    
    public ArrayList<Integer> getMain(){  //getter
        return this.main;
    }
    
    public ArrayList<Integer> getSortActuel(){  //getter
        return this.sortActuel;
    }
    
    public ArrayList<Integer> getSortPrecedent(){  //getter
        return this.sortPrecedent;
    }
    
    public void setPosition(int i){  //setter 
        if(i<0){  //vérifie que le joueur 1 ne sort pas du pont 
            this.position = 0;  //si oui, il est placé à l'extrémité du point
        }else if(i>18){  //vérifie que le joueur 2 ne sort pas du pont 
            this.position = 18;  //si oui, il est placé à l'extrémité du pont 
        }else{
            this.position = i;
        }
    }
    
    public void setMana(int i){  //setter
        this.mana = i;
    }
    
    public void setMise(int i){  //setter
       this.mise = i;
    }
    
    public void setSortActuel(ArrayList<Integer> s){  //setter : permet d'ajouter l'ArrayList s à celui modélisant les sorts actuels 
        this.sortActuel.addAll(s);
    }
    
    public void replaceSortActuel(ArrayList<Integer> s){  //setter : remplace le contenu de l'ArrayList des sorts actuels par celui de s 
        this.sortActuel = new ArrayList(s);
    }
    
    public void removeHand(int i){
        boolean exists = this.main.contains(i);
        if(exists){
            int index = this.main.indexOf(i);
            this.main.remove(index);
        }
        
    }
    
    @Override
    public String toString(){  //toString 
        return "Abracadabra";
    }
    
    public void piocher(){  //permet au joueur de piocher une carte sort 
        Random rd = new Random();
        boolean correct = false;
        int pioche;
        
        if(this.main.size()<this.deck.length){ //s'il y a pas déjà tous les sorts dans la main
            while(!(correct)){  //tant que la carte piochée n'est pas correcte, on génère un nouveau random
                pioche = rd.nextInt(this.deck.length);
                 
                    if(!(main.contains(pioche))){  //on vérifie que le sort n'est pas déjà dans la pioche
                        main.add(pioche);  //on rajoute le sort dans la main 
                        correct = true;
                    }
            }
        }else{  //sinon on prévient le joueur, et on ne fait rien de plus
                System.out.println("Vous avez déjà tous les sorts disponibles dans votre main.");
        }
    }
    
    private void initMain(){  //fonction qui initialise la main du joueur
        this.main = new ArrayList<>();  //initialisation
        for(int i=0;i<5;i++){  //on pioche 5 sorts 
           this.piocher();
        }
    }
    
    public void lancerSort(){  //fonction qui permet au joueur de lancer des sorts 
        this.sortPrecedent = new ArrayList(this.sortActuel);  //on met dans l'ArrayList contenant les sorts du tour précédent l'ArrayList des sorts actuels 
        this.sortActuel.clear();  //On vide l'ArrayList des sorts actuels       
    }

}
