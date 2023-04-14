/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shazamm;

import java.util.Scanner;

/**
 *
 * @author nomnelle
 */
public class Recyclage extends Carte{
    
    public Recyclage(){  //constructeur 
        super();  //constructeur classe mère 
        this.name = "Recyclage";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){  //permet au joueur de modifier sa mise en l'augmentant ou en la diminuant 
        Scanner sc = new Scanner(System.in);
       if(t.getSort()){  //si le joueur peut lancer un sort 
           boolean tour = true;
           while(tour){  //tant que le joueur est en train de miser 
                System.out.println("Souhaitez vous augmenter ou diminuer la mise ? a/d");
                String answer = sc.nextLine();
                if(answer.equalsIgnoreCase("a")){  //augmentation de la mise 
                    tour = this.modifierMise(j1,answer);
                }else if(answer.equalsIgnoreCase("d")){  //diminuation de la mise 
                    tour = this.modifierMise(j1, answer);
                }else{  //mauvaise entrée 
                    System.out.println("Entrée non reconnue, veuillez écrire 'd' pour diminuer la mise, et 'a' pour l'augmenter.");
                }
           }     
       }
    }
    
    public boolean modifierMise(Sorcier j1, String s){  //selection du nombre point d'augmentation/de diminution 
        Scanner sc = new Scanner(System.in); 
        boolean tour;
        System.out.println("De combien souhaitez vous modifier la mise (entre 1 et 5 point) ?");
        try{  //éviter les exceptions dues à un mauvais type d'entrée 
            int change = sc.nextInt();
            if(change<=5&&change>=1){  //on vérifie que la mise se situe entre 1 et 5 points
                if(s.equalsIgnoreCase("a")){  //si le joueur a sélectionné une augmentation 
                    j1.setMise(j1.getMise()+change);
                }else{  //sinon 
                    j1.setMise(j1.getMise()-change);
                }
                tour = false;
                System.out.printf("Votre nouvelle mise est de %d.", j1.getMise()); 
                return tour;
            }else{  //sinon, mise non valide 
                System.out.println("Veuillez choisir un nombre entre 1 et 5 inclu.");
                tour = true;
            }
        }catch(java.util.InputMismatchException e){
            System.out.println("Entrée non valide.");
            tour = true;
        }
        return tour;
    }
    
}
