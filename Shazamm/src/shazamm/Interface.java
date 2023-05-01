/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package shazamm;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author nomnelle
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }
    
    private static ImageIcon loadImage(String filename) {
        ImageIcon image = null;
        try {
            // Obtenir le chemin de la ressource
            File imageFile = new File("img/" + filename); //En partant de notre espace de travail (cf fichier build.xml), conserve le lien du fichier cherché 
            InputStream inputStream = new FileInputStream(imageFile); //Contient les informations sur l'image, forme binaire 
            image = new ImageIcon(ImageIO.read(inputStream));  //Retransforme les informations de l'objet InputStream en image utilisable 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
    
    private void initInterface(JPanel mainPanel, Sorcier j1, Sorcier j2, Terrain t){
        
        int horizontal = 292;
        int verticalPont = 500;
        int verticalPos = verticalPont - 54;

        for (int i = 0; i < pontInterface.length; i++) {

            String nomImage;
            if (i < 9) {
                nomImage = String.format("/pont/pont_0%d.gif", (i + 1));
            } else {
                nomImage = String.format("/pont/pont_%d.gif", (i + 1));
            }

            pontInterface[i] = new JLabel();
            pontInterface[i].setLocation(horizontal, verticalPont);
            pontInterface[i].setSize(32, 100);
            mainPanel.add(pontInterface[i]);
            pontInterface[i].setIcon(loadImage(nomImage));
            
            positionInterface[i] = new JLabel();
            positionInterface[i].setLocation(horizontal, verticalPos);
            positionInterface[i].setSize(32, 55);
            mainPanel.add(positionInterface[i]);

            horizontal = horizontal + 32;
        }
        
        positionInterface[t.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); 
        positionInterface[j1.getPosition()].setIcon(loadImage("perso/rouge.gif"));
        positionInterface[j2.getPosition()].setIcon(loadImage("perso/vert.gif"));
        
    }


    private static boolean validateName(String input) {  //permet de valider que notre string contient au moins une lettre, et que des caractères alphanumériques ou des underscores
        Pattern pattern = Pattern.compile("\\w*[a-zA-Z]\\w*");  //la regex avec laquelle nous allons comparer le nom rentré par le user
        Matcher matcher = pattern.matcher(input);  //l'objet qui nous permettera d'effectuer la comparaison
        return matcher.matches();  //renvoit un boolean si la chaine correspond bien à la regex (true si c'est le cas, false sinon)
    }

    private String askName(String player) {  //Fonction pour demander au joueur son nom 
        String inputName = "";
        String message = player + ", entrez votre nom (au moins 1 lettre, chiffres et _ valides)";  //message affiché sur la fenêtre
        while ((inputName == null) || !(validateName(inputName))) {    //tant que le nom n'est pas valide ou que le joueur essaye de quitter la fenêtre
            inputName = JOptionPane.showInputDialog(this, message);   //une fenêtre JOptionPane récupère et renvoit l'input du joueur 
        }
        return inputName;   //On renvoit un nom valide
    }
    
    private static boolean validateBet(int input, Sorcier player){
        return (input>1)&&(input <= player.getMana());
    }
    
    private void askBet(Sorcier player){
        
        int bet = -1; 
        String strBet = "";
        String message = String.format("%s, entrez votre mise (mana restant : %d, mise minimale à 1) :", player.getNom(), player.getMana());
        
        while((strBet == null)||(!(validateBet(bet, player)))){
            try {
                strBet = JOptionPane.showInputDialog(this, message);
                bet = Integer.parseInt(strBet);
            } catch (NumberFormatException e) {
                bet = -1;
            }
        }
        
        player.setMise(bet);
    }

    private void updatePont(Terrain t) {  //fonction modélisant l'écroulement du pont //on change quand on en a besoin rather vérification  
        for (int i = 0; i < 19; i++) { 
            if (!(t.getTabPontCase(i))) {  //si la case est écroullée 
                String nomImage = "";

                if (i < 9) {
                    nomImage = String.format("lave/lave_0%d.gif", (i + 1));
                } else {
                    nomImage = String.format("lave/lave_%d.gif", (i + 1));  //on récupère le nom du fichier de lave à récupérer 
                }
                //On remplace la case par l'image de lave 
                pontInterface[i].setIcon(loadImage(nomImage));
            }
        }
    }
    
    private void verifierFinManche(Sorcier j1,Sorcier j2, Terrain t) { //Vérifie si c'est la fin de la manche
        
        for (int i = 0; i < 19; i++) {
            final String nomImageFeu = "perso/feu.gif";
            
            if((j1.getMana()==0)&&(j2.getMana()==0)){     
                
                positionInterface[t.getPositionFeu()].setIcon(null);
                t.setPositionFeu(j1.getPosition()+3);  //égalité 
                positionInterface[t.getPositionFeu()].setIcon(loadImage(nomImageFeu)); //ajouter le feu dans l'interface
                this.finirManche(j1, j2, t);
                
            }else if((j1.getMana() == 0)||(j1.getPosition() >= t.getPositionFeu())) { //j1 perd
                
                if(t.getPositionFeu()<j1.getPosition()){
                    positionInterface[t.getPositionFeu()].setIcon(null);
                    t.setPositionFeu(j1.getPosition());  //le feu ne dépasse pas le joueur 1
                    positionInterface[t.getPositionFeu()].setIcon(loadImage(nomImageFeu)); //ajouter le feu dans l'interface 
                    
                }
                this.finirManche(j1, j2, t);  //gestion fin de manche
               
            }else if ((j2.getMana() == 0)||(t.getPositionFeu()>=j2.getPosition())) {  //j2 perd
                
                if (j2.getPosition() < t.getPositionFeu()) {  //le feu ne dépasse pas le j2
                    positionInterface[t.getPositionFeu()].setIcon(null);
                    t.setPositionFeu(j2.getPosition());
                    positionInterface[t.getPositionFeu()].setIcon(loadImage(nomImageFeu)); //ajouter le feu dans l'interface 
                }
                this.finirManche(j1, j2, t);  //gestion fin de manche
            }
        }
    }
        
    private void finirManche(Sorcier j1, Sorcier j2, Terrain t){  //fonction qui permet d'émuler la fin de la manche
        
        String nomImageSorcierJ1 = "perso/rouge.gif";
        String nomImageSorcierJ2 = "perso/vert.gif";
        
        positionInterface[j1.getPosition()].setIcon(null);
        positionInterface[j2.getPosition()].setIcon(null);
                
        j1.setPosition(t.getPositionFeu()-3);
        j2.setPosition(t.getPositionFeu()+3);  //on repositionne les joueurs 
                
        positionInterface[j1.getPosition()].setIcon(loadImage(nomImageSorcierJ1));
        positionInterface[j2.getPosition()].setIcon(loadImage(nomImageSorcierJ2));  //on repositionne les icones des joueurs sur l'interface
        positionInterface[t.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); 
                
        j1.setMana(50);
        j2.setMana(50);  //les joueurs retrouvent leurs points de mana
                
        if(!(t.getSort())){
            t.setSort();   //si le sort mutisme a été lancé, il est levé 
        }
                
        for(int i = 0;i<3;i++){
            j1.piocher();
            j2.piocher();
        }
                
        t.ecrouler();
        this.updatePont(t);
    }
    
    private void verifierFinPartie(Terrain t, Sorcier j1, Sorcier j2){
        
        if(!(t.getTabPontCase(j1.getPosition()))){
            positionInterface[j1.getPosition()].setIcon(null);
            game = false;
        }else if(!(t.getTabPontCase(j2.getPosition()))){
            positionInterface[j2.getPosition()].setIcon(null);
            game = false;
        }
        
    }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JFrame();
        startButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        new_game = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        javax.swing.GroupLayout popupLayout = new javax.swing.GroupLayout(popup.getContentPane());
        popup.getContentPane().setLayout(popupLayout);
        popupLayout.setHorizontalGroup(
            popupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        popupLayout.setVerticalGroup(
            popupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shazamm");
        setBackground(new java.awt.Color(75, 0, 130));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        startButton.setText("Jouer");
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        new_game.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        new_game.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        new_game.setText("New game");
        jMenu1.add(new_game);

        quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        quit.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jMenu1.add(quit);

        jMenuBar1.add(jMenu1);

        help.setText("Help");

        about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        about.setText("About");
        help.add(about);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(startButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(startButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitActionPerformed

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked

        startButton.setVisible(false);
        game = true;
        
        Terrain terrain = new Terrain();
        
        String nomJ1 = this.askName("Joueur 1");
        String nomJ2 = this.askName("Joueur 2");
        
        Sorcier joueur1 = new Sorcier(nomJ1, terrain.getPositionFeu()-3);
        Sorcier joueur2 = new Sorcier(nomJ2, terrain.getPositionFeu()+3);

        JPanel mainPanel = new JPanel();
        
        mainPanel.setLayout(null);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(900, 600);
        this.add(mainPanel);
        mainPanel.setBackground(Color.BLACK);
        
        this.initInterface(mainPanel, joueur1, joueur2, terrain);
        
        while(this.game){
            
            this.askBet(joueur1);
            this.askBet(joueur2);
            
            if(joueur1.getMise()<joueur2.getMise()){
                positionInterface[terrain.getPositionFeu()].setIcon(null);
                terrain.setPositionFeu(terrain.getPositionFeu()-terrain.getNbCaseDeplacement());
                positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface 
            }else if(joueur1.getMise()>joueur2.getMise()){
                positionInterface[terrain.getPositionFeu()].setIcon(null);
                terrain.setPositionFeu(terrain.getPositionFeu()+terrain.getNbCaseDeplacement());
                positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface 
            }
            
            joueur1.setMana(joueur1.getMana()-joueur1.getMise());
            joueur2.setMana(joueur2.getMana()-joueur2.getMise());
            
            this.verifierFinManche(joueur1, joueur2, terrain);
            
            this.verifierFinPartie(terrain, joueur1, joueur2);
                      
        }
        
        this.remove(mainPanel);
        
        startButton.setVisible(true);
        
    }//GEN-LAST:event_startButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu help;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem new_game;
    private javax.swing.JFrame popup;
    private javax.swing.JMenuItem quit;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
    private boolean game = false;
    JLabel[] pontInterface = new JLabel[19];
    JLabel[] positionInterface = new JLabel[19];
}
