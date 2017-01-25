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
public class PointageEntree {
    private long ID_POINTAGE_ENTREE;
    private long ID_EMPLOYER;
    private String DATE_POINTAGE_ENTREE;
    private String HEURE_ENTREE;

    public long getID_POINTAGE_ENTREE() {
        return ID_POINTAGE_ENTREE;
    }

    public void setID_POINTAGE_ENTREE(long ID_POINTAGE_ENTREE) {
        this.ID_POINTAGE_ENTREE = ID_POINTAGE_ENTREE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public String getDATE_POINTAGE_ENTREE() {
        return DATE_POINTAGE_ENTREE;
    }

    public void setDATE_POINTAGE_ENTREE(String DATE_POINTAGE_ENTREE) {
        this.DATE_POINTAGE_ENTREE = DATE_POINTAGE_ENTREE;
    }

    public String getHEURE_ENTREE() {
        return HEURE_ENTREE;
    }

    public void setHEURE_ENTREE(String HEURE_ENTREE) {
        this.HEURE_ENTREE = HEURE_ENTREE;
    }

    
    public PointageEntree(long ID_POINTAGE_ENTREE, long ID_EMPLOYER, String DATE_POINTAGE_ENTREE, String HEURE_ENTREE) {
        this.setID_POINTAGE_ENTREE(ID_POINTAGE_ENTREE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setDATE_POINTAGE_ENTREE(DATE_POINTAGE_ENTREE);
        this.setHEURE_ENTREE(HEURE_ENTREE);
    }
    public boolean setPointageEntree() throws Exception {
        int reponse = 0;
        String sql = "insert into pointage_entree values (?, ?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_POINTAGE_ENTREE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setString(3, this.DATE_POINTAGE_ENTREE);
        ps.setString(4, this.HEURE_ENTREE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdPointageEntree() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from pointage_entree");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    
}
