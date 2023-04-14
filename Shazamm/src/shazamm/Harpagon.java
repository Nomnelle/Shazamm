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
    
    public Harpagon(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Harpagon";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //passe la mise du joueur à 0
       if(t.getSort()){
           System.out.printf("Un sort fait que %s garde sa mise.", j1.getNom());
           j1.setMise(0);
       }
    }
    
}
