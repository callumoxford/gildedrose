package com.gildedrose;


public abstract class ItemUpdater {
    protected Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public void age() {
        item.sellIn = item.sellIn - 1;
    }

    protected void decreaseQuality(Item item, int decrement) {
        item.quality = Math.max(0, item.quality - decrement);
    }

    protected void increaseQuality(Item item, int i) {
        item.quality = Math.min(50, item.quality + i);
    }

    public static ItemUpdater generateUpdater(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurasUpdater(item);
        }
        if (item.name.equals("Aged Brie")) {
            return new AgedBrieUpdater(item);
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassUpdater(item);
        }
        if (item.name.equals("Conjurer")) {
            return new ConjurerItemUpdater(item);
        }
        return new RegularItemUpdater(item);
    }
}

