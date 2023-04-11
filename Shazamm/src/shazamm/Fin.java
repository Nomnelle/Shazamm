/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Fin extends Carte{
    
    public Fin(){
        super();
        this.numero = 4;
        this.name = "Fin de la manche!";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           System.out.println("Un sort décide la fin de la manche!");
           j1.setMise(0);
           j2.setMise(0);
           if(j1.getPosition()<t.getPositionFeu()){
                j1.setPosition(t.getPositionFeu()-3);
                j2.setPosition(t.getPositionFeu()+3);
           }else{
               j1.setPosition(t.getPositionFeu()+3);
               j2.setPosition(t.getPositionFeu()-3);
           }
           
           j1.setMana(50);
           j2.setMana(50);
           if(!(t.getSort())){
               t.setSort();
           }
       }
    }
}
