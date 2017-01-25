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
public class Entree_poste_service {
    private long ID_ENTREE_POSTE_SERVICE;
    private long ID_EMPLOYER;
    private long ID_POSTE;
    private long ID_SERVICE;
    private String DATE_ENTREE_POSTE_SERVICE;

    public long getID_ENTREE_POSTE_SERVICE() {
        return ID_ENTREE_POSTE_SERVICE;
    }

    public void setID_ENTREE_POSTE_SERVICE(long ID_ENTREE_POSTE_SERVICE) {
        this.ID_ENTREE_POSTE_SERVICE = ID_ENTREE_POSTE_SERVICE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public long getID_POSTE() {
        return ID_POSTE;
    }

    public void setID_POSTE(long ID_POSTE) {
        this.ID_POSTE = ID_POSTE;
    }

    public long getID_SERVICE() {
        return ID_SERVICE;
    }

    public void setID_SERVICE(long ID_SERVICE) {
        this.ID_SERVICE = ID_SERVICE;
    }

    public String getDATE_ENTREE_POSTE_SERVICE() {
        return DATE_ENTREE_POSTE_SERVICE;
    }

    public void setDATE_ENTREE_POSTE_SERVICE(String DATE_ENTREE_POSTE_SERVICE) {
        this.DATE_ENTREE_POSTE_SERVICE = DATE_ENTREE_POSTE_SERVICE;
    }

    public Entree_poste_service(long ID_ENTREE_POSTE_SERVICE, long ID_EMPLOYER, long ID_POSTE, long ID_SERVICE, String DATE_ENTREE_POSTE_SERVICE) {
        this.setID_ENTREE_POSTE_SERVICE(ID_ENTREE_POSTE_SERVICE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setID_POSTE(ID_POSTE);
        this.setID_SERVICE(ID_SERVICE);
        this.setDATE_ENTREE_POSTE_SERVICE(DATE_ENTREE_POSTE_SERVICE);
    }
    public boolean setEntre_poste_service() throws Exception {
        int reponse = 0;
        String sql = "insert into entree_poste_service values (?, ?, ?, ?, ?)";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_ENTREE_POSTE_SERVICE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setLong(3, this.ID_POSTE);
        ps.setLong(4, this.ID_SERVICE);
        ps.setString(5, this.DATE_ENTREE_POSTE_SERVICE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdEntree_poste_service() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from entree_poste_service");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
}
