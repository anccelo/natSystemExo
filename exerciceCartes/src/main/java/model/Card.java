package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Card implements Comparable<Card> {

    private final Color color;
    private final Value value;

    @Override
    public int compareTo(final Card anotherCard) {
        return this.value.compare(anotherCard.getValue());
    }

    @Override
    public String toString() {
        return this.value.toString() + " de " + this.color.toString();
    }

}
