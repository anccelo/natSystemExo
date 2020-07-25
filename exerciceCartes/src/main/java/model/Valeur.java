package model;

public enum Valeur {

    deux("2", 2),
    trois("3", 3),
    quatre("4", 4),
    cinq("5", 5),
    six("6", 6),
    sept("7", 7),
    huit("8", 8),
    neuf("9", 9),
    dix("10", 10),
    valet("Valet", 11),
    reine("Reine", 12),
    roi("Roi", 13),
    as("As", 14);

    public final String label;
    public final int value;

    private Valeur(String label, int value) {
        this.label = label;
        this.value = value;
    }

}
