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
public class Poste {
    private long ID_POSTE;
    private String NOM_POSTE;

    public long getID_POSTE() {
        return ID_POSTE;
    }

    public void setID_POSTE(long ID_POSTE) {
        this.ID_POSTE = ID_POSTE;
    }

    public String getNOM_POSTE() {
        return NOM_POSTE;
    }

    public void setNOM_POSTE(String NOM_POSTE) {
        this.NOM_POSTE = NOM_POSTE;
    }

    public Poste(long ID_POSTE, String NOM_POSTE) {
        this.setID_POSTE(ID_POSTE);
        this.setNOM_POSTE(NOM_POSTE);
    }
    
    public boolean setPoste() throws Exception {
        int reponse = 0;
        Connection c = Oracle.getConnection();
        String sql = "insert into poste values (?, ?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_POSTE);
        ps.setString(2, this.NOM_POSTE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static String[] getListPoste() throws Exception {
        ArrayList<String> reponse = new ArrayList<String>();
        Connection c = Oracle.getConnection();
        ResultSet rs = c.createStatement().executeQuery("select distinct nom_poste from poste");
        if(rs==null) {
            throw new Exception ("Aucun poste trouver");
        }
        while(rs.next()) {
            reponse.add(rs.getString(1));
        }
        if(reponse==null) {
            throw new Exception ("Aucun poste trouver");
        }
        String [] val = new String[reponse.size()];
        for(int i =0;i<reponse.size();i++) {
            val[i] = reponse.get(i);
        }
        return val;
    }
    public static Poste getPosteById(long id) throws Exception {
        Connection c = Oracle.getConnection();
        String sql = "select * from poste where id_poste=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, id);
        Poste reponse = null;
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception ("Poste inexistant");
        }
        while(rs.next()) {
            reponse = new Poste (rs.getLong(1),rs.getString(2));
        }
        return reponse;
    }
    public static Poste getPosteByNom(String nom) throws Exception {
        Connection c = Oracle.getConnection();
        String sql = "select * from poste where nom_poste=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, nom);
        Poste reponse = null;
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception ("Poste inexistant");
        }
        while(rs.next()) {
            reponse = new Poste (rs.getLong(1),rs.getString(2));
        }
        return reponse;
    }
}
