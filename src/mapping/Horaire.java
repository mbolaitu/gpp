/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import db.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mbola
 */
public class Horaire {
    private long ID_HORAIRE;
    private long ID_EMPLOYER;
    private String HEURE_ENTREE;
    private String HEURE_SORTIE;
    private String HEURE_DEBUT_PAUSE;
    private String HEURE_FIN_PAUSE;

    public long getID_HORAIRE() {
        return ID_HORAIRE;
    }

    public void setID_HORAIRE(long ID_HORAIRE) {
        this.ID_HORAIRE = ID_HORAIRE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public String getHEURE_ENTREE() {
        return HEURE_ENTREE;
    }

    public void setHEURE_ENTREE(String HEURE_ENTREE) {
        this.HEURE_ENTREE = HEURE_ENTREE;
    }

    public String getHEURE_SORTIE() {
        return HEURE_SORTIE;
    }

    public void setHEURE_SORTIE(String HEURE_SORTIE) {
        this.HEURE_SORTIE = HEURE_SORTIE;
    }

    public String getHEURE_DEBUT_PAUSE() {
        return HEURE_DEBUT_PAUSE;
    }

    public void setHEURE_DEBUT_PAUSE(String HEURE_DEBUT_PAUSE) {
        this.HEURE_DEBUT_PAUSE = HEURE_DEBUT_PAUSE;
    }

    public String getHEURE_FIN_PAUSE() {
        return HEURE_FIN_PAUSE;
    }

    public void setHEURE_FIN_PAUSE(String HEURE_FIN_PAUSE) {
        this.HEURE_FIN_PAUSE = HEURE_FIN_PAUSE;
    }

    public Horaire(long ID_HORAIRE, long ID_EMPLOYER, String HEURE_ENTREE, String HEURE_SORTIE, String HEURE_DEBUT_PAUSE, String HEURE_FIN_PAUSE) {
        this.setID_HORAIRE(ID_HORAIRE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setHEURE_ENTREE(HEURE_ENTREE);
        this.setHEURE_SORTIE(HEURE_SORTIE);
        this.setHEURE_DEBUT_PAUSE(HEURE_DEBUT_PAUSE);
        this.setHEURE_FIN_PAUSE(HEURE_FIN_PAUSE);
    }
    public boolean setHoraire() throws Exception {
        int reponse = 0;
        String sql = "insert into horaire values (?, ?, ?, ?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_HORAIRE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setString(3, this.HEURE_ENTREE);
        ps.setString(4, this.HEURE_SORTIE);
        ps.setString(5 , this.HEURE_DEBUT_PAUSE);
        ps.setString(6, this.HEURE_FIN_PAUSE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdHoraire() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from horaire");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    
}
