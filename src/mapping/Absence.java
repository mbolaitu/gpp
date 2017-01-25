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
public class Absence {
    private long ID_ABSENCE;
    private long ID_EMPLOYER;
    private String DATE_DEBUT_ABSENCE;
    private String DATE_FIN_ABSENCE;

    public long getID_ABSENCE() {
        return ID_ABSENCE;
    }

    public void setID_ABSENCE(long ID_ABSENCE) {
        this.ID_ABSENCE = ID_ABSENCE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public String getDATE_DEBUT_ABSENCE() {
        return DATE_DEBUT_ABSENCE;
    }

    public void setDATE_DEBUT_ABSENCE(String DATE_DEBUT_ABSENCE) {
        this.DATE_DEBUT_ABSENCE = DATE_DEBUT_ABSENCE;
    }

    public String getDATE_FIN_ABSENCE() {
        return DATE_FIN_ABSENCE;
    }

    public void setDATE_FIN_ABSENCE(String DATE_FIN_ABSENCE) {
        this.DATE_FIN_ABSENCE = DATE_FIN_ABSENCE;
    }

    public Absence(long ID_ABSENCE, long ID_EMPLOYER, String DATE_DEBUT_ABSENCE, String DATE_FIN_ABSENCE) {
        this.setID_ABSENCE(ID_ABSENCE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setDATE_DEBUT_ABSENCE(DATE_DEBUT_ABSENCE);
        this.setDATE_FIN_ABSENCE(DATE_FIN_ABSENCE);
    }
    public boolean setAbsence() throws Exception {
        int reponse = 0;
        String sql = "insert into absence values (?, ?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_ABSENCE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setString(3, this.DATE_DEBUT_ABSENCE);
        ps.setString(4, this.DATE_FIN_ABSENCE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdAbsence() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from absence");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    
}
