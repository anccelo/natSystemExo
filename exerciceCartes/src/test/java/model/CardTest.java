package model;

import org.junit.jupiter.api.Test;

import static model.Color.*;
import static model.Value.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    private final Card smallerCard = new Card(HEARTS, THREE);
    private final Card biggerCard = new Card(CLUBS, TEN);
    private final Card firstEqualsValueCard = new Card(SPADES, AS);
    private final Card otherEqualsValueCard = new Card(HEARTS, AS);


    @Test
    void should_return_minus_one_when_a_card_is_compared_with_a_biger_one() {

        int actual = smallerCard.compareTo(biggerCard);
        int expected = -1;

        assertEquals(expected, actual);
    }

    @Test
    void should_return_one_when_a_card_is_compared_with_a_smaller_one() {

        int actual = biggerCard.compareTo(smallerCard);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void should_return_zero_when_a_card_is_compared_with_a_card_of_equals_value() {

        int actual = firstEqualsValueCard.compareTo(otherEqualsValueCard);
        int expected = 0;

        assertEquals(expected, actual);
    }

}
