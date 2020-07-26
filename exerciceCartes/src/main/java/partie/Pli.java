package partie;

import lombok.Getter;
import model.Carte;
import model.Joueur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Pli {

    private Partie partie;
    private Map<Joueur, Carte> pli;

    public Pli(Partie partie) {
        this.partie = partie;
    }

    public Map<Joueur, Carte> jouerUnPli() {
        Map<Joueur, Carte> pli = new HashMap<Joueur, Carte>();
        for (Joueur joueur : partie.joueurs
        ) {
            Carte carteJouee = joueur.jouerUneCarteAuHasard();
            pli.put(joueur, carteJouee);
            joueur.getCartes().remove(carteJouee);
        }
        this.pli = pli;
        return pli;
    }

    public Carte determinerLaCartePLusForteDuPli(Map<Joueur, Carte> pli) {
        List<Carte> cartesJouee = new ArrayList(pli.values());
        Carte bigerCarte = cartesJouee.get(0);
        for (Carte carte : cartesJouee) {
            int res = carte.compareTo(bigerCarte);
            if (res == -1)
                bigerCarte = carte;
        }
        return bigerCarte;
    }

    public List<Joueur> determinerLesJoueursGagnantes(Map<Joueur, Carte> pli, Carte carteGagnante) {
        List<Joueur> joueursGagnantes = new ArrayList<Joueur>();
        for (Joueur joueur : pli.keySet()
        ) {
            if (pli.get(joueur).getValeur() == carteGagnante.getValeur()) {
                joueursGagnantes.add(joueur);
            }
        }
        return joueursGagnantes;
    }

    public List<Carte> recupererLesCartesDuPLi(Map<Joueur, Carte> thisPli) {
        return new ArrayList<Carte>(thisPli.values());
    }

}
