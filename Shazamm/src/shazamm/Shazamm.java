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
        Terrain t = new Terrain();  //création du terrain
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur 1, quel est votre nom ?");
        String name = sc.nextLine();
        Sorcier j1 = new Sorcier(name, "rouge", t.getPositionFeu()-3);  //Création du j1
        System.out.println("Joueur 2, quel est votre nom ?");
        name = sc.nextLine();
        Sorcier j2 = new Sorcier(name, "vert", t.getPositionFeu()+3);  //création du j2
        while(game){
            
            j1.miser();  //les joueurs misent
            j2.miser();
            
            if(t.getSort()){  //s'ils le peuvent, ils décident des sorts qu'ils lancent 
                j1.lancerSort();
                j2.lancerSort();
            }
            
            if(j1.getSortActuel().contains(0)){  //appel des sort par ordre de priorité : Mutisme
                j1.getInDeck(0).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(0)){
                j2.getInDeck(0).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(1)){  //Clone 
                j1.getInDeck(1).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(1)){
                j2.getInDeck(1).effet(t, j2, j1);
            }
            
            if((j1.getSortActuel().contains(2))&&(j2.getSortActuel().contains(2))){  //choix du comportement du sort larcin si les deux joueurs le lancent : rien ne se passe
                System.out.println("Les deux joueurs tentent de voler l'adversaire en même temps... Pas très discret ! Rien ne change.");
            }else if(j1.getSortActuel().contains(2)){
                j1.getInDeck(2).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(2)){
                j2.getInDeck(2).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(3)){  //Fin de manche 
                j1.getInDeck(3).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(3)){  
                j2.getInDeck(3).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(4)){  //Milieu
                j1.getInDeck(4).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(4)){
                j2.getInDeck(4).effet(t, j2, j1);
            }

            if(j1.getSortActuel().contains(5)){  //Recyclage 
                j1.getInDeck(5).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(5)){
                j2.getInDeck(5).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(6)){  //Boost
                j1.getInDeck(6).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(6)){
                j2.getInDeck(6).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(7)){  //Double Dose
                j1.getInDeck(7).effet(t, j1, j2);
            }
            if(j2.getSortActuel().contains(7)){
                j2.getInDeck(7).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(8)){  //Qui perd gagne 
                j1.getInDeck(8).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(5)){
                j2.getInDeck(8).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(9)){  //Brasier 
                j1.getInDeck(9).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(9)){
                j2.getInDeck(9).effet(t, j2, j1);
            }
            
            if(j1.getMise()<j2.getMise()){  //Si le joueur 2 gagne le tour 
                if(j1.getSortActuel().contains(10)){  //Si le joueur 1 a Resistance 
                    j1.getInDeck(10).effet(t, j1, j2);
                }
                if(j1.getSortActuel().contains(11)){  //Si le joueur 1 a Harpagon 
                    j1.getInDeck(11).effet(t, j1, j2);
                }
                if(j1.getSortActuel().contains(8)||j2.getSortActuel().contains(8)){ //message alternatif si Qui Perd Gagne a été activé 
                    System.out.println("Le feu avance vers le gagnant...");
                    t.setPositionFeu(t.getPositionFeu()-t.getNbCaseDeplacement());
                }else{  //Cas de base 
                    System.out.println("Le feu avance vers le joueur 1.");
                    t.setPositionFeu(t.getPositionFeu()-t.getNbCaseDeplacement());
                }
            }else if(j1.getMise()>j2.getMise()){  //si le joueur 1 gagne le tour 
                if(j2.getSortActuel().contains(10)){  //si le joueur 2 a Resistance 
                    j2.getInDeck(10).effet(t, j2, j1);
                }
                if(j2.getSortActuel().contains(11)){  //Si le joueur 2 a Harpagon 
                    j2.getInDeck(11).effet(t, j2, j1);
                }
                if(j1.getSortActuel().contains(8)||j2.getSortActuel().contains(8)){  //Message alternatif si Qui Perd Gagne a été joué 
                    System.out.println("Le feu avance vers le gagnant...");
                    t.setPositionFeu(t.getPositionFeu()-t.getNbCaseDeplacement());
                }else{  //Cas de base 
                    System.out.println("Le feu avance vers le joueur 2.");
                    t.setPositionFeu(t.getPositionFeu()+t.getNbCaseDeplacement());
                } 
            }else{  //Les joueurs ont joué la même mise 
                System.out.println("Le feu reste sur sa position.");
            }
            
            if(t.getNbCaseDeplacement()!=1){  //Si le nombre de case de déplacement du feu a été modifié, il est réinitialisé 
                    t.setNbCaseDeplacement(1);
            }
            
            if(j1.getSortActuel().contains(7)){  //Si Double Dose a été joué par le j1, on enlève son effet à la mise de base 
                j1.setMise(j1.getMise()/2);
            }
            if(j1.getSortActuel().contains(6)){ //Même chose mais si Boost a été joué 
                j1.setMise(j1.getMise()-7);
            }
            
            if(j2.getSortActuel().contains(7)){  //Même principe, mais si le j2 a joué Double dose 
                j2.setMise(j2.getMise()/2);
            }
            if(j2.getSortActuel().contains(6)){  //et si le j2 a joué Boost
                j2.setMise(j2.getMise()-7);
            }
            
            j1.setMana(j1.getMana()- j1.getMise());  //On retire la mise de la réserve 
            j2.setMana(j2.getMana()- j2.getMise());
            
            
            if(j1.getSortActuel().contains(12)){  //Réserve 
                j1.getInDeck(12).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(12)){
                j2.getInDeck(12).effet(t, j2, j1);
            }
            
            if(j1.getSortActuel().contains(13)){  //Aspiration 
                j1.getInDeck(13).effet(t, j1, j2);
            }else if(j2.getSortActuel().contains(13)){
                j2.getInDeck(13).effet(t, j2, j1);
            }
            
            if((t.getPositionFeu()<=j1.getPosition())||(j1.getMana()==0)){  //Si le feu est arrivé au j1 ou au délà, ou alors qu'il n'a plus de mana : fin de manche
                System.out.println("Le joueur 1 se fait engloutir par les flammes...");
                if(j1.getMana()==0){  //Si le j1 a plus de mana, le feu se met sur sa position 
                    t.setPositionFeu(j1.getPosition());
                }
                j1.setPosition(t.getPositionFeu()-3);  //on repositionne les joueurs 
                j2.setPosition(t.getPositionFeu()+3);
                
                j1.setMana(50);  //on réinitialise les réserves de mana 
                j2.setMana(50);
                
                t.ecrouler();  //le pont s'écroule 
                
                if(!(t.getSort())){  //les joueurs peuvent de nouveau lancer des sorts s'ils ne pouvaient plus 
                    t.setSort();
                }
                
                for(int i = 0;i<3;i++){  //ils piochent trois cartes de sorts 
                    j1.piocher();
                    j2.piocher();
                }
                
            }else if((t.getPositionFeu()>=j2.getPosition())||(j2.getMana()==0)){  //fin de manche si le feu arrive sur le joueur 2 ou s'il n'a plus de mana 
                System.out.println("Le joueur 2 se fait engloutir par les flammes...");  //même principe que le code ci-dessus
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
                
                for(int i = 0;i<3;i++){
                    j1.piocher();
                    j2.piocher();
                }
            }
            
            if(!(t.getTabPontCase(j1.getPosition()))){  //si le joueur 1 n'est plus sur le pont 
                System.out.println("Le joueur 1 tombe du pont... Le joueur 2 a gagné !");
                game = false;
            }else if(!(t.getTabPontCase(j2.getPosition()))){  //si le joueur 2 n'est plus sur le pont 
                System.out.println("Le joueur 2 tombe du pont... Le joueur 1 a gagné !");
                game = false;
            }
            
        }
        
    }
    
}
