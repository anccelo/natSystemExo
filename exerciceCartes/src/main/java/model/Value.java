package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Value {

    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("Valet", 11),
    QUEEN("Reine", 12),
    KING("Roi", 13),
    AS("As", 14);

    private final String label;
    private final int points;

    public int compare(final Value anotherValue) {
        return Integer.compare(this.getPoints(), anotherValue.getPoints());
    }

    @Override
    public String toString() {
        return this.getLabel();
    }
}
