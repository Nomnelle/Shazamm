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
        this.name = "Boost réserve";
        this.image = "/cartes/13r.jpg";
        this.description = "Ma réserve de Mana s’augmente de 13 points.\nAprès que j’ai payé ce que je dois.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //augmente la réserve de mana de 13 points 
       if(t.getSort()){
           j1.setMana(j1.getMana()+13);
       }
    }
    
}
