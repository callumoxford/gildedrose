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
                increaseQuality(item);
            } else if (isBackstagePass(item)) {
                increaseQuality(item);
                if (item.sellIn < BACKSTAGE_PASS_THRESHOLD_1) {
                    increaseQuality(item);
                }
                if (item.sellIn < BACKSTAGE_PASS_THRESHOLD_2) {
                    increaseQuality(item);
                }
            } else {
                if (item.quality > 0) {
                    decreaseQuality(item);
                }
            }

            if (item.sellIn < 0) {
                if (isAgedBrie(item)) {
                    increaseQuality(item);
                } else {
                    if (!isBackstagePass(item)) {
                        if (item.quality > 0) {
                            decreaseQuality(item);
                        }
                    } else {
                        item.quality = 0;
                    }
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
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