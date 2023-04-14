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
    
    public Reserve(){  //constructeur 
        super();  //constructeur classe mère
        this.name = "Boost réserve";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //augmente la réserve de mana de 13 points 
       if(t.getSort()){
           System.out.println("Un sort regarni la réserve de mana.");
           j1.setMana(j1.getMana()+13);
       }
    }
    
}
