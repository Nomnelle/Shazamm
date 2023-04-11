/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public class Brasier extends Carte{
    
        public Brasier(){
        super();
        this.numero = 10;
        this.name = "Brasier";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
       if(t.getSort()){
           if(t.getNbCaseDeplacement()==1){
               t.setNbCaseDeplacement(t.getNbCaseDeplacement()+1);
           }else if(t.getNbCaseDeplacement()==-1){
               t.setNbCaseDeplacement(t.getNbCaseDeplacement()-1);
           }       
       }
    }
    
}
