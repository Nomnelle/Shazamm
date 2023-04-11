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
    
    public Recyclage(){
        super();
        this.numero = 6;
        this.name = "Recyclage";
        this.image = "";
    }
    
    @Override
    public void effet(Terrain t, Sorcier j1, Sorcier j2){
        Scanner sc = new Scanner(System.in);
       if(t.getSort()){
           boolean tour = true;
           while(tour){
                System.out.println("Souhaitez vous augmenter ou diminuer la mise ? a/d");
                String answer = sc.nextLine();
                if(answer.equalsIgnoreCase("a")){
                    this.modifierMise(j1,answer);
                    tour = false;
                }else if(answer.equalsIgnoreCase("d")){
                    this.modifierMise(j1, answer);
                    tour = false;
                }else{
                    System.out.println("Entrée non reconnue, veuillez écrire 'd' pour diminuer la mise, et 'a' pour l'augmenter.");
                }
           }     
       }
    }
    
    public void modifierMise(Sorcier j1, String s){
        Scanner sc = new Scanner(System.in);
        System.out.println("De combien souhaitez vous modifier la mise (entre 1 et 5 point) ?");
        try{
            int change = sc.nextInt();
            if(change<5&&change>1){
                if(s.equalsIgnoreCase("a")){
                    j1.setMise(j1.getMise()+change);
                }else{
                    j1.setMise(j1.getMise()-change);
                }      
                System.out.printf("Votre nouvelle mise est de %d.", j1.getMise());
            }else{
                System.out.println("Veuillez choisir un nombre entre 1 et 5 inclu.");
            }
        }catch(java.util.InputMismatchException e){
            System.out.println("Entrée non valide.");
        }
    }
    
}
