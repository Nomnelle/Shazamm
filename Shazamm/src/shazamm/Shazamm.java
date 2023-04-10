/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shazamm;

import java.util.ArrayList;
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
        Sorcier j2 = new Sorcier(name, "bleu", t.getPositionFeu()+3);
        while(game){
            int miseJ1 = j1.miser();
            int miseJ2 = j2.miser();
            
            ArrayList<Integer> sortTActJ1 = j1.lancerSort();
            ArrayList<Integer> sortTActJ2 = j2.lancerSort();
            
            if(miseJ1<miseJ2){
                System.out.println("Le feu avance vers le joueur 1.");
                t.setPositionFeu(t.getPositionFeu()-1);
            }else if(miseJ1>miseJ2){
                System.out.println("Le feu avance vers le joueur 2.");
                t.setPositionFeu(t.getPositionFeu()+1);
            }else{
                System.out.println("Le feu reste sur sa position.");
            }
            
            j1.setMana(j1.getMana()- miseJ1);
            j2.setMana(j2.getMana()- miseJ2);
            
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
