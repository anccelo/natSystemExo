package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Jouer {

    private final List<Carte> cartes = new ArrayList<Carte>() ;

    public void assignACard(Carte cartes) {
        this.cartes.add(cartes);
    }

}
