/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shazamm;

import java.util.Scanner;

/**
 *
 * @author nomnelle
 */
public class Shazamm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean game = true;
        Terrain t = new Terrain();
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur 1, quel est votre nom ?");
        String name = sc.nextLine();
        Sorcier j1 = new Sorcier(name, "rouge", t.getPositionFeu()-3);
        System.out.println("Joueur 2, quel est votre nom ?");
        name = sc.nextLine();
        Sorcier j2 = new Sorcier(name, "vert", t.getPositionFeu()+3);
        while(game){
            
            j1.miser();
            j2.miser();
            
            if(t.getSort()){
                j1.lancerSort();
                j2.lancerSort();
            }
            
            if(j1.getSortActuel().contains(0)){
                j1.getInDeck(0).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(0)){
                j2.getInDeck(0).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(1)){
                j1.getInDeck(1).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(1)){
                j2.getInDeck(1).effet(t, j2, j1);
            }
            
            if((j1.getSortActuel().contains(2))&&(j2.getSortActuel().contains(2))){
                System.out.println("Les deux joueurs tentent de voler l'adversaire en même temps... Pas très discret ! Rien ne change.");
            }else if(j1.getSortActuel().contains(2)){
                j1.getInDeck(2).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(2)){
                j2.getInDeck(2).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(3)){
                j1.getInDeck(3).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(3)){
                j2.getInDeck(3).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(4)){
                j1.getInDeck(4).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(4)){
                j2.getInDeck(4).effet(t, j2, j1);
            }

            if(j1.getSortActuel().contains(5)){
                j1.getInDeck(5).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(5)){
                j2.getInDeck(5).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(6)){
                j1.getInDeck(6).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(6)){
                j2.getInDeck(6).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(7)){
                j1.getInDeck(7).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(7)){
                j2.getInDeck(7).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(8)){
                j1.getInDeck(8).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(5)){
                j2.getInDeck(8).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(9)){
                j1.getInDeck(9).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(9)){
                j2.getInDeck(9).effet(t, j2, j1);
            }
            
            if(j1.getMise()<j2.getMise()){
                if(j1.getSortActuel().contains(10)){
                    j1.getInDeck(10).effet(t, j1, j2);
                }
                if(j1.getSortActuel().contains(11)){
                    j1.getInDeck(11).effet(t, j1, j2);
                }
                if(j1.getSortActuel().contains(8)||j2.getSortActuel().contains(8)){
                    System.out.println("Le feu avance vers le gagnant...");
                    t.setPositionFeu(t.getPositionFeu()-t.getNbCaseDeplacement());
                }else{
                    System.out.println("Le feu avance vers le joueur 1.");
                    t.setPositionFeu(t.getPositionFeu()-t.getNbCaseDeplacement());
                }
            }else if(j1.getMise()>j2.getMise()){
                if(j2.getSortActuel().contains(10)){
                    j2.getInDeck(10).effet(t, j2, j1);
                }
                if(j2.getSortActuel().contains(11)){
                    j2.getInDeck(11).effet(t, j2, j1);
                }
                if(j1.getSortActuel().contains(8)||j2.getSortActuel().contains(8)){
                    System.out.println("Le feu avance vers le gagnant...");
                    t.setPositionFeu(t.getPositionFeu()-t.getNbCaseDeplacement());
                }else{
                    System.out.println("Le feu avance vers le joueur 2.");
                    t.setPositionFeu(t.getPositionFeu()+t.getNbCaseDeplacement());
                }
            }else{
                System.out.println("Le feu reste sur sa position.");
            }
            
            if(t.getNbCaseDeplacement()!=1){
                    t.setNbCaseDeplacement(1);
            }
            
            if(j1.getSortActuel().contains(13)){
                j1.setMise(j1.getMise()/2);
            }
            if(j1.getSortActuel().contains(12)){
                j1.setMise(j1.getMise()-7);
            }
            
            if(j2.getSortActuel().contains(13)){
                j2.setMise(j2.getMise()/2);
            }
            if(j2.getSortActuel().contains(12)){
                j2.setMise(j2.getMise()-7);
            }
            
            j1.setMana(j1.getMana()- j1.getMise());
            j2.setMana(j2.getMana()- j2.getMise());
            
            if(j1.getSortActuel().contains(12)){
                j1.getInDeck(12).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(12)){
                j2.getInDeck(12).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(13)){
                j1.getInDeck(13).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(13)){
                j2.getInDeck(13).effet(t, j2, j1);
            }
            
            if((t.getPositionFeu()<=j1.getPosition())||(j1.getMana()==0)){
                System.out.println("Le joueur 1 se fait engloutir par les flammes...");
                if(j1.getMana()==0){
                    t.setPositionFeu(j1.getPosition());
                }
                j1.setPosition(t.getPositionFeu()-3);
                j2.setPosition(t.getPositionFeu()+3);
                
                j1.setMana(50);
                j2.setMana(50);
                
                t.ecrouler();
                
                if(!(t.getSort())){
                    t.setSort();
                }
                
            }else if((t.getPositionFeu()>=j2.getPosition())||(j2.getMana()==0)){
                System.out.println("Le joueur 2 se fait engloutir par les flammes...");
                if(j2.getMana()==0){
                    t.setPositionFeu(j2.getPosition());
                }
                j1.setPosition(t.getPositionFeu()-3);
                j2.setPosition(t.getPositionFeu()+3);
                
                j1.setMana(50);
                j2.setMana(50);
                
                t.ecrouler();
                
                if(!(t.getSort())){
                    t.setSort();
                }
            }
            
            if(!(t.getTabPontCase(j1.getPosition()))){
                System.out.println("Le joueur 1 tombe du pont... Le joueur 2 a gagné !");
                game = false;
            }else if(!(t.getTabPontCase(j2.getPosition()))){
                System.out.println("Le joueur 2 tombe du pont... Le joueur 1 a gagné !");
                game = false;
            }
            
        }
        
    }
    
}
