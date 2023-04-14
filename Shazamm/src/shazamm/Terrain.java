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
    
    private int nbCaseDeplacement;  //nombre de case dont le feu va se déplacer 
    private int positionFeu;  //position du feu sur le pont 
    private boolean[] tabPont;  //pont 
    private boolean sort;  //est ce que les joueurs peuvent lancer des sorts 
    
    public Terrain(){  //constructeur 
        this.nbCaseDeplacement = 1;
        this.positionFeu = 10;
        this.sort = true; 
        tabPont = new boolean[19];  //initialisation 
        Arrays.fill(tabPont, true);  //toutes les cases du pont sont présentes 
    }
    
    public int getNbCaseDeplacement(){  //getter
        return this.nbCaseDeplacement;
    }
    
    public int getPositionFeu(){  //getter
        return this.positionFeu;
    }
    
    public boolean getTabPontCase(int i){  //getter : renvoie la ième case du pont 
        return this.tabPont[i];
    }
    
    public boolean getSort(){  //getter
        return this.sort;
    }
    
    public void setNbCaseDeplacement(int i){  //setter 
        this.nbCaseDeplacement = i;
    }
    
    public void setPositionFeu(int i){  //setter 
        this.positionFeu = i;
    }
    
    public void setSort(){  //setter 
        this.sort = !(this.sort);
    }
    
    public void ecrouler(){  //fonction modélisant l'écroulement du pont 
        for(int i=0;i<this.tabPont.length;i++)  
            if(this.tabPont[i]==true){  //la première case ayant la valeur true (pas encore écroulée)
                this.tabPont[i]=false;  // s'écroulent 
                break;  //et on sort de la boucle 
            }
        for(int i=this.tabPont.length-1;i>0;i--){  //cette fois on part de la fin du tableau
            if(this.tabPont[i]==true){  //première case pas écroulée 
                this.tabPont[i]=false;  //s'écroulent 
                break;  //et on sort de la bouche 
            }
        }
    }
}
