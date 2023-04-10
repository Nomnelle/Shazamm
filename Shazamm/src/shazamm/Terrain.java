/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.Arrays;

/**
 *
 * @author linazaarate
 */
public class Terrain {
    
    private int nbCaseDeplacement;
    private int positionFeu;
    private boolean[] tabPont;
    private boolean sort;
    
    public Terrain(){
        this.nbCaseDeplacement = 1;
        this.positionFeu = 10;
        this.sort = true; 
        tabPont = new boolean[19];
        Arrays.fill(tabPont, true);
    }
    
    public int getNbCaseDeplacement(){
        return this.nbCaseDeplacement;
    }
    
    public int getPositionFeu(){
        return this.positionFeu;
    }
    
    public boolean getTabPontCase(int i){
        return this.tabPont[i];
    }
    
    public boolean getSort(){
        return this.sort;
    }
    
    public void setNbCaseDeplacement(int i){
        this.nbCaseDeplacement = i;
    }
    
    public void setPositionFeu(int i){
        this.positionFeu = i;
    }
    
    public void setSort(){
        this.sort = !(this.sort);
    }
    
    public void ecrouler(){
        for(int i=0;i<this.tabPont.length;i++)
            if(this.tabPont[i]==true){
                this.tabPont[i]=false;
                break;
            }
        for(int i=this.tabPont.length-1;i>0;i--){
            if(this.tabPont[i]==true){
                this.tabPont[i]=false;
                break;
            }
        }
    }
}
