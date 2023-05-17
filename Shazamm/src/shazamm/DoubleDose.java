/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class DoubleDose extends Carte{
    
    public DoubleDose(){  //constructeur 
        this.name = "Double Dose";
        this.image = "/cartes/08r.jpg";
        this.description = "La puissance de mon attaque est multipliée par deux.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //double la mise du joueur 
        if(t.getSort()){
            j1.setMise(j1.getMise()*2);
        }
    }
    
}
