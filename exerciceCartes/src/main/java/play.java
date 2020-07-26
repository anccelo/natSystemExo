import model.Carte;
import model.Joueur;
import partie.Partie;
import partie.Pli;

import java.util.List;
import java.util.Map;

public class play {

    public static void main(String[] args) {

        Partie partie = new Partie();
        System.out.println(partie.getJeu());

        Pli pli = new Pli(partie);

        partie.melangerJeuDeCarte();
        partie.distributionCartes();

        while (partie.getJoueur1().getCartes().size() != 0 &&
                partie.getJoueur2().getCartes().size() != 0 &&
                partie.getJoueur3().getCartes().size() != 0 &&
                partie.getJoueur4().getCartes().size() != 0){
            Map<Joueur, Carte> pliEnCour = pli.jouerUnPli();
            Carte carteLaPlusForte = pli.determinerLaCartePLusForteDuPli(pliEnCour);
            List<Joueur> jouersVainqueur = pli.determinerLesJoueursGagnantes(pliEnCour, carteLaPlusForte);

            partie.ajouterLesCartesAuxVainqueursDUnPli(pli, carteLaPlusForte, jouersVainqueur);
        }

        System.out.println("The Winner is/are: " + partie.joueursAvecPlusDeCartes());
    }


}
