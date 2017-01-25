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
public class Salaire {
    private long ID_SALAIRE;
    private long ID_EMPLOYER;
    private double SALAIRE_BRUTE;

    public long getID_SALAIRE() {
        return ID_SALAIRE;
    }

    public void setID_SALAIRE(long ID_SALAIRE) {
        this.ID_SALAIRE = ID_SALAIRE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public double getSALAIRE_BRUTE() {
        return SALAIRE_BRUTE;
    }

    public void setSALAIRE_BRUTE(double SALAIRE_BRUTE) {
        this.SALAIRE_BRUTE = SALAIRE_BRUTE;
    }

    public Salaire(long ID_SALAIRE, long ID_EMPLOYER, double SALAIRE_BRUTE) {
        this.setID_SALAIRE(ID_SALAIRE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setSALAIRE_BRUTE(SALAIRE_BRUTE);
    }
    public boolean setSalaire() throws Exception {
        int reponse = 0;
        String sql = "insert into salaire values (?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_SALAIRE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setDouble(3, this.SALAIRE_BRUTE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdSalaire() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from salaire");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
}
