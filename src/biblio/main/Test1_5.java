package biblio.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import biblio.dao.ExemplaireDAO;
import biblio.dao.UtilisateurDAO;
import biblio.entity.Employe;
import biblio.entity.EmpruntEnCours;
import biblio.entity.Exemplaire;
import biblio.ui.Ui;
import biblio.util.BiblioException;
import biblio.util.EnumStatusExemplaire;

public class Test1_5 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strId;
		Integer id;
		Exemplaire exemplaire;
		Employe employe;
		List<Exemplaire> listeExemplaire = new ArrayList<>();

		/***************************************************************************/
		/**
		 * find id exemplaire
		 */
		ExemplaireDAO exemplaireDAO = new ExemplaireDAO();
		for (int i = 0; i <= 3; i++) {
			id = Ui.saisieId("Entrer l'ID de l'exemplaire :");

			exemplaire = exemplaireDAO.findByKey(id);
			listeExemplaire.add(exemplaire);

			JOptionPane.showMessageDialog(null, exemplaire);
		}

		/***************************************************************************/
		/**
		 * find id employe
		 */
		id = Ui.saisieId("Entrer l'ID de l'employe :");

		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		employe = (Employe) utilisateurDAO.findByKey(id);

		JOptionPane.showMessageDialog(null, employe);

		/***************************************************************************/
		/**
		 * creation emprunt sur adherent
		 */
		EmpruntEnCours empruntEnCour = new EmpruntEnCours();
		for (int i = 0; i <= 3; i++) {
			System.out.println(i);
			try {
				listeExemplaire.get(i).setStatus(EnumStatusExemplaire.prete);
				exemplaireDAO.updateStatus(listeExemplaire.get(i));

				empruntEnCour = new EmpruntEnCours(sdf.parse("03/03/2020"), employe, listeExemplaire.get(i));
				employe.addEmpruntEnCours(empruntEnCour);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			try {
				employe.isConditionsPretAcceptees();
			} catch (BiblioException be) {
				JOptionPane.showMessageDialog(null, "Emprunt interdit\n" + be.getMessage());
				break;
			}

		}

		strId = "";
		for (EmpruntEnCours empruntEnCours : employe.getEmpruntEnCours()) {
			strId += empruntEnCours + "\n";
		}
		JOptionPane.showMessageDialog(null, employe + "\n" + strId);

	}

}
