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

/**
 *
 * @author mbola
 */
public class Employer {
    private long ID_EMPLOYER;
    private String MATRICULE;
    private String CIN;
    private String NOM;
    private String PRENOM;
    private String SEXE;
    private String DATE_NAISSANCE;
    private String DATE_EMBAUCHE;

    public long getID_EMPLOYER() {
        return ID_EMPLOYER;
    }

    public void setID_EMPLOYER(long ID_EMPLOYER) {
        this.ID_EMPLOYER = ID_EMPLOYER;
    }

    public String getMATRICULE() {
        return MATRICULE;
    }

    public void setMATRICULE(long ID_EMPLOYER) {
        this.MATRICULE = "emp000"+ID_EMPLOYER;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) throws Exception {
        if(CIN.length()==12) {
            this.CIN = CIN;
        }
        else {
            throw new Exception ("CIN invalide");
        }
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String SEXE) throws Exception {
        if(SEXE.compareToIgnoreCase("Feminin")==0 || SEXE.compareToIgnoreCase("Masculin")==0) {
            this.SEXE = SEXE;
        }
        else {
            throw new Exception ("SEXE invalide"); 
        }
    }

    public String getDATE_NAISSANCE() {
        return DATE_NAISSANCE;
    }

    public void setDATE_NAISSANCE(String DATE_NAISSANCE) {
        this.DATE_NAISSANCE = DATE_NAISSANCE;
    }

    public String getDATE_EMBAUCHE() {
        return DATE_EMBAUCHE;
    }

    public void setDATE_EMBAUCHE(String DATE_EMBAUCHE) {
        this.DATE_EMBAUCHE = DATE_EMBAUCHE;
    }

    public Employer(long ID_EMPLOYER,String CIN, String NOM, String PRENOM, String SEXE, String DATE_NAISSANCE, String DATE_EMBAUCHE) throws Exception {
        this.setID_EMPLOYER(ID_EMPLOYER);
        this.setMATRICULE(ID_EMPLOYER);
        this.setCIN(CIN);
        this.setNOM(NOM);
        this.setPRENOM(PRENOM);
        this.setSEXE(SEXE);
        this.setDATE_NAISSANCE(DATE_NAISSANCE);
        this.setDATE_EMBAUCHE(DATE_EMBAUCHE);
    }
    
    public static long getIdEmployer() throws Exception {
        long reponse = -1;
        ResultSet rs = Oracle.getConnection().createStatement().executeQuery("select count(*) from employer");
        while(rs.next()) {
            reponse = rs.getLong(1)+1;
        }
        return reponse;
    }
    public boolean setEmployer() throws Exception {
        Connection c = Oracle.getConnection();
        int reponse = 0;
        String sql = "insert into employer values (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_EMPLOYER);
        ps.setString(2, this.MATRICULE);
        ps.setString(3, this.CIN);
        ps.setString(4, this.NOM);
        ps.setString(5, this.PRENOM);
        ps.setString(6, this.SEXE);
        ps.setString(7, this.DATE_NAISSANCE);
        ps.setString(8, this.DATE_EMBAUCHE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static Employer getEmployerByIdMatricule(String filtre) throws Exception {
        Connection c = Oracle.getConnection();
        String sql = null;
        if(filtre.substring(0, 2).compareToIgnoreCase("emp")==0) {
            
            sql = "select * from employer where matricule=?";
        }
        else {
            sql = "select * from employer where id_employer=?";
        }
        Employer reponse = null;
        PreparedStatement ps = c.prepareStatement(sql);
        if(filtre.substring(0, 2).compareToIgnoreCase("emp")==0) {
            ps.setString(1, filtre);
        }
        else {
            ps.setLong(1, Long.parseLong(filtre));
        }
        
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception ("Aucun employer trouver");
        }
        while(rs.next()) {
            reponse = new Employer (rs.getLong(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toString(),rs.getDate(8).toString());
        }
        return reponse;
    }
    public static Object[] rechercheEmployer(String nom,String prenom, String poste) throws Exception {
        Poste post = Poste.getPosteByNom(poste);
        ArrayList<Employer> arr_employe = new ArrayList<Employer>();
        String sql = "select * from employer join entree_poste_service on employer.id_employer=entree_poste_service.id_employer where entree_poste_service.id_poste=?";
            sql += " and nom like ?";
            sql += " and prenom like ?";
        Connection c = Oracle.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, post.getID_POSTE());
        if(prenom.isEmpty()) {
            prenom="";
        }
        if(nom.isEmpty()) {
            nom="";
        }
        ps.setString(2, "%"+nom+"%");
        ps.setString(3, "%"+prenom+"%");
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception("Aucun employe trouve");
        }
        while(rs.next()) {
            arr_employe.add(new Employer(rs.getLong(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toString(),rs.getDate(8).toString()));
        }
        
        return arr_employe.toArray();
    }
    public static Object[][] liste_employe(String nom,String prenom, String poste) throws Exception {
        Object[] temp = rechercheEmployer(nom, prenom, poste);
        Object[][] reponse = new Object[temp.length][4];
        int i=0;
        for(Object emp: temp) {
            Employer empl = (Employer)emp;
            reponse[i][0] = empl.getMATRICULE();
            reponse[i][1] = empl.getCIN();
            reponse[i][2] = empl.getNOM();
            reponse[i][3] = empl.getPRENOM();
            i++;
        }
        return reponse;
    }
    
}
