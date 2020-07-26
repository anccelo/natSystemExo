package model;

import lombok.Getter;

@Getter
public class Carte implements Comparable<Carte> {

    private final Couleur couleur;
    private final Valeur valeur;

    public Carte(final Couleur couleur, final Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    @Override
    public int compareTo(Carte carte) {
        if (this.valeur == carte.valeur) {
            return 0;
        } else if (this.valeur.value < carte.valeur.value) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        String result = valeur.label + " de " + couleur + "\n";
        if (valeur != Valeur.as)
            return result;
        else
            return result + "\n";
    }

}
