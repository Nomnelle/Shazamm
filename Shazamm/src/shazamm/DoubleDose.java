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
    
    public DoubleDose(){
        super();
        this.numero = 8;
        this.name = "Double Dose";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
        System.out.printf("L'attaque de %s est doublée !", j1.getNom());
        j1.setMise(j1.getMise()*2);
    }
    
}
