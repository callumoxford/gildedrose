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
        return new RegularItemUpdater(item);
    }
}

class RegularItemUpdater extends ItemUpdater {
    public RegularItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void age() {
        super.age();
        if (item.sellIn < 0) {
            decreaseQuality(item, 2);
        } else {
            decreaseQuality(item, 1);
        }
    }
}

class AgedBrieUpdater extends ItemUpdater {
    public AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    public void age() {
        super.age();
        if (item.sellIn < 0) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
    }
}

class SulfurasUpdater extends ItemUpdater {
    public SulfurasUpdater(Item item) {
        super(item);
    }

    @Override
    public void age() {
        //Never updates
    }
}

class BackstagePassUpdater extends ItemUpdater {
    public static final int BACKSTAGE_PASS_THRESHOLD_1 = 10;
    public static final int BACKSTAGE_PASS_THRESHOLD_2 = 5;

    public BackstagePassUpdater(Item item) {
        super(item);
    }

    @Override
    public void age() {
        super.age();
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
    }
}