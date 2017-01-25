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
public class PointageSortie {
    private long ID_POINTAGE_SORTIE;
    private long ID_EMPLOYER;
    private String DATE_POINTAGE_SORTIE;
    private String HEURE_SORTIE;

    public long getID_POINTAGE_SORTIE() {
        return ID_POINTAGE_SORTIE;
    }

    public void setID_POINTAGE_SORTIE(long ID_POINTAGE_SORTIE) {
        this.ID_POINTAGE_SORTIE = ID_POINTAGE_SORTIE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public String getDATE_POINTAGE_SORTIE() {
        return DATE_POINTAGE_SORTIE;
    }

    public void setDATE_POINTAGE_SORTIE(String DATE_POINTAGE_SORTIE) {
        this.DATE_POINTAGE_SORTIE = DATE_POINTAGE_SORTIE;
    }

    public String getHEURE_SORTIE() {
        return HEURE_SORTIE;
    }

    public void setHEURE_SORTIE(String HEURE_SORTIE) {
        this.HEURE_SORTIE = HEURE_SORTIE;
    }

    public PointageSortie(long ID_POINTAGE_SORTIE, long ID_EMPLOYER, String DATE_POINTAGE_SORTIE, String HEURE_SORTIE) {
        this.setID_POINTAGE_SORTIE(ID_POINTAGE_SORTIE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setDATE_POINTAGE_SORTIE(DATE_POINTAGE_SORTIE);
        this.setHEURE_SORTIE(HEURE_SORTIE);
    }
    public boolean setPointageSortie() throws Exception {
        int reponse = 0;
        String sql = "insert into pointage_sortie values (?, ?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_POINTAGE_SORTIE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setString(3, this.DATE_POINTAGE_SORTIE);
        ps.setString(4, this.HEURE_SORTIE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdPointageSortie() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from pointage_sortie");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    
}
