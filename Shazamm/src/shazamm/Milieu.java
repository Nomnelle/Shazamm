/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Milieu extends Carte{
    
    public Milieu(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Milieu";
        this.image = "/cartes/05r.jpg";
        this.description = "Je replace immédiatement le mur de feu à égale distance des deux sorciers.\nLe tour continue ensuite normalement.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //le feu se replace entre les deux joueurs
       if(t.getSort()){  //si le joueur peut lancer un sort 
           System.out.println("Un sort fait que le feu se replace entre les deux joueurs.");
           if(j1.getPosition()<t.getPositionFeu()){  //si le joueur 1 lance le sort 
               t.setPositionFeu(j1.getPosition()+3);
           }else{  //si le joueur 2 lance le sort 
               t.setPositionFeu(j1.getPosition()-3);
           }
           
       }
    }
    
}
