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
import java.util.ArrayList;
import utilitaire.UtilDate;

/**
 *
 * @author mbola
 */
public class Conge {
    private long ID_CONGE;
    private long ID_DEMANDE_CONGE;
    private long ID_EMPLOYER;
    private String DATE_REPONSE_DEMANDE;
    private String MOTIF_CONGE;
    private String DATE_DEPART_CONGE;
    private String HEURE_DEPART_CONGE;
    private String DATE_RETOUR_CONGE;
    private String HEURE_RETOUR_CONGE;

    public long getID_CONGE() {
        return ID_CONGE;
    }

    public void setID_CONGE(long ID_CONGE) {
        this.ID_CONGE = ID_CONGE;
    }

    public long getID_DEMANDE_CONGE() {
        return ID_DEMANDE_CONGE;
    }

    public void setID_DEMANDE_CONGE(long ID_DEMANDE_CONGE) {
        this.ID_DEMANDE_CONGE = ID_DEMANDE_CONGE;
    }

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public String getDATE_REPONSE_DEMANDE() {
        return DATE_REPONSE_DEMANDE;
    }

    public void setDATE_REPONSE_DEMANDE(String DATE_REPONSE_DEMANDE) {
        this.DATE_REPONSE_DEMANDE = DATE_REPONSE_DEMANDE;
    }

    public String getMOTIF_CONGE() {
        return MOTIF_CONGE;
    }

    public void setMOTIF_CONGE(String MOTIF_CONGE) {
        this.MOTIF_CONGE = MOTIF_CONGE;
    }

    public String getDATE_DEPART_CONGE() {
        return DATE_DEPART_CONGE;
    }

    public void setDATE_DEPART_CONGE(String DATE_DEPART_CONGE) {
        this.DATE_DEPART_CONGE = DATE_DEPART_CONGE;
    }

    public String getHEURE_DEPART_CONGE() {
        return HEURE_DEPART_CONGE;
    }

    public void setHEURE_DEPART_CONGE(String HEURE_DEPART_CONGE) {
        this.HEURE_DEPART_CONGE = HEURE_DEPART_CONGE;
    }

    public String getDATE_RETOUR_CONGE() {
        return DATE_RETOUR_CONGE;
    }

    public void setDATE_RETOUR_CONGE(String DATE_RETOUR_CONGE) {
        this.DATE_RETOUR_CONGE = DATE_RETOUR_CONGE;
    }

    public String getHEURE_RETOUR_CONGE() {
        return HEURE_RETOUR_CONGE;
    }

    public void setHEURE_RETOUR_CONGE(String HEURE_RETOUR_CONGE) {
        this.HEURE_RETOUR_CONGE = HEURE_RETOUR_CONGE;
    }

    public Conge(long ID_CONGE, long ID_DEMANDE_CONGE, long ID_EMPLOYER, String DATE_REPONSE_DEMANDE, String MOTIF_CONGE, String DATE_DEPART_CONGE, String HEURE_DEPART_CONGE, String DATE_RETOUR_CONGE, String HEURE_RETOUR_CONGE) {
        this.setID_CONGE(ID_CONGE);
        this.setID_DEMANDE_CONGE(ID_DEMANDE_CONGE);
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setDATE_REPONSE_DEMANDE(DATE_REPONSE_DEMANDE);
        this.setMOTIF_CONGE(MOTIF_CONGE);
        this.setDATE_DEPART_CONGE(DATE_DEPART_CONGE);
        this.setHEURE_DEPART_CONGE(HEURE_DEPART_CONGE);
        this.setDATE_RETOUR_CONGE(DATE_RETOUR_CONGE);
        this.setHEURE_RETOUR_CONGE(HEURE_RETOUR_CONGE);
    }
    public Conge getDernierCongeValider(long id) throws Exception {
        Connection c = Oracle.getConnection();
        Conge reponse = null;
        String sql = "select * from conge_valider where DATE_RETOUR_CONGE=(select max(DATE_RETOUR_CONGE) from conge_valider) and HEURE_RETOUR_CONGE=(select max(HEURE_RETOUR_CONGE) and id_employer="+id+ "from conge_valider)";
        ResultSet rs = c.createStatement().executeQuery(sql);
        if(rs==null) {
            return reponse;
        }
        while(rs.next()) {
            reponse = new Conge(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getDate(4).toString(),rs.getString(5),rs.getDate(6).toString(),rs.getString(7),rs.getDate(8).toString(),rs.getString(9));
        }
        return reponse;
    }
    public static long getIdCongeValider() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from conge_valider");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    public static long getIdCongeRejetter() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from conge_rejetter");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    public boolean mbolaConge(long id,String dt_debut,String hr_debut) throws Exception {
        Conge conge = getDernierCongeValider(id);
        return UtilDate.temps_diff(dt_debut, hr_debut, conge.DATE_RETOUR_CONGE, conge.HEURE_RETOUR_CONGE)<0;
    }
    public boolean validerConge(DemandeConge demande_conge) throws Exception {
        Conge conge = new Conge(getIdCongeValider(),demande_conge.getID_DEMANDE_CONGE(),demande_conge.getID_EMPLOYER(),UtilDate.getDatezao(),demande_conge.getMOTIF_CONGE(),demande_conge.getDATE_DEPART_CONGE(),demande_conge.getHEURE_DEPART_CONGE(),demande_conge.getDATE_RETOUR_CONGE(),demande_conge.getHEURE_RETOUR_CONGE());
        Connection c = Oracle.getConnection();
        int reponse = 0;
        String sql = "insert into conge_valider values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_CONGE);
        ps.setLong(2, this.ID_DEMANDE_CONGE);
        ps.setLong(3, this.ID_EMPLOYER);
        ps.setString(4, this.DATE_REPONSE_DEMANDE);
        ps.setString(5, this.MOTIF_CONGE);
        ps.setString(6, this.DATE_DEPART_CONGE);
        ps.setString(7, this.HEURE_DEPART_CONGE);
        ps.setString(8, this.DATE_RETOUR_CONGE);
        ps.setString(9, this.HEURE_RETOUR_CONGE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public boolean rejetterConge(DemandeConge demande_conge) throws Exception {
        Conge conge = new Conge(getIdCongeRejetter(),demande_conge.getID_DEMANDE_CONGE(),demande_conge.getID_EMPLOYER(),UtilDate.getDatezao(),demande_conge.getMOTIF_CONGE(),demande_conge.getDATE_DEPART_CONGE(),demande_conge.getHEURE_DEPART_CONGE(),demande_conge.getDATE_RETOUR_CONGE(),demande_conge.getHEURE_RETOUR_CONGE());
        Connection c = Oracle.getConnection();
        int reponse = 0;
        String sql = "insert into conge_rejetter values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_CONGE);
        ps.setLong(2, this.ID_DEMANDE_CONGE);
        ps.setLong(3, this.ID_EMPLOYER);
        ps.setString(4, this.DATE_REPONSE_DEMANDE);
        ps.setString(5, this.MOTIF_CONGE);
        ps.setString(6, this.DATE_DEPART_CONGE);
        ps.setString(7, this.HEURE_DEPART_CONGE);
        ps.setString(8, this.DATE_RETOUR_CONGE);
        ps.setString(9, this.HEURE_RETOUR_CONGE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static Conge[] getCongeValider() throws Exception {
        ArrayList<Conge> arr_conge = new ArrayList<Conge>();
        Connection c = Oracle.getConnection();
        ResultSet rs = c.createStatement().executeQuery("select * from conge_valider");
        while(rs.next()) {
            arr_conge.add(new Conge(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getDate(4).toString(),rs.getString(5),rs.getDate(6).toString(),rs.getString(7),rs.getDate(8).toString(),rs.getString(9)));
        }
        return (Conge[])arr_conge.toArray();
        
    }
    public static Conge[] getCongeRejetter() throws Exception {
        ArrayList<Conge> arr_conge = new ArrayList<Conge>();
        Connection c = Oracle.getConnection();
        ResultSet rs = c.createStatement().executeQuery("select * from conge_rejetter");
        while(rs.next()) {
            arr_conge.add(new Conge(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getDate(4).toString(),rs.getString(5),rs.getDate(6).toString(),rs.getString(7),rs.getDate(8).toString(),rs.getString(9)));
        }
        return (Conge[])arr_conge.toArray();
        
    }
    
}
