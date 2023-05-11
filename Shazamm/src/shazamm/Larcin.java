/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.ArrayList;

/**
 *
 * @author nomnelle
 */
public class Larcin extends Carte{
    
    public Larcin(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Larcin";
        this.image = "/cartes/03r.jpg";
        this.description = "Tous les sorts joués à ce tour sont sous mon contrôle.\nChacun est appliqué comme si je l’avais joué.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //les sorts de l'adversaires passent sous le contrôle du joueur 
       if(t.getSort()){  //si le joueur peut lancer des sorts 
           ArrayList<Integer> tmp = new ArrayList<>(j2.getSortActuel()); //on récupère les sorts de l'adversaire 
           j1.setSortActuel(tmp);  //on les ajoute à ceux du joueur 
           tmp.clear();
           j2.replaceSortActuel(tmp);  //L'adversaire n'a plus de sort 
       }
    }
    
}
