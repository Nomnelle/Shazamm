/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Mutisme extends Carte{
    
    public Mutisme(){
        super();
        this.numero = 1;
        this.name = "Mutisme";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           System.out.println("Tous les joueurs souffrent de mutisme! Plus personne ne peut lancer de sort.");
           t.setSort();
       }
    }
    
}
