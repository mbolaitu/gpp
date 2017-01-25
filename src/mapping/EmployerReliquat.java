/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

/**
 *
 * @author mbola
 */
public class EmployerReliquat extends Employer {

    private double reliquat;

    public double getReliquat() {
        return reliquat;
    }

    public void setReliquat(double reliquat) {
        this.reliquat = reliquat;
    }
    
    public EmployerReliquat(long ID_EMPLOYER, String CIN, String NOM, String PRENOM, String SEXE, String DATE_NAISSANCE, String DATE_EMBAUCHE) throws Exception {
        super(ID_EMPLOYER, CIN, NOM, PRENOM, SEXE, DATE_NAISSANCE, DATE_EMBAUCHE);
        this.setReliquat(reliquat);
    }
    
}
