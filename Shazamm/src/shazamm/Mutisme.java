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
    
    public Mutisme(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Mutisme";
        this.image = "/cartes/01r.jpg";
        this.description = "Aucun sort n’a plus d’effet pour les deux joueurs, jusqu’à la fin de la manche. Les autres sorts éventuellement posés sont perdus.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //Empêche quiconque de lancer des sorts 
       if(t.getSort()){
           t.setSort();
       }
    }
    
}
