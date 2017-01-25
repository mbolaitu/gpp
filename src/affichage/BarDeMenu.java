package affichage;

import ecouteur.EcouteurMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

public class BarDeMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	private JMenu Fichier;
		private JMenuItem ouvrir;
		private JMenuItem fermer;
	private JMenu Structure;
		private JMenuItem planComptable;
		private JMenuItem planTiers;
                private JMenuItem ligneCredit;
	private JMenu Traitement;
		private JMenuItem journauxDeSaisie;
		private JMenuItem interrogationEtLettrage;
		private JMenuItem interrogationTiers;
                private JMenuItem engagement;
                private JMenuItem degagement;
                private JMenuItem paiement;
	private JMenu Etat;
		private JMenuItem grandLivresCompte;
		private JMenuItem balanceGenerale;
                private JMenuItem balanceAuxilliaire;
		private JMenuItem statistique;
                private JMenuItem finexercice;
	private JMenu Aide;
		private JMenuItem Apropos;
		private JMenuItem Contact;

    public JMenuItem getFinexercice() {
        return finexercice;
    }

    public void setFinexercice(JMenuItem finexercice) {
        this.finexercice = finexercice;
    }
                                
    public JMenuItem getBalanceAuxilliaire() {
        return balanceAuxilliaire;
    }

    public void setBalanceAuxilliaire(JMenuItem balanceAuxilliaire) {
        this.balanceAuxilliaire = balanceAuxilliaire;
    }
                
    public JMenuItem getDegagement() {
        return degagement;
    }

    public void setDegagement(JMenuItem degagement) {
        this.degagement = degagement;
    }

    public JMenuItem getPaiement() {
        return paiement;
    }

    public void setPaiement(JMenuItem paiement) {
        this.paiement = paiement;
    }
                
    
    public JMenuItem getEngagement() {
        return engagement;
    }

    public void setEngagement(JMenuItem engagement) {
        this.engagement = engagement;
    }

    
    public JMenuItem getLigneCredit() {
        return ligneCredit;
    }

    public void setLigneCredit(JMenuItem ligneCredit) {
        this.ligneCredit = ligneCredit;
    }
                
    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JMenu getFichier() {
        return Fichier;
    }

    public void setFichier(JMenu Fichier) {
        this.Fichier = Fichier;
    }

    public JMenuItem getOuvrir() {
        return ouvrir;
    }

    public void setOuvrir(JMenuItem ouvrir) {
        this.ouvrir = ouvrir;
    }

    public JMenuItem getFermer() {
        return fermer;
    }

    public void setFermer(JMenuItem fermer) {
        this.fermer = fermer;
    }

    public JMenu getStructure() {
        return Structure;
    }

    public void setStructure(JMenu Structure) {
        this.Structure = Structure;
    }

    public JMenuItem getPlanComptable() {
        return planComptable;
    }

    public void setPlanComptable(JMenuItem planComptable) {
        this.planComptable = planComptable;
    }

    public JMenuItem getPlanTiers() {
        return planTiers;
    }

    public void setPlanTiers(JMenuItem planTiers) {
        this.planTiers = planTiers;
    }

    public JMenu getTraitement() {
        return Traitement;
    }

    public void setTraitement(JMenu Traitement) {
        this.Traitement = Traitement;
    }

    public JMenuItem getJournauxDeSaisie() {
        return journauxDeSaisie;
    }

    public void setJournauxDeSaisie(JMenuItem journauxDeSaisie) {
        this.journauxDeSaisie = journauxDeSaisie;
    }

    public JMenuItem getInterrogationEtLettrage() {
        return interrogationEtLettrage;
    }

    public void setInterrogationEtLettrage(JMenuItem interrogationEtLettrage) {
        this.interrogationEtLettrage = interrogationEtLettrage;
    }

    public JMenuItem getInterrogationTiers() {
        return interrogationTiers;
    }

    public void setInterrogationTiers(JMenuItem interrogationTiers) {
        this.interrogationTiers = interrogationTiers;
    }

    public JMenu getEtat() {
        return Etat;
    }

    public void setEtat(JMenu Etat) {
        this.Etat = Etat;
    }

    public JMenuItem getGrandLivresCompte() {
        return grandLivresCompte;
    }

    public void setGrandLivresCompte(JMenuItem grandLivresCompte) {
        this.grandLivresCompte = grandLivresCompte;
    }

    public JMenuItem getBalanceGenerale() {
        return balanceGenerale;
    }

    public void setBalanceGenerale(JMenuItem balanceCompte) {
        this.balanceGenerale = balanceCompte;
    }

    public JMenuItem getStatistique() {
        return statistique;
    }

    public void setStatistique(JMenuItem statistique) {
        this.statistique = statistique;
    }

    public JMenu getAide() {
        return Aide;
    }

    public void setAide(JMenu Aide) {
        this.Aide = Aide;
    }

    public JMenuItem getApropos() {
        return Apropos;
    }

    public void setApropos(JMenuItem Apropos) {
        this.Apropos = Apropos;
    }

    public JMenuItem getContact() {
        return Contact;
    }

    public void setContact(JMenuItem Contact) {
        this.Contact = Contact;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
		
       
	public BarDeMenu(JFrame fenetre) {
		menu = new JMenuBar();
		Fichier = new JMenu("fichier");
		Structure = new JMenu("structure");
		Traitement = new JMenu("traitement");
		Etat = new JMenu("etat");
		Aide = new JMenu("?");
		ouvrir = new JMenuItem("ouvrir un fichier");
		fermer = new JMenuItem("quitter");
                fermer.addActionListener(new EcouteurMenuBar(this));
		planComptable = new JMenuItem("Plan Comptable");
                planComptable.addActionListener(new EcouteurMenuBar(this));
		planTiers = new JMenuItem("Plan Tiers");
                planTiers.addActionListener(new EcouteurMenuBar(this));
                ligneCredit = new JMenuItem("Ligne de crédit");
                ligneCredit.addActionListener(new EcouteurMenuBar(this));
		journauxDeSaisie = new JMenuItem("Journaux de saisie");
		interrogationEtLettrage = new JMenuItem("Interrogation et lettrage");
		interrogationTiers = new JMenuItem("Interrogation tiers");
                engagement = new JMenuItem("Engagement");
                engagement.addActionListener(new EcouteurMenuBar(this));
                degagement = new JMenuItem("Degagement");
                degagement.addActionListener(new EcouteurMenuBar(this));
                paiement = new JMenuItem("Paiement");
                paiement.addActionListener(new EcouteurMenuBar(this));
		grandLivresCompte = new JMenuItem("Grand-livre des comptes...");
		balanceGenerale = new JMenuItem("Balance Génerale");
                balanceGenerale.addActionListener(new EcouteurMenuBar(this));
                balanceAuxilliaire = new JMenuItem("Balance Auxilliaire");
                balanceAuxilliaire.addActionListener(new EcouteurMenuBar(this));
		statistique = new JMenuItem("Statistique");
                finexercice = new JMenuItem("Fin d'exercice");
                finexercice.addActionListener(new EcouteurMenuBar(this));
		Apropos = new JMenuItem("Apropos");
		Contact = new JMenuItem("Contact");
		Fichier.add(ouvrir);
		Fichier.add(fermer);
		menu.add(Fichier);
		Structure.add(planComptable);
		Structure.add(planTiers);
                Structure.add(ligneCredit);
		menu.add(Structure);
		Traitement.add(journauxDeSaisie);
		Traitement.add(interrogationEtLettrage);
		Traitement.add(interrogationTiers);
                Traitement.add(engagement);
                Traitement.add(degagement);
                Traitement.add(paiement);
		menu.add(Traitement);
		Etat.add(grandLivresCompte);
		Etat.add(balanceGenerale);
                Etat.add(balanceAuxilliaire);
		Etat.add(statistique);
                Etat.add(finexercice);
		menu.add(Etat);
		Aide.add(Apropos);
		Aide.add(Contact);
		menu.add(Aide);
		
		fenetre.setJMenuBar(menu);
		
	}

}
