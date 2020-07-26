package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static model.Couleur.*;

@Getter
public class JeuDeCarte {

    private final Carte[] paquet = new Carte[52];

    private JeuDeCarte() {
        int i = 0;
        for (Couleur coleur : Couleur.values()) {
            for (Valeur valuer : Valeur.values()
            ) {
                paquet[i] = new Carte(coleur, valuer);
                i++;
            }
        }
    }

    private static class JeuDeCarteHolder {
        private final static JeuDeCarte instance = new JeuDeCarte();
    }

    public static JeuDeCarte getInstance() {
        return JeuDeCarteHolder.instance;
    }

    public void printInColumns() {
        List<Carte> trefles = new ArrayList<Carte>();
        List<Carte> carreaux = new ArrayList<Carte>();
        List<Carte> coeurs = new ArrayList<Carte>();
        List<Carte> piques = new ArrayList<Carte>();
        for (Carte carte : paquet) {
            if (carte.getCouleur() == trefle)
                trefles.add(carte);
            if (carte.getCouleur() == carreau)
                carreaux.add(carte);
            if (carte.getCouleur() == coeur)
                coeurs.add(carte);
            if (carte.getCouleur() == pique)
                piques.add(carte);
        }
        for (int i = 0; i < 13; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s\n", trefles.get(i), carreaux.get(i), coeurs.get(i),
                    piques.get(i));
        }
        System.out.println();
    }

}
