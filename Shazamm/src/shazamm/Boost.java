/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Boost extends Carte{
    
    public Boost(){  //constructeur 
        this.name = "Boost";
        this.image = "/cartes/07r.jpg";
        this.description = "La puissance de mon attaque est augmentée de 7.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //augmente l'attaque de 7 points 
        if(t.getSort()){  //si le joueur peut lancer le sort, il augmente sa mise de 7 points 
            j1.setMise(j1.getMise()+7);
        }
    }
}
