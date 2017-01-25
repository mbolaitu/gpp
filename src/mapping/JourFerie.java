/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import db.Oracle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilitaire.UtilDate;

/**
 *
 * @author mbola
 */
public class JourFerie {
    private long ID_JOUR_FERIE;
    private String MOTIF_JOUR_FERIE;
    private String DATE_JOUR_FERIE;
    private String HEURE_DEBUT_JOUR_FERIE;
    private String HEURE_FIN_JOUR_FERIE;

    public long getID_JOUR_FERIE() {
        return ID_JOUR_FERIE;
    }

    public void setID_JOUR_FERIE(long ID_JOUR_FERIE) {
        this.ID_JOUR_FERIE = ID_JOUR_FERIE;
    }

    public String getMOTIF_JOUR_FERIE() {
        return MOTIF_JOUR_FERIE;
    }

    public void setMOTIF_JOUR_FERIE(String MOTIF_JOUR_FERIE) {
        this.MOTIF_JOUR_FERIE = MOTIF_JOUR_FERIE;
    }

    public String getDATE_JOUR_FERIE() {
        return DATE_JOUR_FERIE;
    }

    public void setDATE_JOUR_FERIE(String DATE_JOUR_FERIE) {
        this.DATE_JOUR_FERIE = DATE_JOUR_FERIE;
    }

    public String getHEURE_DEBUT_JOUR_FERIE() {
        return HEURE_DEBUT_JOUR_FERIE;
    }

    public void setHEURE_DEBUT_JOUR_FERIE(String HEURE_DEBUT_JOUR_FERIE) {
        this.HEURE_DEBUT_JOUR_FERIE = HEURE_DEBUT_JOUR_FERIE;
    }

    public String getHEURE_FIN_JOUR_FERIE() {
        return HEURE_FIN_JOUR_FERIE;
    }

    public void setHEURE_FIN_JOUR_FERIE(String HEURE_FIN_JOUR_FERIE) {
        this.HEURE_FIN_JOUR_FERIE = HEURE_FIN_JOUR_FERIE;
    }

    public JourFerie(long ID_JOUR_FERIE, String MOTIF_JOUR_FERIE, String DATE_JOUR_FERIE, String HEURE_DEBUT_JOUR_FERIE, String HEURE_FIN_JOUR_FERIE) {
        this.setID_JOUR_FERIE(ID_JOUR_FERIE);
        this.setMOTIF_JOUR_FERIE(MOTIF_JOUR_FERIE);
        this.setDATE_JOUR_FERIE(DATE_JOUR_FERIE);
        this.setHEURE_DEBUT_JOUR_FERIE(HEURE_DEBUT_JOUR_FERIE);
        this.setHEURE_FIN_JOUR_FERIE(HEURE_FIN_JOUR_FERIE);
    }
    public static long getIdJourFerie() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from jour_ferie");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    public static JourFerie[] getListJourFerie(int annee) throws Exception {
        ArrayList<JourFerie> arr_ferie = new ArrayList<JourFerie>();
        JourFerie [] jr_ferie = null;
        String sql = "select * from jour_ferie where extract(year from DATE_JOUR_FERIE)=?";
        PreparedStatement ps = Oracle.getConnection().prepareStatement(sql);
        ps.setInt(1, annee);
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception("Aucun jour ferie non trouver");
        }
        while(rs.next()) {
            arr_ferie.add(new JourFerie(rs.getLong(1),rs.getString(2),rs.getDate(3).toString(),rs.getString(4),rs.getString(5)));
        }
        if(arr_ferie.size()==0) {
            throw new Exception("Aucun jour ferie non trouver");
        }
        jr_ferie = new JourFerie[arr_ferie.size()];
        for(int i = 0;i<arr_ferie.size();i++) {
            jr_ferie[i] = (JourFerie)arr_ferie.get(i);
        }
        return jr_ferie;
    }
    public static JourFerie andro_fesana(String date) throws Exception {
        JourFerie reponse = null;
        int annee = Integer.parseInt(date.split("-")[2]);
        JourFerie [] list_jf = getListJourFerie(annee);
        for(int i = 0;i<list_jf.length;i++) {
            if(list_jf[i].DATE_JOUR_FERIE.compareToIgnoreCase(date)==0) {
                return list_jf[i];
            }
        }
        return reponse;
    }
}
