/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecouteur;


import affichage.BarDeMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbola
 */
public class EcouteurMenuBar implements ActionListener,WindowListener {

    private BarDeMenu window ;
    public EcouteurMenuBar(BarDeMenu f)
    {
        this.window=f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand())
        {
            case "Ok":
                break;
        }
        
        if(e.getSource() == window.getPlanComptable()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getFermer()) {
            System.exit(1);
        }
        else if(e.getSource() == window.getPlanTiers()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getLigneCredit()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getEngagement()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getDegagement()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getPaiement()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getBalanceGenerale()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getBalanceAuxilliaire()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == window.getFinexercice()) {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(EcouteurMenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
