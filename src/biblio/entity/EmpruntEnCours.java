package biblio.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpruntEnCours {

	private Date dateEmprunt;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Utilisateur utilisateur;
	private Exemplaire exemplaire;

	public EmpruntEnCours() {
	}

	public EmpruntEnCours(Date dateEmprunt, Utilisateur utilisateur, Exemplaire exemplaire) {
		super();
		this.dateEmprunt = dateEmprunt;
		this.utilisateur = utilisateur;
		this.exemplaire = exemplaire;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	@Override
	public String toString() {
		return "EmpruntEnCours [dateEmprunt=" + sdf.format(dateEmprunt) + ", utilisateur=" + utilisateur
				+ ", exemplaire=" + exemplaire + "]";
	}

}
