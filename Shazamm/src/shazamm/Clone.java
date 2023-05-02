/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author nomnelle
 */
public class Clone extends Carte{
    
    public Clone(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Clone";
        this.image = "/cartes/02r.jpg";
        this.description = "Je pose devant moi une des cartes jouées par l’adversaire au tour précédent.\nCette carte est appliquée à ce tour, comme si je l’avais jouée normalement.";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //permet au joueur de lancer un des sorts que son adversaire a joué au tour précédent 
        if(t.getSort()){  //si le joueur peut lancer un sort 
           while(true){
                boolean needHelp = false;   //player wants to read the help of a spell
                boolean selected = false;  //player has seleted a spell
                int spell = -1;
                String selectedSpellName = "";
                
                if(j2.getSortPrecedent().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Votre adversaire n'a pas joué de sort au tour précédent.", "Attention", JOptionPane.WARNING_MESSAGE);
                    break;
                }else{
                    if(!selected){
                        String[] spellsNames = formateSpellsNames(j2);
                        selectedSpellName = (String) JOptionPane.showInputDialog(null, "Choisissez un sort parmis ceux joué par l'adversaire au tour précédent.", "Sorts",  JOptionPane.PLAIN_MESSAGE, null, spellsNames, spellsNames[0]);
                        if(selectedSpellName!=null){  //if player hasn't cancel 
                            spell = j1.getInDeck(selectedSpellName);  //spell take the value of the index in deck of the selected spell 
                            selected = true;
                        }
                    }
                    if((selected)&&(!needHelp)){
                        int helpChoice = JOptionPane.showOptionDialog(null, "Que souhaitez vous ? (aide ou jouer le sort)", "Sorts", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Aide", "Caster", "Annuler"}, null);
                        if(helpChoice==JOptionPane.YES_OPTION){ //player wants help 
                            needHelp = true; 
                        }else if(helpChoice== JOptionPane.NO_OPTION){
                            j1.getSortActuel().add(spell);
                            break;
                        }else{
                            selected = false;
                        }
                    }
                    if(needHelp){  //if player watns help, we're showing a Panel with description, image and the name of the spell
                        JOptionPane.showMessageDialog(null, "Informations sur le sort :\n" + j1.getInDeck(spell).getDescription(), j1.getInDeck(spell).getName(), JOptionPane.INFORMATION_MESSAGE, Interface.loadImage(j1.getInDeck(spell).getImage()));
                        needHelp = false;
                    }
                }
            }
        }
    }
    
    private static String[] formateSpellsNames(Sorcier player){  //formate spells names for JOptionPane
        
        ArrayList<String> spellsNamesList = new ArrayList<>();
        
        for(int cards : player.getSortPrecedent()){
            spellsNamesList.add(player.getInDeck(cards).getName());
        }
                    
        Object[] spellsArr = spellsNamesList.toArray();
        String[] spellsNames = Arrays.copyOf(spellsArr, spellsArr.length, String[].class);
        
        return spellsNames;
        
    }
}
