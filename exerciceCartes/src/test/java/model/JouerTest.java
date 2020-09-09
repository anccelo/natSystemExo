package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JouerTest {

    private final Player jouer = new Player("joeur1");

    @Mock
    Card cardMock;

    @Test
    void should_return_zero_when_no_card_has_been_assigned_to_the_player() {
        int actual = jouer.getCards().size();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void should_return_two_when_two_cards_has_been_assigned_to_the_player() {
        jouer.assign(cardMock);
        jouer.assign(cardMock);

        int actual = jouer.getCards().size();
        int expected = 2;

        assertEquals(expected, actual);

    }

}
