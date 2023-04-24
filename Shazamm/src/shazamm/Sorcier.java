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
    private Carte[] deck; //sorts disponibles 
    private ArrayList<Integer> main; //index dans le decks correspondant aux sorts pouvant être lancés par le joueur
    private ArrayList<Integer> sortActuel; //sorts lancés par le joueur durant le tour en cours
    private ArrayList<Integer> sortPrecedent; //sorts lancés par le joueur durant le tour précédent 
    private final String couleur; //couleur du sorcier in-game 
    private int position; //position du sorcier sur le pont in-game 
    private int mana; //nombre de points de mana disponibles 
    private int mise; //nombre de points de mana misés à ce tour 

    public Sorcier(String n, String c, int p){ //constructeur : prend en paramètre un nom, une couleur, et la position du sorcier au début de la game 
        
        this.nom = n;
        this.couleur = c;
        this.position = p;
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
    
    public String getCouleur(){ //getter
        return this.couleur;
    }
    
    public int getMana(){ //getter
        return this.mana;
    }
    
    public int getPosition(){ //getter
        return this.position;
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
    
    @Override
    public String toString(){  //toString 
        return "Abracadabra";
    }
    
    public void miser(){  //permet au joueur de miser des points de mana 
        boolean tour = true; 
        while(tour){  //tant que la mise n'est pas correcte, on redemande au joueur 
            this.selectionMise();
            if(this.mise>0){
                tour = false;
            }
        }
    }
    
    public void piocher(){  //permet au joueur de piocher une carte sort 
        Random rd = new Random();
        boolean correct = false;
        int pioche;
        
        while(!(correct)){  //tant que la carte piochée n'est pas correcte, on génère un nouveau random
            pioche = rd.nextInt(14);
            if(this.main.size()<15){  //s'il y a pas déjà tous les sorts dans la main
                if(!(main.contains(pioche))){  //on vérifie que le sort n'est pas déjà dans la pioche
                    main.add(pioche);  //on rajoute le sort dans la main 
                    correct = true;
                }
            }else{  //sinon on prévient le joueur, et on ne fait rien de plus
                System.out.println("Vous avez déjà tous les sorts disponibles dans votre main.");
                correct = true; 
            }
        }
    }
    
    private void initMain(){  //fonction qui initialise la main du joueur
        this.main = new ArrayList<>();  //initialisation
        for(int i=0;i<5;i++){  //on pioche 5 sorts 
           this.piocher();
        }
    }
    
    public void lancerSort(){  //fonction qui permet au joueur de lancer des sorts 
        boolean tour = true;
        Scanner sc = new Scanner(System.in);
        String answer;
        this.sortPrecedent = new ArrayList(this.sortActuel);  //on met dans l'ArrayList contenant les sorts du tour précédent l'ArrayList des sorts actuels 
        this.sortActuel.clear();  //On vide l'ArrayList des sorts actuels 
        while(tour){  //Tant que le joueur n'a pas fini sa sélection 
            if(this.main.isEmpty()){  //Si le joueur n'a pas de sort à lancer, on le prévient 
                System.out.println("Vous n'avez plus de sort à jouer.");
                tour = false;
            }else{
                System.out.println("Vous disposez des sorts suivants :");
                for (int num : this.main) {
                    System.out.printf("%d. %s\n", num, this.deck[num].getName()); //énumération des sorts disponibles 
                }
                System.out.println("Souhaitez vous lancer un sort ? y/n");  //demande au joueur s'il souhaite lancer un sort 
                answer = sc.nextLine();
                if(answer.equalsIgnoreCase("y")){  //si le joueur entre "Y" ou "y", on demande au joueur de sélectionner quel sort il souhaite lancer 
                    this.selectionSort();
                }else{  //si le joueur entre quoi que ce soit d'autre, fin de la phase psychique 
                    System.out.println("Fin de votre phase pour lancer les sorts.");  
                    tour = false;
                }   
            }
        }         
    }

    private void selectionMise(){  //fonction gérant la selection du nombre de point de mana que le joueur va miser 
        Scanner sc = new Scanner(System.in);
        try{  //pour éviter les erreurs si le joueur entre autre chose qu'un int 
            System.out.printf("%s, combien de points de mana souhaitez vous miser ?\n", this.nom);
            this.mise = sc.nextInt();
                if(mise<1){  //si mise inférieure à la mise minimale, mise refusée 
                    System.out.println("Mise trop faible, veuillez rentrer un nombre plus important.");
                    this.mise = -1;
                }else if(this.mise>this.mana){  //si mise supérieure au nombre de points de mana disponibles, mise refusée 
                    System.out.println("Vous n'avez pas assez de mana, veuillez entrer une mise inférieure.");
                    this.mise = -1;
                }else{  //sinon mise acceptée 
                    System.out.printf("Vous avez misé %d points de mana.\n", mise);
                }
        }catch(java.util.InputMismatchException e){  //si entrée du joueur incorrecte, mise refusée 
            System.out.println("Veuillez entrer un nombre entier strictement positif.");
            this.mise = -1;
        }       
}
    
    private void selectionSort(){  //fonction permettant au joueur de choisir quel sort il veut lancer 
        int sort;
        int index;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Saisissez le numéro du sort que vous voulez lancer.");
        
        try{  //permet d'éviter le crash si le joueur rentre autre chose qu'un int 
            sort = sc.nextInt();
            if(main.contains(sort)){  //si le joueur possède bien le sort
                this.sortActuel.add(sort);  //on le rajoute dans l'ArrayList modélisant les sorts lancés à ce tour
                index = main.indexOf(sort);
                main.remove(index);  //On l'enlève de la main du joueur 
                System.out.printf("Vous avez choisi le sort %s.", this.deck[sort].getName());  
            }else{  //sinon on prévient le joueur 
                System.out.println("Vous n'avez pas ce sort dans votre main.");
            }
        }catch(java.util.InputMismatchException e){  //si type de l'entrée invalide, on prévient le joueur 
            System.out.println("Entrée non valide.");
        }
    }
    
}
