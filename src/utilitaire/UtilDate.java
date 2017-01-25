/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author mbola
 */
public class UtilDate {
    
    public static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0,pos) + c + s.substring(pos+1);
    }
    
    public static String date_format(String date) {
        String valiny = date;
        for(int i =0; i<valiny.length();i++) {
            if(valiny.charAt(i)=='/' || valiny.charAt(i)=='.' || valiny.charAt(i)==' ') {
                valiny = replaceCharAt(valiny, i, '-');
            }
        }
        return valiny;
    }
    public static String heure_format_tsotra(String heure) {
        String valiny = heure;
        for(int i =0; i<valiny.length();i++) {
            if(valiny.charAt(i)=='h' || valiny.charAt(i)=='H' || valiny.charAt(i)=='m' || valiny.charAt(i)=='M' || valiny.charAt(i)=='s' || valiny.charAt(i)=='S')  {
                if(i<valiny.length()-1)
                    valiny = replaceCharAt(valiny, i, ':');
                else 
                    valiny = valiny.substring(0,valiny.length()-1);
            }
        }
        if(valiny.length()<=5 && valiny.length()>=3)
            valiny = valiny+":00";
        else if(valiny.length()<=3)
            valiny = valiny+":00:00";
        
        return valiny;
    }
    public static String heure_format(String heure) {
        String am_pm = heure.substring(heure.length()-2, heure.length());
        if(am_pm.compareToIgnoreCase("am")!=0 && am_pm.compareToIgnoreCase("pm")!=0) {
            return heure_format_tsotra(heure);
        }
        String valiny = heure;
        String [] temp = null;
        Time normal;
        Time transition = Time.valueOf("12:00:00");
        Time izy = null;
        for(int i =0; i<valiny.length();i++) {
            if(valiny.charAt(i)==' ') {
                temp = valiny.split(" ");
                valiny = heure_format_tsotra(temp[0]);
                if(valiny.length()<=5)
                valiny = valiny+":00";
                normal = Time.valueOf(valiny);
                if(temp[1].compareToIgnoreCase("PM")==0) {
                    if(temp[0].charAt(0)=='1' && temp[0].charAt(1)=='2') {
                        izy = new Time(normal.getTime());
                    }
                    else {
                        long a = normal.getTime()+transition.getTime()+10800000;
                        izy = new Time(a);
                    }
                }
                else if(temp[1].compareToIgnoreCase("AM")==0) {
                    if(temp[0].charAt(0)=='1' && temp[0].charAt(1)=='2') {
                        long a = normal.getTime()-(transition.getTime()+10800000);
                        izy = new Time(a);
                    }
                    else {
                        izy = new Time(normal.getTime());
                    }
                }
                    
            }
        }
        return izy.toString();
    }
    public static double heure_diff(Time t1, Time t2) {
        return ((t1.getTime())-(t2.getTime()))/(3600000.0f);
    }
    public static double heure_diff(String t1, String t2) {
        Time time1 = Time.valueOf(t1);
        Time time2 = Time.valueOf(t2);
        return ((time1.getTime())-(time2.getTime()))/(3600000.0f);
    }
    public static double date_diff(String dts1, String dts2) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date dt1 = null;
        java.util.Date dt2 = null;
        dt1 = dateFormat.parse(dts1);
        dt2 = dateFormat.parse(dts2);
        return ((dt1.getTime())-(dt2.getTime()))/3600000.0f;
    }
    public static double temps_diff(String dt1,String h1,String dt2,String h2) throws Exception {
        double date = date_diff(dt2, dt1);
        double heure = heure_diff(h1, h2);
        return date+heure;
    }
    public static String get_jour(String dt) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date dt1 = dateFormat.parse(dt);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dt1);
        if(calendar.get(calendar.DAY_OF_WEEK)==2)
            return "lundi";
        else if(calendar.get(calendar.DAY_OF_WEEK)==3)
            return "mardi";
        else if(calendar.get(calendar.DAY_OF_WEEK)==4)
            return "mercredi";
        else if(calendar.get(calendar.DAY_OF_WEEK)==5)
            return "jeudi";
        else if(calendar.get(calendar.DAY_OF_WEEK)==6)
            return "vendredi";
        else if(calendar.get(calendar.DAY_OF_WEEK)==7)
            return "samedi";
        return "dimanche";
    }
    
    public static String maraina_ariva(String time) throws Exception {
        String valiny = "maraina";
        if(heure_diff("12:00:00", time)<0)
            valiny = "hariva";
        return valiny;
    }
    
    public static String getDatezao() throws ParseException
    {
        String reponse = "";
        Calendar c = Calendar.getInstance();
        reponse = c.get(Calendar.DATE)+"-"+c.get(Calendar.MONTH+1)+"-"+c.get(Calendar.YEAR);
        return reponse;
    }
    public static String getHeurezao() throws ParseException
    {
        String reponse = "";
        Calendar c = Calendar.getInstance();
        reponse = c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        return reponse;
    }
}
