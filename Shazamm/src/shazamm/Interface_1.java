/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package shazamm;

import javax.swing.ImageIcon;

/**
 *
 * @author nomnelle
 */
public class Interface extends javax.swing.JFrame {

    String chemin = "";

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    public void ecrouler() {  //fonction modélisant l'écroulement du pont //on change quand on en a besoin rather vérification
        for (int i = 0; i < Terrain.tabPont.length; i++) { // accès privé mais besoin de l'utiliser
            if (Terrain.tabPont[i] == true) {  //la première case ayant la valeur true (pas encore écroulée)
                Terrain.tabPont[i] = false;  // s'écroulent 
                //On remplace la case par l'image de lave // écrouke pont on change directement l'image à la place de vérifier
                if (i == 0) {
                    pont1.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_01.gif"));
                } else if (i == 1) {
                    pont2.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_02.gif"));
                } else if (i == 2) {
                    pont3.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_03.gif"));
                } else if (i == 3) {
                    pont4.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_04.gif"));
                } else if (i == 4) {
                    pont5.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_05.gif"));
                } else if (i == 5) {
                    pont6.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_06.gif"));
                } else if (i == 6) {
                    pont7.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_07.gif"));
                } else if (i == 7) {
                    pont8.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_08.gif"));
                } else if (i == 8) {
                    pont9.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_09.gif"));
                } else if (i == 9) {
                    pont10.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_10.gif"));
                }

                break;  //et on sort de la boucle 
            }
        }
        for (int i = Terrain.tabPont.length - 1; i > 0; i--) {  //cette fois on part de la fin du tableau
            if (Terrain.tabPont[i] == true) {  //première case pas écroulée 
                Terrain.tabPont[i] = false;  //s'écroulent 
                if (i == 18) {
                    pont19.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_19.gif"));
                } else if (i == 17) {
                    pont18.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_18.gif"));
                } else if (i == 16) {
                    pont17.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_17.gif"));
                } else if (i == 15) {
                    pont16.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_16.gif"));
                } else if (i == 14) {
                    pont15.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_15.gif"));
                } else if (i == 13) {
                    pont14.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_14.gif"));
                } else if (i == 12) {
                    pont13.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_13.gif"));
                } else if (i == 11) {
                    pont12.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_12.gif"));
                } else if (i == 10) {
                    pont11.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\lave\\lave_11.gif"));

                    break;  //et on sort de la bouche 
                }
            }
        }
        //Classe Brasier
    public void effet(Terrain t, Sorcier j1, Sorcier j2) {  //fait que le feu se déplace de deux cases au lieu d'une 
        if (t.getSort()) {  //si le joueur peut lancer un sort
            mur_feu.setIcon(new ImageIcon(chemin = ""));//ou mur_feu.setText("");
            //Cas où le mur de feu se déplace vers le sorcier vert, donc vers la droite
            if (t.getNbCaseDeplacement() == 1) {  //cas normal 
                t.setNbCaseDeplacement(t.getNbCaseDeplacement() + 1);  //le feu se déplacera de 2
                feu_droite.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feudroite.gif"));
                //Cas où le mur de feu se déplace vers le sorcier rouge, donc vers la gauche
            } else if (t.getNbCaseDeplacement() == -1) {  //cas où le sort "Qui perd gagne" a été lancé 
                t.setNbCaseDeplacement(t.getNbCaseDeplacement() - 1);
                feu_gauche.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feugauche.gif"));
            }
            //Classe Resistance
            t.setNbCaseDeplacement(0); //empêche le feu de se déplacer
            if (Terrain.positionFeu == 10) {
                feu_droite.setIcon(new ImageIcon(chemin = ""));
                feu_gauche.setIcon(new ImageIcon(chemin = ""));
                mur_feu.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feu.gif"));
            } else if (Terrain.positionFeu == Interface_1.feu_droite) {
                feu_droite.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feudroite.gif"));
                feu_gauche.setIcon(new ImageIcon(chemin = ""));
                mur_feu.setIcon(new ImageIcon(chemin = ""));
            } else if (Terrain.positionFeu == Interface_1.feu_gauche) {
                feu_droite.setIcon(new ImageIcon(chemin = ""));
                feu_gauche.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feugauche.gif"));
                mur_feu.setIcon(new ImageIcon(chemin = ""));
            }
            // Classe Harpagon seul le cas du joueur  est traité
            if (Interface_1.feu_gauche == Sorcier.position) {
                sorcier_rouge.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feugauche.gif"));
                j1.setMise(0); //passe la mise du joueur à 0, si le joueur perd le tour
            }
            // Classe PerdGagne
            t.setNbCaseDeplacement(-t.getNbCaseDeplacement()); //le gagnant verra le feu avancer vers lui
            // Cas où le sorcier rouge gagne
            sorcier_rouge.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feugauche.gif"));
            // Cas où le sorcier vert gagne
            sorcier_vert.setIcon(new ImageIcon(chemin = "C:\\Users\\npnoi\\Documents\\NetBeansProjects\\Graphisme\\src\\images-shazamm(1)\\img\\perso\\feudroite.gif"));

            // Classe Milieu
            if (j1.getPosition() < t.getPositionFeu()) {  //si le joueur 1 lance le sort 
                t.setPositionFeu(j1.getPosition() + 3);

            } else {  //si le joueur 2 lance le sort 
                t.setPositionFeu(j1.getPosition() - 3);
            }
        }

        if (j1.getPosition() < t.getPositionFeu()) {  //si c'est le joueur 1 qui joue le sort 
            j1.setPosition(t.getPositionFeu() - 3);
            j2.setPosition(t.getPositionFeu() + 3);
        } else {  //si c'est le joueur 2 qui joue le sort 
            j1.setPosition(t.getPositionFeu() + 3);
            j2.setPosition(t.getPositionFeu() - 3);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        historique = new javax.swing.JTextField();
        pont6 = new javax.swing.JLabel();
        pont13 = new javax.swing.JLabel();
        pont19 = new javax.swing.JLabel();
        pont15 = new javax.swing.JLabel();
        pont14 = new javax.swing.JLabel();
        pont16 = new javax.swing.JLabel();
        pont11 = new javax.swing.JLabel();
        pont17 = new javax.swing.JLabel();
        pont12 = new javax.swing.JLabel();
        pont18 = new javax.swing.JLabel();
        pont3 = new javax.swing.JLabel();
        pont1 = new javax.swing.JLabel();
        pont2 = new javax.swing.JLabel();
        pont5 = new javax.swing.JLabel();
        pont9 = new javax.swing.JLabel();
        pont10 = new javax.swing.JLabel();
        pont8 = new javax.swing.JLabel();
        pont4 = new javax.swing.JLabel();
        pont7 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        sorcier_rouge = new javax.swing.JLabel();
        sorcier_vert = new javax.swing.JLabel();
        mur_feu = new javax.swing.JLabel();
        feu_droite = new javax.swing.JLabel();
        feu_gauche = new javax.swing.JLabel();
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

        historique.setBackground(new java.awt.Color(204, 102, 255));
        historique.setText("Historique");

        pont6.setText("jLabel1");

        pont13.setText("jLabel1");

        pont19.setText("jLabel1");

        pont15.setText("jLabel1");

        pont14.setText("jLabel1");

        pont16.setText("jLabel1");

        pont11.setText("jLabel1");

        pont17.setText("jLabel1");

        pont12.setText("jLabel1");

        pont18.setText("jLabel1");

        pont3.setText("jLabel1");

        pont1.setText("jLabel1");

        pont2.setText("jLabel1");

        pont5.setText("jLabel1");

        pont9.setText("jLabel1");

        pont10.setText("jLabel1");

        pont8.setText("jLabel1");

        pont4.setText("jLabel1");

        pont7.setText("jLabel1");

        start.setText("Start");
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        sorcier_rouge.setText("Sorcier rouge");

        sorcier_vert.setText("Sorcier vert");

        mur_feu.setText("Mur de feu");

        feu_droite.setText("Feu droite");

        feu_gauche.setText("Feu gauche");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historique, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pont1)
                        .addGap(31, 31, 31)
                        .addComponent(pont2)
                        .addGap(48, 48, 48)
                        .addComponent(pont3)
                        .addGap(30, 30, 30)
                        .addComponent(pont4))
                    .addComponent(start))
                .addGap(27, 27, 27)
                .addComponent(pont5)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sorcier_rouge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pont6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(pont7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(feu_gauche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pont8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pont9)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mur_feu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pont10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pont11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(feu_droite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pont12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pont13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sorcier_vert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pont14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pont15)
                .addGap(18, 18, 18)
                .addComponent(pont16)
                .addGap(18, 18, 18)
                .addComponent(pont17)
                .addGap(18, 18, 18)
                .addComponent(pont18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pont19)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(historique))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1645, 1645, 1645)
                        .addComponent(start)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sorcier_vert, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mur_feu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feu_droite, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feu_gauche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pont1)
                                    .addComponent(pont2)
                                    .addComponent(pont3)
                                    .addComponent(pont4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pont5)
                                    .addComponent(pont6)
                                    .addComponent(pont7)
                                    .addComponent(pont8)
                                    .addComponent(pont9)
                                    .addComponent(pont10)
                                    .addComponent(pont11)
                                    .addComponent(pont12)
                                    .addComponent(pont13)
                                    .addComponent(pont14)
                                    .addComponent(pont15)
                                    .addComponent(pont19)
                                    .addComponent(pont16)
                                    .addComponent(pont17)
                                    .addComponent(pont18)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(sorcier_rouge, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1932, Short.MAX_VALUE)))
                .addContainerGap())
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
        // TODO add your handling code here:
        //Implantation d'images des 19 morceaux du pont non dynamique
        pont1.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_01.gif"));
        pont2.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_02.gif"));
        pont3.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_03.gif"));
        pont4.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_04.gif"));
        pont5.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_05.gif"));
        pont6.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_06.gif"));
        pont7.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_07.gif"));
        pont8.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_08.gif"));
        pont9.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_09.gif"));
        pont10.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_10.gif"));
        pont11.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_11.gif"));
        pont12.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_12.gif"));
        pont13.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_13.gif"));
        pont14.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_14.gif"));
        pont15.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_15.gif"));
        pont16.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_16.gif"));
        pont17.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_17.gif"));
        pont18.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_18.gif"));
        pont19.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\pont\\pont_19.gif"));

        sorcier_rouge.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\perso\\rouge.gif"));
        sorcier_vert.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\perso\\vert.gif"));

        // il y a 3 types de feu le feu initial, un feu allant vers la droite et un feu allant vers la gauche donc 3 jLabels de feu
        mur_feu.setIcon(new ImageIcon(chemin = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Shazamm_autre\\src\\shazamm\\images-shazamm(1)\\img\\perso\\feu.gif"));

    }//GEN-LAST:event_startMouseClicked

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        boolean b = popup.requestFocusInWindow();
        // demande le focus sur la nouvelle fenêtre
        popup.pack();
        // redimensionne la fenêtre popup
        popup.setVisible(true);
        // rend la fenêtre visible

    }//GEN-LAST:event_startActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JLabel feu_droite;
    private javax.swing.JLabel feu_gauche;
    private javax.swing.JMenu help;
    private javax.swing.JTextField historique;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mur_feu;
    private javax.swing.JMenuItem new_game;
    private javax.swing.JLabel pont1;
    private javax.swing.JLabel pont10;
    private javax.swing.JLabel pont11;
    private javax.swing.JLabel pont12;
    private javax.swing.JLabel pont13;
    private javax.swing.JLabel pont14;
    private javax.swing.JLabel pont15;
    private javax.swing.JLabel pont16;
    private javax.swing.JLabel pont17;
    private javax.swing.JLabel pont18;
    private javax.swing.JLabel pont19;
    private javax.swing.JLabel pont2;
    private javax.swing.JLabel pont3;
    private javax.swing.JLabel pont4;
    private javax.swing.JLabel pont5;
    private javax.swing.JLabel pont6;
    private javax.swing.JLabel pont7;
    private javax.swing.JLabel pont8;
    private javax.swing.JLabel pont9;
    private javax.swing.JFrame popup;
    private javax.swing.JMenuItem quit;
    private javax.swing.JLabel sorcier_rouge;
    private javax.swing.JLabel sorcier_vert;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
