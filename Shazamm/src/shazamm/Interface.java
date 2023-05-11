/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package shazamm;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
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
    
    public static ImageIcon loadImage(String filename) {
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
    
    public void changerCouleurPolice(Sorcier player, JLabel suiviJeu) {
 
        String couleur = player.getCouleur();
                
        switch(couleur) {
            case "rouge":
                player.getCouleur();
                suiviJeu.setForeground(Color.RED);
                break;
            case "vert":
                player.getCouleur();
                suiviJeu.setForeground(Color.GREEN);
                break;
            default:
                suiviJeu.setForeground(Color.BLACK);
                break;
        }

    }
    
    private void initHistorique(JPanel historique, int tour, int manche) {
        // Affiche le numero des tours, pour initialiser l'historique
        JLabel info = new JLabel();
        String message = String.format("Manche %d Tour %d", manche, tour);
        info.setText(message);
        historique.removeAll();  
        historique.add(info);
        historique.repaint();     
  
    }
    
    private void afficherMise(JPanel historique, Sorcier player) { // ira en-dessous lorsque les joueurs ont choisi les sorts
        
        JLabel info = new JLabel();
        String message = String.format("%s a misé %d", player.getNom(), player.getMise());
        info.setText(message);
        changerCouleurPolice(player, info);
        historique.add(info);
        historique.repaint();   
        
    }
    
    private void afficherSort(JPanel historique, Sorcier player, int number) { // ira dans activateSpell
        
        JLabel info = new JLabel();
        String message = String.format("Le sort %s de %s s'active", player.getInDeck(number).getName(), player.getNom());
        info.setText(message);
        changerCouleurPolice(player, info);
        historique.add(info);
        historique.repaint();   
        
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
        
        int posName = 292 + 154 - 50;

        JLabel name1 = new JLabel();
        name1.setLocation(posName, 200);
        name1.setSize(100,30);
        name1.setText(j1.getNom());
        name1.setForeground(Color.RED);
        
        posName += 304;
        
        JLabel name2 = new JLabel();
        name2.setLocation(posName, 200);
        name2.setSize(100,30);
        name2.setText(j2.getNom());
        name2.setForeground(Color.GREEN);
        
        mainPanel.add(name1);
        mainPanel.add(name2);
            
    }
    
    
    private void synchronizeSecondInterfaceHistorique(JPanel primaryHistorique, JPanel secondaryHistorique){
        secondaryHistorique.removeAll(); 
        ArrayList<String> historique = new ArrayList<>();
        ArrayList<Color> infoColor = new ArrayList<>();
        for (Component component : primaryHistorique.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                Color color = label.getForeground();
                historique.add(label.getText());
                infoColor.add(color);
            }
        }
        for(int i = 0; i < historique.size(); i++){
            JLabel toAdd = new JLabel(historique.get(i));
            toAdd.setForeground(infoColor.get(i));
            secondaryHistorique.add(toAdd);
        }
        secondaryHistorique.repaint();
    }

    public static boolean validateName(String input) {  //permet de valider que notre string contient au moins une lettre, et que des caractères alphanumériques ou des underscores
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
    
    public static boolean validateBet(int input, Sorcier player){
        return (input>0)&&(input <= player.getMana());
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
           
    private boolean askSpell(Sorcier player){  //JOptionPane to ask player if he wants to cast spells
        String message = String.format("%s, voulez-vous lancer un sort ?", player.getNom());
        int cast = JOptionPane.showOptionDialog(this, message, "Sorts", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        return cast != JOptionPane.NO_OPTION;
    }
    
    public static String[] formateSpellsName(Sorcier player){  //formate spells names for JOptionPane
        
        ArrayList<String> spellsNamesList = new ArrayList<>();
        
        for(int cards : player.getMain()){
            spellsNamesList.add(player.getInDeck(cards).getName());
        }
                    
        Object[] spellsArr = spellsNamesList.toArray();
        String[] spellsNames = Arrays.copyOf(spellsArr, spellsArr.length, String[].class);
        
        return spellsNames;
        
    }
 
    private void selectSpells(Sorcier player){ //let player choose the spells he wants to cast
        
        player.lancerSort(); 
        ArrayList<Integer> castedSpells = new ArrayList<>();  //selected spells 
        boolean cast = false;  //player wants to cast a spell
        boolean needHelp = false;   //player wants to read the help of a spell
        boolean selected = false;  //player has seleted a spell
        
        while(true){
            
            int spell = -1;
            String selectedSpellName = "";
               
            if(!cast){  //if player hasn't choose to cast a spell 
                if(!(this.askSpell(player))){
                    break;  //if player dosen't want to cast a spell, exit loop 
                }else{
                    cast = true;  //else, moving on to the next JOptionPane 
                }
            }
            
            if(player.getMain().isEmpty()){  //if player already used all of his spells, we're telling him and we exit loop
                JOptionPane.showMessageDialog(this, "Vous n'avez plus de sort dans votre main...", "Attention", JOptionPane.WARNING_MESSAGE);
                break;
            }else{
                if(!(selected)){  //else, if player hasn't selected a spell yet 
                    String[] spellsNames = formateSpellsName(player);  //we're showing him all of his options
                    selectedSpellName = (String) JOptionPane.showInputDialog(this, "Choisissez un sort parmis ceux dans votre main", "Sorts",  JOptionPane.QUESTION_MESSAGE, null, spellsNames, spellsNames[0]);
                    if(selectedSpellName!=null){  //if player hasn't cancel 
                        spell = player.getInDeck(selectedSpellName);  //spell take the value of the index in deck of the selected spell 
                        selected = true;
                    }else{
                        cast = false;
                    }
                }
                
                if((!needHelp)&&(selected)){  //if player has selected a spell and has not choose if he wants help about it 
                    int helpChoice = JOptionPane.showOptionDialog(this, "Que souhaitez vous ? (aide ou jouer le sort)", "Sorts", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Aide", "Caster", "Annuler"}, null);
                    switch(helpChoice){
                    case JOptionPane.YES_OPTION: //player wants help 
                        needHelp = true; 
                        break;
                    case JOptionPane.NO_OPTION:  //we're going back to the first Panel  
                        castedSpells.add(spell); //we're adding selected spell to list
                        player.removeHand(spell); //we're removing selected spell from hand
                        selected = false;
                        cast = false;
                        break;
                    default:
                        selected = false;
                        cast = false;
                        break;
                    }
                }
                if(needHelp){  //if player watns help, we're showing a Panel with description, image and the name of the spell
                    JOptionPane.showMessageDialog(this, "Informations sur le sort :\n" + player.getInDeck(spell).getDescription(), player.getInDeck(spell).getName(), JOptionPane.INFORMATION_MESSAGE, loadImage(player.getInDeck(spell).getImage()));
                    needHelp = false;
                }
                
                
            }    
        }
        
        player.setSortActuel(castedSpells); //adding all selected spells to the casted spells
    }
    
    
    public void activateSpell(int number, Sorcier j1, Sorcier j2, Terrain t, JPanel historique){
        if(number == 2){
            if(j1.getSortActuel().contains(number)&&j2.getSortActuel().contains(number)){
                j1.getInDeck(number).effet(t, j1, j2);
                j2.setSortActuel(j1.getSortActuel());
                this.afficherSort(historique, j1, number);
                this.afficherSort(historique, j2, number);
            }else if(j1.getSortActuel().contains(number)){  
                j1.getInDeck(number).effet(t, j1, j2);
                this.afficherSort(historique, j1, number);
            }else if(j2.getSortActuel().contains(number)){
                j2.getInDeck(number).effet(t, j2, j1);
                this.afficherSort(historique, j2, number);
            }
        }else if(number == 0||number == 3||number == 4||number == 8||number == 9){
            if(j1.getSortActuel().contains(number)){ 
                j1.getInDeck(number).effet(t, j1, j2);
                this.afficherSort(historique, j1, number);
            }else if(j2.getSortActuel().contains(number)){
                j2.getInDeck(number).effet(t, j2, j1);
                this.afficherSort(historique, j2, number);
            }
        }else{
            if(j1.getSortActuel().contains(number)){  
                j1.getInDeck(number).effet(t, j1, j2);
                this.afficherSort(historique, j1, number);
            }
            if(j2.getSortActuel().contains(number)){
                    j2.getInDeck(number).effet(t, j2, j1);
                    this.afficherSort(historique, j2, number);
            }
        }
        
    } 
    
    private boolean verifierFinManche(Sorcier j1,Sorcier j2, Terrain t) { //Vérifie si c'est la fin de la manche
        
        final String nomImageFeu = "perso/feu.gif";
            
        if((j1.getMana()==0)&&(j2.getMana()==0)){     
                
            positionInterface[t.getPositionFeu()].setIcon(null);
            t.setPositionFeu(j1.getPosition()+3);  //égalité 
            positionInterface[t.getPositionFeu()].setIcon(loadImage(nomImageFeu)); //ajouter le feu dans l'interface
            this.finirManche(j1, j2, t);
            return true;
                
        }else if((j1.getMana() == 0)||(j1.getPosition() >= t.getPositionFeu())) { //j1 perd
                
            if(t.getPositionFeu()<j1.getPosition()){
                positionInterface[t.getPositionFeu()].setIcon(null);
                t.setPositionFeu(j1.getPosition());  //le feu ne dépasse pas le joueur 1
                positionInterface[t.getPositionFeu()].setIcon(loadImage(nomImageFeu)); //ajouter le feu dans l'interface 
                    
            }
            this.finirManche(j1, j2, t);  //gestion fin de manche
            return true;
               
        }else if ((j2.getMana() == 0)||(t.getPositionFeu()>=j2.getPosition())) {  //j2 perd
                
            if (j2.getPosition() < t.getPositionFeu()) {  //le feu ne dépasse pas le j2
                positionInterface[t.getPositionFeu()].setIcon(null);
                t.setPositionFeu(j2.getPosition());
                positionInterface[t.getPositionFeu()].setIcon(loadImage(nomImageFeu)); //ajouter le feu dans l'interface 
            }
            this.finirManche(j1, j2, t);  //gestion fin de manche
            return true; 
        }
        return false;
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
    
    private void updateInterfaceManche(Sorcier j1, Sorcier j2, Terrain t){  //fonction qui permet d'émuler la fin de la manche sur deuxième fenêtre
        
        String nomImageSorcierJ1 = "perso/rouge.gif";
        String nomImageSorcierJ2 = "perso/vert.gif";
        
        for(int i=0;i<positionInterface.length;i++){
            positionInterface[i].setIcon(null);
        }
                
        positionInterface[j1.getPosition()].setIcon(loadImage(nomImageSorcierJ1));
        positionInterface[j2.getPosition()].setIcon(loadImage(nomImageSorcierJ2));  //on repositionne les icones des joueurs sur l'interface
        positionInterface[t.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); 

        this.updatePont(t);
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
    
    private boolean verifierFinPartie(Terrain t, Sorcier j1, Sorcier j2){
        
        if(!(t.getTabPontCase(j1.getPosition()))){
            positionInterface[j1.getPosition()].setIcon(null);
            return false;
        }else if(!(t.getTabPontCase(j2.getPosition()))){
            positionInterface[j2.getPosition()].setIcon(null);
            return false;
        }
        return true;
        
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
        multipleWindowsButton = new javax.swing.JButton();
        highScoreButton = new javax.swing.JButton();
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

        multipleWindowsButton.setText("Jouer (plusieurs écrans)");
        multipleWindowsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multipleWindowsButtonMouseClicked(evt);
            }
        });
        multipleWindowsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleWindowsButtonActionPerformed(evt);
            }
        });

        highScoreButton.setText("High Score");
        highScoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                highScoreButtonMouseClicked(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(startButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(multipleWindowsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(highScoreButton)))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(startButton)
                .addGap(54, 54, 54)
                .addComponent(multipleWindowsButton)
                .addGap(58, 58, 58)
                .addComponent(highScoreButton)
                .addContainerGap(150, Short.MAX_VALUE))
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

        BDD db = new BDD();
        startButton.setVisible(false);
        multipleWindowsButton.setVisible(false);
        
        boolean game = true;
        
        int nbTour = 0;
        int nbManche = 1;
        
        Terrain terrain = new Terrain();
        
        String nomJ1 = this.askName("Joueur 1");
        String nomJ2 = this.askName("Joueur 2");
        
        if(nomJ2.equals(nomJ1)){
            while(nomJ2.equals(nomJ1)){
                JOptionPane.showMessageDialog(this, "Joueur 2, votre nom est identique à celui du joueur 1.\nVeuillez le modifier.", "Attention", JOptionPane.WARNING_MESSAGE);
                nomJ2 = this.askName("Joueur 2");
            }
        }
        
        Sorcier joueur1 = new Sorcier(nomJ1, terrain.getPositionFeu()-3, "rouge");
        Sorcier joueur2 = new Sorcier(nomJ2, terrain.getPositionFeu()+3, "vert");

        JPanel mainPanel = new JPanel();
        
        mainPanel.setLayout(null);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(900, 600);
        this.add(mainPanel);
        mainPanel.setBackground(Color.BLACK);
        
        JPanel historiquePanel = new JPanel();

        historiquePanel.setLayout(new BoxLayout(historiquePanel, BoxLayout.Y_AXIS));;
        historiquePanel.setLocation(0, 0);
        historiquePanel.setSize(292, 600);
        mainPanel.add(historiquePanel);
        historiquePanel.setBackground(new Color(205, 183, 135));
        
        this.initInterface(mainPanel, joueur1, joueur2, terrain);
        
        Sorcier gagnant = null;
        String message = "";
        
        while(game){
            
            nbTour ++;
            initHistorique(historiquePanel, nbTour, nbManche);
            
            this.askBet(joueur1);
            this.askBet(joueur2);  //ask player how many mana they will bet 
            
            if(terrain.getSort()){
                this.selectSpells(joueur1);
                this.selectSpells(joueur2);
            }
            
            afficherMise(historiquePanel, joueur1);
            afficherMise(historiquePanel, joueur2);
            
            for(int i = 0; i<10;i++){
                activateSpell(i, joueur1, joueur2, terrain, historiquePanel);
            }
            
            if(joueur1.getSortActuel().contains(3)||joueur2.getSortActuel().contains(3)||joueur1.getSortActuel().contains(4)||joueur2.getSortActuel().contains(4)){
               this.updateInterfaceManche(joueur1, joueur2, terrain);
            }
            
            if(joueur1.getMise()<joueur2.getMise()){  //define winner
                
                gagnant = joueur2;
                if(joueur1.getSortActuel().contains(8)||joueur2.getSortActuel().contains(8)){
                    message = String.format("Malgré une attaque plus puissante que son adversaire, le feu avance vers %s...", gagnant.getNom());
                }else{
                    message = String.format("Le feu avance vers la gauche suite aux attaques de %s", gagnant.getNom());
                }  
                
                if(joueur1.getSortActuel().contains(10)){  //Si le joueur 1 a Resistance 
                    joueur1.getInDeck(10).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur1, 10);
                    message = String.format("Le feu devrait avancer vers la droite suite aux attaques de %s, mais il reste immobile...", gagnant.getNom());
                }
                if(joueur1.getSortActuel().contains(11)){  //Si le joueur 1 a Harpagon 
                    joueur1.getInDeck(11).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur1, 11);
                }
                
                positionInterface[terrain.getPositionFeu()].setIcon(null);  //remove old flame image 
                terrain.setPositionFeu(terrain.getPositionFeu()-terrain.getNbCaseDeplacement());  //move fire 
                positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface 
                
            }else if(joueur1.getMise()>joueur2.getMise()){
                gagnant = joueur1;
                           
                if(joueur1.getSortActuel().contains(8)||joueur2.getSortActuel().contains(8)){
                    message = String.format("Malgré une attaque plus puissante que son adversaire, le feu avance vers %s...", gagnant.getNom());
                }else{
                    message = String.format("Le feu avance vers la droite suite aux attaques de %s", gagnant.getNom());
                } 
                
                if(joueur2.getSortActuel().contains(10)){  //si le joueur 2 a Resistance 
                    joueur2.getInDeck(10).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur2, 10);
                    message = String.format("Le feu devrait avancer vers la droite suite aux attaques de %s, mais il reste immobile...", gagnant.getNom());
                }
                if(joueur2.getSortActuel().contains(11)){  //Si le joueur 2 a Harpagon 
                    joueur2.getInDeck(11).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur2, 11);
                }
                positionInterface[terrain.getPositionFeu()].setIcon(null);
                terrain.setPositionFeu(terrain.getPositionFeu()+terrain.getNbCaseDeplacement());
                positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface
                
            }else{
                message = "Les attaques sont aussi fortes d'un côté que de l'autre ! le feu ne bouge pas.";
            }
            
            if(terrain.getNbCaseDeplacement()!=1){  //Si le nombre de case de déplacement du feu a été modifié, il est réinitialisé 
                    terrain.setNbCaseDeplacement(1);
            }
            
            if(joueur1.getSortActuel().contains(7)){  //Si Double Dose a été joué par le j1, on enlève son effet à la mise de base 
                joueur1.setMise(joueur1.getMise()/2);
            }
            if(joueur1.getSortActuel().contains(6)){ //Même chose mais si Boost a été joué 
                joueur1.setMise(joueur1.getMise()-7);
            }
            
            if(joueur2.getSortActuel().contains(7)){  //Même principe, mais si le j2 a joué Double dose 
                joueur2.setMise(joueur2.getMise()/2);
            }
            if(joueur2.getSortActuel().contains(6)){  //et si le j2 a joué Boost
                joueur2.setMise(joueur2.getMise()-7);
            }
            
            joueur1.setMana(joueur1.getMana()-joueur1.getMise());
            joueur2.setMana(joueur2.getMana()-joueur2.getMise());  //remove bet from total mana 
            
            for(int i = 12; i<14;i++){
                activateSpell(i, joueur1, joueur2, terrain, historiquePanel);
            }
            
            
            boolean finManche = this.verifierFinManche(joueur1, joueur2, terrain);
            if(finManche){
                nbManche++;
                nbTour = 0;
            }
            
            game = this.verifierFinPartie(terrain, joueur1, joueur2);
            
            JOptionPane.showMessageDialog(this, message, "Fin du tour", JOptionPane.INFORMATION_MESSAGE);
                      
        }
        message = "Le sorcier "+gagnant.getNom()+" est vainqueur !";
        JOptionPane.showMessageDialog(this, message, "Fin de partie", JOptionPane.INFORMATION_MESSAGE);
        if(gagnant!=null){
            db.insertTuples(gagnant.getNom(), gagnant.getCouleur());
        }
        
        this.remove(mainPanel);  //remove panel to reset game
        this.repaint();   //update frame
        
        startButton.setVisible(true);
        multipleWindowsButton.setVisible(true);
        
    }//GEN-LAST:event_startButtonMouseClicked

    private void multipleWindowsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multipleWindowsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multipleWindowsButtonActionPerformed

    private void multipleWindowsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multipleWindowsButtonMouseClicked
        
        BDD db = new BDD();
        this.startButton.setVisible(false);
        this.multipleWindowsButton.setVisible(false);
        
        Interface j2Wind = new Interface();
        
        j2Wind .startButton.setVisible(false);
        j2Wind .multipleWindowsButton.setVisible(false);
        j2Wind.setVisible(true);
        
        boolean game = true;
        
        int nbTour = 0;
        int nbManche = 1;
        
        Terrain terrain = new Terrain();

        j2Wind.setVisible(true);
        
        String nomJ1 = this.askName("Joueur 1");
        String nomJ2 = j2Wind.askName("Joueur 2");
        
        if(nomJ2.equals(nomJ1)){
            while(nomJ2.equals(nomJ1)){
                JOptionPane.showMessageDialog(j2Wind, "Joueur 2, votre nom est identique à celui du joueur 1.\nVeuillez le modifier.", "Attention", JOptionPane.WARNING_MESSAGE);
                nomJ2 = j2Wind.askName("Joueur 2");
            }
        }
        
        Sorcier joueur1 = new Sorcier(nomJ1, terrain.getPositionFeu()-3, "rouge");
        Sorcier joueur2 = new Sorcier(nomJ2, terrain.getPositionFeu()+3, "vert");
        
        JPanel mainPanel = new JPanel();
        JPanel secondaryPanel = new JPanel();
        
        mainPanel.setLayout(null);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(900, 600);
        this.getContentPane().add(mainPanel);
        mainPanel.setBackground(Color.BLACK);
        
        secondaryPanel.setLayout(null);
        secondaryPanel.setLocation(0,0);
        secondaryPanel.setSize(900, 600);
        j2Wind.getContentPane().add(secondaryPanel);
        secondaryPanel.setBackground(Color.BLACK);
        
        JPanel historiquePanel = new JPanel();
        historiquePanel.setLayout(new BoxLayout(historiquePanel, BoxLayout.Y_AXIS));;
        historiquePanel.setLocation(0, 0);
        historiquePanel.setSize(292, 600);
        mainPanel.add(historiquePanel);
        historiquePanel.setBackground(new Color(205, 183, 135));
        
        JPanel secondHistoriquePanel = new JPanel();
        secondHistoriquePanel.setLayout(new BoxLayout(secondHistoriquePanel, BoxLayout.Y_AXIS));;
        secondHistoriquePanel.setLocation(0, 0);
        secondHistoriquePanel.setSize(292, 600);
        secondaryPanel.add(secondHistoriquePanel);
        secondHistoriquePanel.setBackground(new Color(205, 183, 135));
        
        this.initInterface(mainPanel, joueur1, joueur2, terrain);
        j2Wind.initInterface(secondaryPanel, joueur1, joueur2, terrain);
        
        Sorcier gagnant = null;
        String message = "";

        while(game){
            
            nbTour ++;
            initHistorique(historiquePanel, nbTour, nbManche);
            initHistorique(secondHistoriquePanel, nbTour, nbManche);
            
            this.askBet(joueur1);
            j2Wind.askBet(joueur2);  //ask player how many mana they will bet 
            
            if(terrain.getSort()){
                this.selectSpells(joueur1);
                j2Wind.selectSpells(joueur2);
            }
            
            afficherMise(historiquePanel, joueur1);
            afficherMise(historiquePanel, joueur2);
            
            for(int i = 0; i<10;i++){
                activateSpell(i, joueur1, joueur2, terrain, historiquePanel);
            }
            
            if(joueur1.getSortActuel().contains(3)||joueur2.getSortActuel().contains(3)||joueur1.getSortActuel().contains(4)||joueur2.getSortActuel().contains(4)){
               this.updateInterfaceManche(joueur1, joueur2, terrain);
               j2Wind.updateInterfaceManche(joueur1, joueur2, terrain);
            }
            
            if(joueur1.getMise()<joueur2.getMise()){  //define winner
                
                gagnant = joueur2;
                if(joueur1.getSortActuel().contains(8)||joueur2.getSortActuel().contains(8)){
                    message = String.format("Malgré une attaque plus puissante que son adversaire, le feu avance vers %s...", gagnant.getNom());
                }else{
                    message = String.format("Le feu avance vers la gauche suite aux attaques de %s", gagnant.getNom());
                }  
                
                
                if(joueur1.getSortActuel().contains(10)){  //Si le joueur 1 a Resistance 
                    joueur1.getInDeck(10).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur1, 10);
                    message = String.format("Le feu devrait avancer vers la droite suite aux attaques de %s, mais il reste immobile...", gagnant.getNom());
                }
                if(joueur1.getSortActuel().contains(11)){  //Si le joueur 1 a Harpagon 
                    joueur1.getInDeck(11).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur1, 11);
                }
                
                this.positionInterface[terrain.getPositionFeu()].setIcon(null);  //remove old flame image
                j2Wind.positionInterface[terrain.getPositionFeu()].setIcon(null);
                terrain.setPositionFeu(terrain.getPositionFeu()-terrain.getNbCaseDeplacement());  //move fire 
                this.positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface 
                j2Wind.positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface 
                
            }else if(joueur1.getMise()>joueur2.getMise()){
                gagnant = joueur1;
                if(joueur1.getSortActuel().contains(8)||joueur2.getSortActuel().contains(8)){
                    message = String.format("Malgré une attaque plus puissante que son adversaire, le feu avance vers %s...", gagnant.getNom());
                }else{
                    message = String.format("Le feu avance vers la droite suite aux attaques de %s", gagnant.getNom());
                } 
                if(joueur2.getSortActuel().contains(10)){  //si le joueur 2 a Resistance 
                    joueur2.getInDeck(10).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur2, 10);
                    message = String.format("Le feu devrait avancer vers la droite suite aux attaques de %s, mais il reste immobile...", gagnant.getNom());
                }
                if(joueur2.getSortActuel().contains(11)){  //Si le joueur 2 a Harpagon 
                    joueur2.getInDeck(11).effet(terrain, joueur1, joueur2);
                    this.afficherSort(historiquePanel, joueur2, 11);
                }
                this.positionInterface[terrain.getPositionFeu()].setIcon(null);  //remove old flame image
                j2Wind.positionInterface[terrain.getPositionFeu()].setIcon(null);
                terrain.setPositionFeu(terrain.getPositionFeu()-terrain.getNbCaseDeplacement());  //move fire 
                this.positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface 
                j2Wind.positionInterface[terrain.getPositionFeu()].setIcon(loadImage("perso/feu.gif")); //ajouter le feu dans l'interface
                
            }else{
                message = "Les attaques sont aussi fortes d'un côté que de l'autre ! le feu ne bouge pas.";
            }
            
            if(terrain.getNbCaseDeplacement()!=1){  //Si le nombre de case de déplacement du feu a été modifié, il est réinitialisé 
                    terrain.setNbCaseDeplacement(1);
            }
            
            if(joueur1.getSortActuel().contains(7)){  //Si Double Dose a été joué par le j1, on enlève son effet à la mise de base 
                joueur1.setMise(joueur1.getMise()/2);
            }
            if(joueur1.getSortActuel().contains(6)){ //Même chose mais si Boost a été joué 
                joueur1.setMise(joueur1.getMise()-7);
            }
            
            if(joueur2.getSortActuel().contains(7)){  //Même principe, mais si le j2 a joué Double dose 
                joueur2.setMise(joueur2.getMise()/2);
            }
            if(joueur2.getSortActuel().contains(6)){  //et si le j2 a joué Boost
                joueur2.setMise(joueur2.getMise()-7);
            }
            
            joueur1.setMana(joueur1.getMana()-joueur1.getMise());
            joueur2.setMana(joueur2.getMana()-joueur2.getMise());  //remove bet from total mana 
            
            for(int i = 12; i<14;i++){
                activateSpell(i, joueur1, joueur2, terrain, historiquePanel);
            }
            
            int oldPosJ1 = joueur1.getPosition();
            int oldPosJ2 = joueur2.getPosition();
            boolean finManche = this.verifierFinManche(joueur1, joueur2, terrain);
            if(finManche){
                j2Wind.updateInterfaceManche(joueur1, joueur2, terrain);
                nbManche++;
                nbTour = 0;
            }
            
            game = this.verifierFinPartie(terrain, joueur1, joueur2);
            
            this.synchronizeSecondInterfaceHistorique(historiquePanel, secondHistoriquePanel);
            
            secondaryPanel.repaint();
            
            JOptionPane.showMessageDialog(null, message, "Fin du tour", JOptionPane.INFORMATION_MESSAGE);                  
        }
        
        message = "Le sorcier "+gagnant.getNom()+" est vainqueur !";
        JOptionPane.showMessageDialog(null, message, "Fin de partie", JOptionPane.INFORMATION_MESSAGE);
        if(gagnant!=null){
            db.insertTuples(gagnant.getNom(), gagnant.getCouleur());
        }
        
        j2Wind.dispose();
        
        this.remove(mainPanel);  //remove panel to reset game
        this.repaint();   //update frame
        
        startButton.setVisible(true);
        multipleWindowsButton.setVisible(true);
    }//GEN-LAST:event_multipleWindowsButtonMouseClicked

    private void highScoreButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_highScoreButtonMouseClicked
        
        ArrayList<String> data = new ArrayList<>();
        BDD db = new BDD();
        String message = "";
        
        data = db.getTuples();
        
        for(int i=0;i<data.size();i++){
            message+=data.get(i)+"\n";
        }
        
        JOptionPane.showMessageDialog(this, message, "High Score", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_highScoreButtonMouseClicked

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
    private javax.swing.JButton highScoreButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton multipleWindowsButton;
    private javax.swing.JMenuItem new_game;
    private javax.swing.JFrame popup;
    private javax.swing.JMenuItem quit;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
    JLabel[] pontInterface = new JLabel[19];
    JLabel[] positionInterface = new JLabel[19];
}
