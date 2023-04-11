/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Reserve extends Carte{
    
    public Reserve(){
        super();
        this.numero = 13;
        this.name = "Boost réserve";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           System.out.println("Un sort regarni la réserve de mana.");
           j1.setMise(j1.getMise()+13);
       }
    }
    
}
