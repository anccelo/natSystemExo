package model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Color {

    CLUBS("trèfle"),
    DIAMONDS("carreau"),
    HEARTS("coeur"),
    SPADES("pique");

    private final String label;

    @Override
    public String toString() {
        return this.label;
    }

}
