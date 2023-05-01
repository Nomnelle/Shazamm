/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package shazamm;

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

    public static boolean validateName(String input) {  //permet de valider que notre string contient au moins une lettre, et que des caractères alphanumériques ou des underscores
        Pattern pattern = Pattern.compile("\\w*[a-zA-Z]\\w*");  //la regex avec laquelle nous allons comparer le nom rentré par le user
        Matcher matcher = pattern.matcher(input);  //l'objet qui nous permettera d'effectuer la comparaison
        return matcher.matches();  //renvoit un boolean si la chaine correspond bien à la regex (true si c'est le cas, false sinon)
    }

    public String askName(String player) {  //Fonction pour demander au joueur son nom 
        String inputName = "";
        String message = player + ", entrez votre nom (au moins 1 lettre, chiffres et _ valides)";  //message affiché sur la fenêtre
        while ((inputName == null) || !(validateName(inputName))) {    //tant que le nom n'est pas valide ou que le joueur essaye de quitter la fenêtre
            inputName = JOptionPane.showInputDialog(this, message, "Demande de nom");   //une fenêtre JOptionPane récupère et renvoit l'input du joueur 
        }
        return inputName;   //On renvoit un nom valide
    }

    public ImageIcon loadImage(String filename) {
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

    public void update_pont(Terrain t) {  //fonction modélisant l'écroulement du pont //on change quand on en a besoin rather vérification  
        for (int i = 0; i < 19; i++) { // accès privé mais besoin de l'utiliser
            if (!(t.getTabPontCase(i))) {  //la première case ayant la valeur true (pas encore écroulée)
                String nomImage = "";

                if (i < 9) {
                    nomImage = String.format("lave/lave_0%d.gif", (i + 1));
                } else {
                    nomImage = String.format("lave/lave_%d.gif", (i + 1));
                }
                //On remplace la case par l'image de lave // écroule pont on change directement l'image à la place de vérifier 

            }
        }
    }

    public void devenir_sorcier(Sorcier j1) {
        for (int i = 0; i < 19; i++) {
            String nomImage_Sorcier = "";
            int mana = 50;
            Terrain t;
            if (mana == 0) {
                nomImage_Sorcier = String.format("perso/rouge.gif", (i = 0));
                if (j1.getPosition() < t.getPositionFeu()) {  //si le joueur 1 lance le sort 
                    t.setPositionFeu(j1.getPosition() + 3);
                    nomImage = String.format("perso/feu.gif" (i);
                } else if (j1.getPosition() == t.getPositionFeu()){
                    nomImage_Sorcier = String.format("perso/feu.gif", (i = j1.getPosition()));
                }
                
                } else {  //si le joueur 2 lance le sort 
                    t.setPositionFeu(j1.getPosition() - 3);
                }
            if (mana == 0) {
                nomImage_Sorcier = String.format("perso/vert.gif", (i = 0));
                if (j2.getPosition() < t.getPositionFeu()) {  //si le joueur 1 lance le sort 
                    t.setPositionFeu(j1.getPosition() + 3);
                    nomImage = String.format("perso/feu.gif" (i);
                } else if (j2.getPosition() == t.getPositionFeu()){
                    nomImage_Sorcier = String.format("perso/feu.gif", (i = j2.getPosition()));
                }
                
                } else {  //si le joueur 2 lance le sort 
                    t.setPositionFeu(j1.getPosition() - 3);
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

        String test = this.askName("Joueur");
        System.out.println(test);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(900, 600);
        this.add(mainPanel);

        Terrain t = new Terrain(); //création du terrain 
        int horizontal = 292;
        int vertical = 500;

        for (int i = 0; i < pontInterface.length; i++) {

            String nomImage;
            if (i < 9) {
                nomImage = String.format("/pont/pont_0%d.gif", (i + 1));
            } else {
                nomImage = String.format("/pont/pont_%d.gif", (i + 1));
            }

            pontInterface[i] = new JLabel();
            pontInterface[i].setLocation(horizontal, vertical);
            pontInterface[i].setSize(32, 100);
            mainPanel.add(pontInterface[i]);
            pontInterface[i].setIcon(loadImage(nomImage));

            horizontal = horizontal + 32;
        }

        for (int i = 0; i < pontInterface.length; i++) {
            // Implantation des image de la lave au fur et à mesure que le pont s'écroule
            String nomImage;
            if ((i < 9) && !(t.getTabPontCase(i))) {
                nomImage = String.format("lave/lave_0%d.gif", (i + 1));
            } else {
                nomImage = String.format("lave/lave_%d.gif", (i + 1));
            }

            pontInterface[i] = new JLabel();
            pontInterface[i].setLocation(horizontal, vertical);
            pontInterface[i].setSize(32, 93);
            mainPanel.add(pontInterface[i]);
            pontInterface[i].setIcon(loadImage(nomImage));

            horizontal = horizontal + 32;
        }

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
    String[] names = new String[2];
}
