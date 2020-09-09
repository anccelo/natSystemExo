package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Card implements Comparable<Card> {

    private final Color color;
    private final Value value;

    @Override
    public int compareTo(Card anotherCard) {
        return value.compare(anotherCard.getValue());
    }

    @Override
    public String toString() {
        return this.value + " de " + this.color.getLabel();
    }

}
