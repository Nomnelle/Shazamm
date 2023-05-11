/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Resistance extends Carte{
    
    public Resistance(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Résistance";
        this.image = "/cartes/11r.jpg";
        this.description = "Si le mur de feu devait avancer vers moi, il ne bouge pas.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //empêche le feu de se déplacer
       if(t.getSort()){
           t.setNbCaseDeplacement(0);
       }
    }
    
}
