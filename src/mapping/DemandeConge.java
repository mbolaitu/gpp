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
import utilitaire.UtilDate;

/**
 *
 * @author mbola
 */
public class DemandeConge {
    private long ID_DEMANDE_CONGE;
    private long ID_EMPLOYER;
    private String DATE_SAISIE_DEMANDE;
    private String MOTIF_CONGE;
    private String DATE_DEPART_CONGE;
    private String HEURE_DEPART_CONGE;
    private String DATE_RETOUR_CONGE;
    private String HEURE_RETOUR_CONGE;

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

    public String getDATE_SAISIE_DEMANDE() {
        return DATE_SAISIE_DEMANDE;
    }

    public void setDATE_SAISIE_DEMANDE(String DATE_SAISIE_DEMANDE) {
        
        this.DATE_SAISIE_DEMANDE = UtilDate.date_format(DATE_SAISIE_DEMANDE);
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
        this.DATE_DEPART_CONGE = UtilDate.date_format(DATE_DEPART_CONGE);
    }

    public String getHEURE_DEPART_CONGE() {
        return HEURE_DEPART_CONGE;
    }

    public void setHEURE_DEPART_CONGE(String HEURE_DEPART_CONGE) {
        this.HEURE_DEPART_CONGE = UtilDate.heure_format(HEURE_DEPART_CONGE);
    }

    public String getDATE_RETOUR_CONGE() {
        return DATE_RETOUR_CONGE;
    }

    public void setDATE_RETOUR_CONGE(String DATE_RETOUR_CONGE) {
        this.DATE_RETOUR_CONGE = UtilDate.date_format(DATE_RETOUR_CONGE);
    }

    public String getHEURE_RETOUR_CONGE() {
        return HEURE_RETOUR_CONGE;
    }

    public void setHEURE_RETOUR_CONGE(String HEURE_RETOUR_CONGE) {
        this.HEURE_RETOUR_CONGE = UtilDate.heure_format(HEURE_RETOUR_CONGE);
    }

    public DemandeConge(long ID_DEMANDE_CONGE, long ID_EMPLOYER, String DATE_SAISIE_DEMANDE, String MOTIF_CONGE, String DATE_DEPART_CONGE, String HEURE_DEPART_CONGE, String DATE_RETOUR_CONGE, String HEURE_RETOUR_CONGE) throws Exception {
        if(UtilDate.temps_diff(DATE_DEPART_CONGE,HEURE_DEPART_CONGE, DATE_RETOUR_CONGE, HEURE_RETOUR_CONGE)>0) {
            this.setID_DEMANDE_CONGE(ID_DEMANDE_CONGE);
            this.setID_EMPLOYER(ID_EMPLOYER);
            this.setDATE_SAISIE_DEMANDE(DATE_SAISIE_DEMANDE);
            this.setMOTIF_CONGE(MOTIF_CONGE);
            this.setDATE_DEPART_CONGE(DATE_DEPART_CONGE);
            this.setHEURE_DEPART_CONGE(HEURE_DEPART_CONGE);
            this.setDATE_RETOUR_CONGE(DATE_RETOUR_CONGE);
            this.setHEURE_RETOUR_CONGE(HEURE_RETOUR_CONGE);
        }
        else {
            throw new Exception("la duree de conge n'est pas valide");
        }
    }
    public boolean setDemandeConge() throws Exception {
        //Conge.mbolaConge(this.ID_EMPLOYER,this.DATE_DEPART_CONGE,this.HEURE_DEPART_CONGE);
        Connection c = Oracle.getConnection();
        int reponse = 0;
        String sql = "insert into demande_conge values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_DEMANDE_CONGE);
        ps.setLong(2, this.ID_EMPLOYER);
        ps.setString(3, this.DATE_SAISIE_DEMANDE);
        ps.setString(4, this.MOTIF_CONGE);
        ps.setString(5, this.DATE_DEPART_CONGE);
        ps.setString(6, this.HEURE_DEPART_CONGE);
        ps.setString(7, this.DATE_RETOUR_CONGE);
        ps.setString(8, this.HEURE_RETOUR_CONGE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static long getIdDemandeConge() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from demande_conge");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    public static DemandeConge getDemandeCongeById(long id) throws Exception {
        DemandeConge conge = null;
        Connection c = Oracle.getConnection();
        String sql = "select * from demande_conge where id_demande_conge=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception("demande de conger non trouve");
        }
        while(rs.next()) {
            conge = new DemandeConge(rs.getLong(1), rs.getLong(2), rs.getDate(3).toString(), rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getDate(7).toString(), rs.getString(8));
        }
        return conge;
    }
    
}
