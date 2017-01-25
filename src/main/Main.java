package main;
import affichage.FenetrageDemandeConge;
import affichage.FenetrageEmployer;
import affichage.FenetrageListeEmploye;
import db.Oracle;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.UtilDate;

public class Main {

	public static void main(String[] args) {
            try {
                //new FenetrageEmployer().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                /*java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);*/
            }
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        //new FenetrageEmployer().setVisible(true);
                        //new FenetrageListeEmploye().setVisible(true);
                        //new FenetrageDemandeConge().setVisible(true);
                        System.out.println(UtilDate.getDatezao());
                        System.out.println(UtilDate.getHeurezao());
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
	}

}
