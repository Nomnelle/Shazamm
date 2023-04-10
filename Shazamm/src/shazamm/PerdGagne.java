/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class PerdGagne extends Carte{
    
    public PerdGagne(){
        super();
        this.numero = 9;
        this.name = "Qui perd gagne";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           this.active = true;
           t.setPositionFeu(-t.getPositionFeu());
       }
    }
    
}
