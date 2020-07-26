package partie;

import lombok.Getter;
import model.Carte;
import model.JeuDeCarte;
import model.Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Partie {

    Joueur joueur1 = new Joueur("joueur1");
    Joueur joueur2 = new Joueur("joueur2");
    Joueur joueur3 = new Joueur("joueur3");
    Joueur joueur4 = new Joueur("joueur4");
    Joueur[] joueurs = {joueur1, joueur2, joueur3, joueur4};

    JeuDeCarte jeu = JeuDeCarte.getInstance();

    public void distributionCartes() {
        int count = 1;
        for (Carte carte : jeu.getPaquet()) {

            switch (count % 4) {
                case 1:
                    joueurs[0].assignACard(carte);
                    break;
                case 2:
                    joueurs[1].assignACard(carte);
                    break;
                case 3:
                    joueurs[2].assignACard(carte);
                    break;
                case 0:
                    joueurs[3].assignACard(carte);
                    break;
            }
            count++;
        }
    }

    public void ajouterLesCartesAuxVainqueursDUnPli(final Pli pli, List<Joueur> jouersVinquers) {
        if (jouersVinquers.size() == 0) {
            System.err.println("if you are here, there are a problem...");//todo exceptions
        } else if (jouersVinquers.size() == 1) {
            for (Carte carteDuPLi : pli.recupererLesCartesDuPLi(pli.getPli())) {
                jouersVinquers.get(0).assignACard(carteDuPLi);
            }
        } else {
            for (int i = 0; i < pli.recupererLesCartesDuPLi(pli.getPli()).size(); i++) {
                Random random = new Random();
                int joueurRandom = random.nextInt(jouersVinquers.size() - 1);
                jouersVinquers.get(joueurRandom).assignACard(pli.recupererLesCartesDuPLi(pli.getPli()).get(i));
            }
        }
    }

    public List<Joueur> joueursAvecPlusDeCartes() {
        List<Joueur> lesJouersAvecPlusDeCartes = new ArrayList<Joueur>();
        int PlusDeCartes = this.joueurs[0].getCartes().size();
        for (Joueur joueur : this.joueurs) {
            if (joueur.getCartes().size() >= PlusDeCartes) {
                PlusDeCartes = joueur.getCartes().size();
            }
        }
        for (Joueur joueur : this.joueurs) {
            if (joueur.getCartes().size() == PlusDeCartes) {
                lesJouersAvecPlusDeCartes.add(joueur);
            }
        }
        return lesJouersAvecPlusDeCartes;
    }

    //J'ai trouvé les méthodes melanger et echanger depuis une recherche sur Internet
    public void melangerJeuDeCarte() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < jeu.getPaquet().length; j++) {
                echanger(random.nextInt(jeu.getPaquet().length), random.nextInt(jeu.getPaquet().length));
            }
        }
    }

    //J'ai trouvé les méthodes melanger et echanger sepuis une recherche sur Internet
    private void echanger(int i, int j) {
        Carte temp;
        temp = jeu.getPaquet()[i];
        jeu.getPaquet()[i] = jeu.getPaquet()[j];
        jeu.getPaquet()[j] = temp;
    }

}
