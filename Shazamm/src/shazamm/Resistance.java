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
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //empêche le feu de se déplacer
       if(t.getSort()){
           System.out.println("Un sort empêche le feu de bouger.");
           t.setNbCaseDeplacement(0);
       }
    }
    
}
