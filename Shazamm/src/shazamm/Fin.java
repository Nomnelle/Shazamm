/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Fin extends Carte{
    
    public Fin(){  //constructeur 
        this.name = "Fin de la manche!";
        this.image = "/cartes/04r.jpg";
        this.description = "La manche est finie ! Les sorciers se replacent à 3 pas du mur de feu (dans sa position actuelle),\net on commence une nouvelle manche.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //met fin à la manche
       if(t.getSort()){
           j1.setMise(0);  //les joueurs ne misent rien, donc le feu n'avancera pas et rien de sera soustrait à leur réserve
           j2.setMise(0);
           if(j1.getPosition()<t.getPositionFeu()){  //si c'est le joueur 1 qui joue le sort 
                j1.setPosition(t.getPositionFeu()-3);
                j2.setPosition(t.getPositionFeu()+3);
           }else{  //si c'est le joueur 2 qui joue le sort 
               j1.setPosition(t.getPositionFeu()+3);
               j2.setPosition(t.getPositionFeu()-3);
           }
           
           j1.setMana(50);  //réserve de mana réinitialisée 
           j2.setMana(50);  
           
           for(int i = 0;i<3;i++){  //les joueurs piochent 3 cartes de sort chacun 
                j1.piocher();
                j2.piocher();
            }
           
           t.ecrouler();
       }
    }
}
