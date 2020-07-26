package model;

import org.junit.jupiter.api.Test;

import static model.Couleur.*;
import static model.Valeur.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarteTest {

    private final Carte smallerCarte = new Carte(coeur, cinq);
    private final Carte biggerCarte = new Carte(trefle, dix);
    private final Carte firstEqualsValueCarte = new Carte(pique, as);
    private final Carte otherEqualsValueCarte = new Carte(coeur, as);


    @Test
    void should_return_one_when_a_card_is_compared_with_a_biger_one() {

        int actual = smallerCarte.compareTo(biggerCarte);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void should_return_minus_one_when_a_card_is_compared_with_a_smaller_one() {

        int actual = biggerCarte.compareTo(smallerCarte);
        int expected = -1;

        assertEquals(expected, actual);
    }

    @Test
    void should_return_zero_when_a_card_is_compared_with_a_card_of_equals_value() {

        int actual = firstEqualsValueCarte.compareTo(otherEqualsValueCarte);
        int expected = 0;

        assertEquals(expected, actual);
    }

}
