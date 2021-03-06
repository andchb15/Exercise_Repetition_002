package ex0001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher Andrä
 */
public class WetterWerteGUI extends javax.swing.JFrame
{

    private WetterModell inv = new WetterModell();

    public WetterWerteGUI()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        plEingabe = new javax.swing.JPanel();
        lbTemperatur = new javax.swing.JLabel();
        slTemperatur = new javax.swing.JSlider();
        lbLuftfeuchtigkeit = new javax.swing.JLabel();
        slLuftfeuchtigkeit = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        plAnzeige = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeAnzeige = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        plEingabe.setBorder(javax.swing.BorderFactory.createTitledBorder("Eingabe"));
        plEingabe.setLayout(new java.awt.GridLayout(5, 0));

        lbTemperatur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTemperatur.setText("Temperatur:");
        plEingabe.add(lbTemperatur);

        slTemperatur.setMajorTickSpacing(10);
        slTemperatur.setMaximum(40);
        slTemperatur.setMinimum(-20);
        slTemperatur.setPaintLabels(true);
        slTemperatur.setPaintTicks(true);
        slTemperatur.setValue(0);
        slTemperatur.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onChangeTemp(evt);
            }
        });
        plEingabe.add(slTemperatur);

        lbLuftfeuchtigkeit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLuftfeuchtigkeit.setText("Luftfeuchtigkeit:");
        plEingabe.add(lbLuftfeuchtigkeit);

        slLuftfeuchtigkeit.setMajorTickSpacing(20);
        slLuftfeuchtigkeit.setPaintLabels(true);
        slLuftfeuchtigkeit.setPaintTicks(true);
        slLuftfeuchtigkeit.setValue(0);
        slLuftfeuchtigkeit.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onLuftChanged(evt);
            }
        });
        plEingabe.add(slLuftfeuchtigkeit);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setText("Hinzufügen");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onEinfuegen(evt);
            }
        });
        plEingabe.add(jButton1);

        getContentPane().add(plEingabe);

        plAnzeige.setBorder(javax.swing.BorderFactory.createTitledBorder("Anzeige"));
        plAnzeige.setLayout(new java.awt.BorderLayout());

        listeAnzeige.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listeAnzeige);

        plAnzeige.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(plAnzeige);

        jMenu1.setText("Datei");

        jMenuItem1.setText("Speichern");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onSave(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Laden");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onLoad(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onExit(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onChangeTemp(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onChangeTemp
    {//GEN-HEADEREND:event_onChangeTemp
        int temperatur = slTemperatur.getValue();
        lbTemperatur.setText("Temperatur : " + temperatur + " °C");
    }//GEN-LAST:event_onChangeTemp

    private void onLuftChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onLuftChanged
    {//GEN-HEADEREND:event_onLuftChanged
        int luftfeuchtigkeit = slLuftfeuchtigkeit.getValue();
        lbLuftfeuchtigkeit.setText("Luftfeuchtigkeit : " + luftfeuchtigkeit + " %");
    }//GEN-LAST:event_onLuftChanged

    private void onExit(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onExit
    {//GEN-HEADEREND:event_onExit
        dispose();
    }//GEN-LAST:event_onExit

    private void onSave(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onSave
    {//GEN-HEADEREND:event_onSave
        JFileChooser jfChooser = new JFileChooser();
        int ok = jfChooser.showSaveDialog(this);
        if (ok == APPROVE_OPTION)
        {
            File datei = jfChooser.getSelectedFile();
            try
            {
                inv.save(datei);
            } catch (FileNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Fehler beim Speichern" + ex.getMessage());
            }

        }
    }//GEN-LAST:event_onSave

    private void onLoad(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onLoad
    {//GEN-HEADEREND:event_onLoad
        JFileChooser jfChooser = new JFileChooser();
        int i = jfChooser.showOpenDialog(this);
        if (i == APPROVE_OPTION)
        {
            try
            {
                File datei = jfChooser.getSelectedFile();

                inv.load(datei);
                listeAnzeige.setListData(inv.getWetter());
            } catch (IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Fehler beim Laden" + ex.getMessage());
            }
        }


    }//GEN-LAST:event_onLoad

    private void onEinfuegen(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onEinfuegen
    {//GEN-HEADEREND:event_onEinfuegen
        int temperaturValue = slTemperatur.getValue();
        int luftfeuchtigkeitValue = slLuftfeuchtigkeit.getValue();
        LocalDateTime datum = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM - HH:mm:ss");
        String aktuellesDatum = datum.format(formatter);
        WetterWert w = new WetterWert(temperaturValue, luftfeuchtigkeitValue, aktuellesDatum);
        inv.add(w);
        listeAnzeige.setListData(inv.getWetter());

    }//GEN-LAST:event_onEinfuegen

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(WetterWerteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(WetterWerteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(WetterWerteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(WetterWerteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new WetterWerteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLuftfeuchtigkeit;
    private javax.swing.JLabel lbTemperatur;
    private javax.swing.JList<String> listeAnzeige;
    private javax.swing.JPanel plAnzeige;
    private javax.swing.JPanel plEingabe;
    private javax.swing.JSlider slLuftfeuchtigkeit;
    private javax.swing.JSlider slTemperatur;
    // End of variables declaration//GEN-END:variables
}
