/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nomnelle
 */
public class Clone extends Carte{
    
    public Clone(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Clone";
        this.image = "/cartes/02r.jpg";
        this.description = "Je pose devant moi une des cartes jouées par l’adversaire au tour précédent.\nCette carte est appliquée à ce tour, comme si je l’avais jouée normalement.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //permet au joueur de lancer un des sorts que son adversaire a joué au tour précédent 
        if(t.getSort()){  //si le joueur peut lancer un sort 
            boolean tour = true; 
            if(j2.getSortPrecedent().isEmpty()){  //cas où son adversaire n'a pas lancé de sort 
                System.out.println("Votre adversaire n'avait pas placé de sort au tour précédent.");
            }else{
                System.out.println("Vous pouvez choisir parmis les sorts suivants :");
                for (int num : j2.getSortPrecedent()) {
                    System.out.printf("%d. %s\n", num, j2.getInDeck(num).getName());  //énumération des sorts dispos 
                }
                System.out.println("Lequel choisissez vous ?");
                while(tour){  //tant que le joueur fait sa sélection 
                    tour = this.selectionSort(j1, j2);
                }
            }
        }
    }
    
    public boolean selectionSort(Sorcier j1, Sorcier j2){
        Scanner sc = new Scanner(System.in);
        int answer;
        boolean tour;
        try{  //gestion de l'exception si le joueur entre autre chose q'un int 
            answer = sc.nextInt();
            if(j2.getSortPrecedent().contains(answer)){  //si le joueur adverse a bien joué le sort demandé 
                ArrayList<Integer> tmp = new ArrayList<>();  //on le rajoute à la liste des sorts du joueur 
                tmp.add(answer);
                j1.setSortActuel(tmp);
                System.out.printf("Vous avez choisi le sort %s.", j2.getInDeck(answer).getName());
                tour = false;  //fin du tour
            }else{  //sinon
                System.out.println("Votre adversaire n'avait pas joué ce sort.");
                tour = true; //la sélection recommence 
            }
        }catch(java.util.InputMismatchException e){  //si le joueur n'a pas rentré un int
            System.out.println("Entrée non valide.");
            tour = true;  //la sélection recommence 
        }
        return tour;       
    }
    
}
