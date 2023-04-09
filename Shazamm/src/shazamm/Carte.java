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
    
    private boolean active;
    private int numero;
    private String name;
    private String image;
    
    public Carte(int n){
        this.active = false;
    }
    
    public boolean getActive(){
        return this.active;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getImage(){
        return this.image;
    }
    
    public void setActive(){
        this.active = !(this.active);
    }
    
    public abstract void effet(Terrain t, Sorcier j1, Sorcier j2);
    
}
