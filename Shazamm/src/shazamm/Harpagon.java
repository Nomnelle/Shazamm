/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Harpagon extends Carte{
    
    public Harpagon(){
        super();
        this.numero = 12;
        this.name = "Harpagon";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           System.out.println("Un sort fait que le perdant garde sa mise.");
           j1.setMise(0);
       }
    }
    
}
