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
    
    public Aspiration(){  //constructeur 
        super();  //constructeur Carte()
        this.name = "Aspiration";
        this.image = "/cartes/14r.jpg";
        this.description = "Ma réserve de Mana s’augmente du montant de la mise de l’adversaire.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){ //permet de régénérer sa réserve de mana à hauteur de la mise de l'adversaire 
       if(t.getSort()){  //si le joueur peut encore lancer des sorts 
           System.out.printf("%s vole la mise de %s...;\n", j1.getNom(), j2.getNom());
           j1.setMana(j1.getMana()+j2.getMise());  //le lanceur augmente sa réserve de mana à hauteur de la mise de l'adversaire 
       }
    }
    
}
