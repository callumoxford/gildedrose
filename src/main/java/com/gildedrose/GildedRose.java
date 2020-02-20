package com.gildedrose;

class GildedRose {
    public static final int BACKSTAGE_PASS_THRESHOLD_1 = 10;
    public static final int BACKSTAGE_PASS_THRESHOLD_2 = 5;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isSulfuras(item)) {
                continue;
            }
            item.sellIn = item.sellIn - 1;

            if (isAgedBrie(item)) {
                increaseQuality(item, 1);
                if (item.sellIn < 0) {
                    increaseQuality(item, 1);
                }
            } else if (isBackstagePass(item)) {
                if (item.sellIn >= 0) {
                    if (item.sellIn < BACKSTAGE_PASS_THRESHOLD_2) {
                        increaseQuality(item, 3);
                    } else if (item.sellIn < BACKSTAGE_PASS_THRESHOLD_1) {
                        increaseQuality(item, 2);
                    } else {
                        increaseQuality(item, 1);
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.sellIn < 0) {
                    decreaseQuality(item, 2);
                } else {
                    decreaseQuality(item, 1);
                }
            }
        }
    }

    private void decreaseQuality(Item item, int decrement) {
        item.quality = Math.max(0, item.quality - decrement);
    }

    private void increaseQuality(Item item, int i) {
        item.quality = Math.min(50, item.quality + i);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}