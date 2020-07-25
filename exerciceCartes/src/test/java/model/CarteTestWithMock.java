package model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static model.Valeur.cinq;
import static model.Valeur.dix;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CarteTestWithMock {

    public static final int SMALLER_CARD_VALUE = cinq.value;
    public static final int BIGER_CARD_VALUE = dix.value;

    @Mock
    Carte cardMock;
    @Mock
    Valeur valuerMock;
    @Mock
    Carte otherCardMock;
    @Mock
    Valeur otherValeurMock;

    @Test
    void should_return_minus_one_when_instance_of_a_card_is_compared_with_a_smaller_one() {
        when(valuerMock.value).thenReturn((SMALLER_CARD_VALUE));
        when(otherValeurMock.value).thenReturn((BIGER_CARD_VALUE));
        when(cardMock.getValeur()).thenReturn(valuerMock);
        when(otherCardMock.getValeur()).thenReturn(otherValeurMock);

        int actual = cardMock.compareTo(otherCardMock);
        int expected = -1;

        assertEquals(expected, actual);

    }

}
