/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TavoloGUI.java
 *
 * Created on 16-mar-2011, 9.52.06
 */

package Grafica;

import Gioco.*;

/**
 *
 * @author Luca
 */
public class TavoloGUI extends javax.swing.JFrame {

    /** Creates new form TavoloGUI */
    public TavoloGUI() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sfondo = new Sfondo("images/panno.png");
        steccaGiu = new Stecca(Costanti.GIU);
        steccaSinistra = new Stecca(Costanti.SINISTRA);
        steccaSu = new Stecca(Costanti.SU);
        steccaDestra = new Stecca(Costanti.DESTRA);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sfondo.setPreferredSize(new java.awt.Dimension(1024, 768));

        steccaGiu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steccaGiu.setOpaque(false);
        steccaGiu.setLayout(new java.awt.GridLayout(1, 14));

        steccaSinistra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steccaSinistra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        steccaSinistra.setMaximumSize(new java.awt.Dimension(5, 5));
        steccaSinistra.setOpaque(false);
        steccaSinistra.setLayout(new java.awt.GridLayout(14, 1));

        steccaSu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steccaSu.setOpaque(false);
        steccaSu.setLayout(new java.awt.GridLayout(1, 14));

        steccaDestra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steccaDestra.setMaximumSize(new java.awt.Dimension(200, 700));
        steccaDestra.setOpaque(false);
        steccaDestra.setLayout(new java.awt.GridLayout(14, 1));

        javax.swing.GroupLayout sfondoLayout = new javax.swing.GroupLayout(sfondo);
        sfondo.setLayout(sfondoLayout);
        sfondoLayout.setHorizontalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(steccaSinistra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(steccaSu, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sfondoLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(steccaGiu, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(steccaDestra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        sfondoLayout.setVerticalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                .addContainerGap(615, Short.MAX_VALUE)
                .addComponent(steccaGiu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(sfondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(steccaDestra, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(steccaSinistra, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                            .addComponent(steccaSu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(397, 397, 397))))
                .addGap(108, 108, 108))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TavoloGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel sfondo;
    private javax.swing.JPanel steccaDestra;
    private javax.swing.JPanel steccaGiu;
    private javax.swing.JPanel steccaSinistra;
    private javax.swing.JPanel steccaSu;
    // End of variables declaration//GEN-END:variables

}