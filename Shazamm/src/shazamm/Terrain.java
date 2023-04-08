/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

/**
 *
 * @author linazaarate
 */
public class Terrain {
    
    private int nbCaseDeplacement;
    private int positionFeu;
    private Terrain [] tabPont;
    
    public Terrain(int c, int f){
        this.nbCaseDeplacement = c;
        this.positionFeu = f;
    }
    
    public int getNbCaseDeplacement(){
        return this.nbCaseDeplacement;
    }
    
    public int getPositionFeu(){
        return this.positionFeu;
    }
    
    public void setNbCaseDeplacement(int i){
        this.nbCaseDeplacement = i;
    }
    
    public void setPositionFeu(int i){
        this.positionFeu = i;
    }
}
