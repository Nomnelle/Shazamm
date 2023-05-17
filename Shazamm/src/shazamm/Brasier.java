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
    
        public Brasier(){  //constructeur 
        this.name = "Brasier";
        this.image = "/cartes/10r.jpg";
        this.description = "Le mur de feu se déplace de deux cases au lieu d’une.\nSeulement s’il devait se déplacer, bien sûr.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //fait que le feu se déplace de deux cases au lieu d'une 
       if(t.getSort()){  //si le joueur peut lancer un sort 
           if(t.getNbCaseDeplacement()==1){  //cas normal 
               t.setNbCaseDeplacement(t.getNbCaseDeplacement()+1);  //le feu se déplacera de 2
           }else if(t.getNbCaseDeplacement()==-1){  //cas où le sort "Qui perd gagne" a été lancé 
               t.setNbCaseDeplacement(t.getNbCaseDeplacement()-1);
           }       
       }
    }
    
}
