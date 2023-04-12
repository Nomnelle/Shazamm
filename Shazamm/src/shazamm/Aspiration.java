/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Aspiration extends Carte{
    
    public Aspiration(){
        super();
        this.numero = 14;
        this.name = "Aspiration";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           System.out.printf("%s vole la mise de %s...;\n", j1.getNom(), j2.getNom());
           j1.setMana(j1.getMana()+j2.getMise());
       }
    }
    
}
