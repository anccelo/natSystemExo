package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JeuDeCarte {

    private List<Carte> paquet = new ArrayList<Carte>();

    private JeuDeCarte() {
        for (Couleur coleur : Couleur.values()) {
            for (Valeur valuer : Valeur.values()
            ) {
                paquet.add(new Carte(coleur, valuer));
            }
        }
    }

    private static class JeuDeCarteHolder {
        private final static JeuDeCarte instance = new JeuDeCarte();
    }

    public static JeuDeCarte getInstance() {
        return JeuDeCarteHolder.instance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Carte carte : paquet
        ) {
            result.append(carte);
        }
        return result.toString();
    }

}
