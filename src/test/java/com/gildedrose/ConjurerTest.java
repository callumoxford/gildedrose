package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ConjurerTest {
    @Test
    public void conjureAging() {
        Item[] items = new Item[] {
                new Item("Conjurer", 1, 10),
                new Item("Generic", 1, 10)

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(8));
        assertThat(items[1].quality, equalTo(9));
        assertThat(items[0].sellIn, equalTo(0));
        assertThat(items[1].sellIn, equalTo(0));
    }
}
