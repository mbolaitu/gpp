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
public class Retard {
    private long ID_RETARD;
    private long ID_EMPLOYER;
    private long ID_POINTAGE_ENTREE;
    private String HEURE_RETARD;

    public long getID_RETARD() {
        return ID_RETARD;
    }

    public void setID_RETARD(long ID_RETARD) {
        this.ID_RETARD = ID_RETARD;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public long getID_POINTAGE_ENTREE() {
        return ID_POINTAGE_ENTREE;
    }

    public void setID_POINTAGE_ENTREE(long ID_POINTAGE_ENTREE) {
        this.ID_POINTAGE_ENTREE = ID_POINTAGE_ENTREE;
    }

    public String getHEURE_RETARD() {
        return HEURE_RETARD;
    }

    public void setHEURE_RETARD(String HEURE_RETARD) {
        this.HEURE_RETARD = HEURE_RETARD;
    }

    public Retard(long ID_RETARD, long ID_EMPLOYER, long ID_POINTAGE_ENTREE, String HEURE_RETARD) {
        this.ID_RETARD = ID_RETARD;
        this.ID_EMPLOYER = ID_EMPLOYER;
        this.ID_POINTAGE_ENTREE = ID_POINTAGE_ENTREE;
        this.HEURE_RETARD = HEURE_RETARD;
    }
    public boolean setAbsence() throws Exception {
        int reponse = 0;
        String sql = "insert into retard values (?, ?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_RETARD);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setLong(3, this.ID_POINTAGE_ENTREE);
        ps.setString(4, this.HEURE_RETARD);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdRetard() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from retard");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
}
