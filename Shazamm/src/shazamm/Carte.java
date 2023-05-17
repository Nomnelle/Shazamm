/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author nomnelle
 */
public abstract class Carte {
    
    protected String name;  //nom de la carte 
    protected String image;  //image de la carte 
    protected String description; //description de la carte
    
    public String getName(){  //getter 
        return this.name;
    }
    
    public String getImage(){  //getter 
        return this.image;
    }
    
    public String getDescription(){  //getter
        return this.description;
    }
    
    public abstract void effet(Terrain t, Sorcier j1, Sorcier j2);  //fonction abstraite qui permettra à chaque carte d'avoir un effet propre 
    // paramètres : terrain, lanceur du sort, adversaire 
    
}
