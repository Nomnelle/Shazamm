/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Milieu extends Carte{
    
    public Milieu(){
        super();
        this.numero = 5;
        this.name = "Milieu";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           System.out.println("Un sort fait que le feu se replace entre les deux joueurs.");
           if(j1.getPosition()<t.getPositionFeu()){
               t.setPositionFeu(j1.getPosition()+3);
           }else{
               t.setPositionFeu(j1.getPosition()-3);
           }
           
       }
    }
    
}
