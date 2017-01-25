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
public class Service {
    private long ID_SERVICE;
    private String NOM_SERVICE;
    private String DATE_SERVICE;

    public long getID_SERVICE() {
        return ID_SERVICE;
    }

    public void setID_SERVICE(long ID_SERVICE) {
        this.ID_SERVICE = ID_SERVICE;
    }

    public String getNOM_SERVICE() {
        return NOM_SERVICE;
    }

    public void setNOM_SERVICE(String NOM_SERVICE) {
        this.NOM_SERVICE = NOM_SERVICE;
    }

    public String getDATE_SERVICE() {
        return DATE_SERVICE;
    }

    public void setDATE_SERVICE(String DATE_SERVICE) {
        this.DATE_SERVICE = DATE_SERVICE;
    }

    public Service(long ID_SERVICE, String NOM_SERVICE, String DATE_SERVICE) {
        this.setID_SERVICE(ID_SERVICE);
        this.setNOM_SERVICE(NOM_SERVICE);
        this.setDATE_SERVICE(DATE_SERVICE);
    }
    
    public boolean setService() throws Exception {
        int reponse = 0;
        Connection c = Oracle.getConnection();
        String sql = "insert into service values (?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.ID_SERVICE);
        ps.setString(2, this.NOM_SERVICE);
        ps.setString(3, this.DATE_SERVICE);
        reponse = ps.executeUpdate();
        c.commit();
        ps.clearParameters();
        c.close();
        return reponse>0;
    }
    public static String[] getListService() throws Exception {
        ArrayList<String> reponse = new ArrayList<String>();
        Connection c = Oracle.getConnection();
        ResultSet rs = c.createStatement().executeQuery("select distinct nom_service from service");
        if(rs==null) {
            throw new Exception ("Aucun service trouver");
        }
        while(rs.next()) {
            reponse.add(rs.getString(1));
        }
        if(reponse==null) {
            throw new Exception ("Aucun service trouver");
        }
        String [] val = new String[reponse.size()];
        for(int i =0;i<reponse.size();i++) {
            val[i] = reponse.get(i);
        }
        return val;
    }
    public static Service getServiceById(long id) throws Exception {
        Connection c = Oracle.getConnection();
        String sql = "select * from service where id_service=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, id);
        Service reponse = null;
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception ("Service inexistant");
        }
        while(rs.next()) {
            reponse = new Service (rs.getLong(1),rs.getString(2),rs.getDate(3).toString());
        }
        return reponse;
    }
    public static Service getServiceByNom(String nom) throws Exception {
        Connection c = Oracle.getConnection();
        String sql = "select * from service where nom_service=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, nom);
        Service reponse = null;
        ResultSet rs = ps.executeQuery();
        if(rs==null) {
            throw new Exception ("Service inexistant");
        }
        while(rs.next()) {
            reponse = new Service (rs.getLong(1),rs.getString(2),rs.getDate(3).toString());
        }
        return reponse;
    }
    
}
