/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author nomnelle
 */
public class Recyclage extends Carte{
    
    public Recyclage(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Recyclage";
        this.image = "/cartes/06r.jpg";
        this.description = "Je peux rectifier ma mise, en ajoutant ou retranchant jusqu’à 5 points de mana.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //permet au joueur de modifier sa mise en l'augmentant ou en la diminuant
        if(t.getSort()){
            int newBet = -1;
            String strBet = "";
            String message = String.format("%s, vous pouvez modifier votre mise : %d\n(ajouter 5 points ou retirer 5 au maximum avec votre sort Recyclage).", j1.getNom(), j1.getMise());
            while(strBet==null||!(validateEffect(newBet, j1))){
                try{
                    strBet = JOptionPane.showInputDialog(null, message);
                    newBet = Integer.parseInt(strBet);
                }catch(NumberFormatException e){
                    newBet = -1;
                }

            }
            j1.setMise(newBet);
        }
    }
    
    public boolean validateEffect(int input, Sorcier j1){
        boolean result;
        if((input<(j1.getMise()+6))){
            if((input>(j1.getMise()-6))){
                if(input<=j1.getMana()){
                    if((input>0)){
                        result = true;
                    }else{
                        result = false;
                    }      
                }else{
                    result = false;
                }
            }else{
                return false;   
            }
        }else{
            result = false;
        }
        return result;
    }
    
}
