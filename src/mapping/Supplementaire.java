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
public class Supplementaire {
    private long ID_SUPPLEMENTAIRE;
    private long ID_EMPLOYER;
    private long ID_POINTAGE_SORTIE;
    private String HEURE_SUPPLEMENTAIRE;

    public long getID_SUPPLEMENTAIRE() {
        return ID_SUPPLEMENTAIRE;
    }

    public void setID_SUPPLEMENTAIRE(long ID_SUPPLEMENTAIRE) {
        this.ID_SUPPLEMENTAIRE = ID_SUPPLEMENTAIRE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public long getID_POINTAGE_SORTIE() {
        return ID_POINTAGE_SORTIE;
    }

    public void setID_POINTAGE_SORTIE(long ID_POINTAGE_SORTIE) {
        this.ID_POINTAGE_SORTIE = ID_POINTAGE_SORTIE;
    }

    public String getHEURE_SUPPLEMENTAIRE() {
        return HEURE_SUPPLEMENTAIRE;
    }

    public void setHEURE_SUPPLEMENTAIRE(String HEURE_SUPPLEMENTAIRE) {
        this.HEURE_SUPPLEMENTAIRE = HEURE_SUPPLEMENTAIRE;
    }

    public Supplementaire(long ID_SUPPLEMENTAIRE, long ID_EMPLOYER, long ID_POINTAGE_SORTIE, String HEURE_SUPPLEMENTAIRE) {
        this.setID_SUPPLEMENTAIRE(ID_SUPPLEMENTAIRE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setID_POINTAGE_SORTIE(ID_POINTAGE_SORTIE);
        this.setHEURE_SUPPLEMENTAIRE(HEURE_SUPPLEMENTAIRE);
    }
    public boolean setSupplementaire() throws Exception {
        int reponse = 0;
        String sql = "insert into retard values (?, ?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_SUPPLEMENTAIRE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setLong(3, this.ID_POINTAGE_SORTIE);
        ps.setString(4, this.HEURE_SUPPLEMENTAIRE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdSupplementaire() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from supplementaire");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    
}
