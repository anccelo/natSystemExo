package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Joueur {

    private String name;
    private final List<Carte> cartes = new ArrayList<Carte>();

    public Joueur(String name) {
        this.name = name;
    }

    public void assignACard(Carte cartes) {
        this.cartes.add(cartes);
    }

    public Carte jouerUneCarteAuHasard() {
        try {
            Random random = new Random();
            int carteRandom = random.nextInt(cartes.size());
            return cartes.get(carteRandom);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("pas de cartes pour ce jouer");
            return null;
        }
    }

    @Override
    public String toString() {
        return name + " avec " + cartes.size() + " cartes";
    }
}
