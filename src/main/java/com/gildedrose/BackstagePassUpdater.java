package com.gildedrose;

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
