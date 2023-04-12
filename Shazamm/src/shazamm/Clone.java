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
    
    public Clone(){
        super();
        this.numero = 2;
        this.name = "Clone";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
        if(t.getSort()){
            boolean tour = true; 
            if(j2.getSortPrecedent().isEmpty()){
                System.out.println("Votre adversaire n'avait pas placé de sort au tour précédent.");
            }else{
                System.out.println("Vous pouvez choisir parmis les sorts suivants :");
                for (int num : j2.getSortPrecedent()) {
                    System.out.printf("%d. %s\n", num, j2.getInDeck(num).getName());
                }
                System.out.println("Lequel choisissez vous ?");
                while(tour){
                    tour = this.selectionSort(j1, j2);

                }
            }
        }
    }
    
    public boolean selectionSort(Sorcier j1, Sorcier j2){
        Scanner sc = new Scanner(System.in);
        int answer;
        boolean tour;
        try{
            answer = sc.nextInt();
            if(j2.getSortPrecedent().contains(answer)){
                ArrayList<Integer> tmp = j1.getSortActuel();
                tmp.add(answer);
                j1.setSortActuel(tmp);
                System.out.printf("Vous avez choisi le sort %s.", j2.getInDeck(answer).getName());
                tour = false;
            }else{
                System.out.println("Votre adversaire n'avait pas joué ce sort.");
                tour = true; 
            }
        }catch(java.util.InputMismatchException e){
            System.out.println("Entrée non valide.");
            tour = true;
        }
        return tour;       
    }
    
}
