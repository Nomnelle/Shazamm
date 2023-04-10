/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Larcin extends Carte{
    
    public Larcin(){
        super();
        this.numero = 3;
        this.name = "Larcin";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           this.active = true;
       }
    }
    
}
