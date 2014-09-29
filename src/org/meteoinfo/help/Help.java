/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteoinfo.help;

import java.net.URL;
import javax.help.HelpSet;
import javax.help.JHelp;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author yaqiang
 */
public class Help extends JFrame{

    JHelp helpViewer = null;

    public Help() {
        try {
            ClassLoader cl = Help.class.getClassLoader();
            URL hsURL = this.getClass().getResource("mi.hs");
            HelpSet hs = new HelpSet(cl, hsURL);
            //URL url = HelpSet.findHelpSet(cl, "mi.hs");
            helpViewer = new JHelp(hs);
            helpViewer.setCurrentID("top");
        } catch (Exception e) {
            System.err.println("API Help Set not found");
        }

        this.getContentPane().add(helpViewer);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
    }

    public void setIconImage(String imagePath) {
        this.setIconImage(new ImageIcon(getClass().getResource(imagePath)).getImage());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Help();
            }
        });
    }
}
