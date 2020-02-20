package com.gildedrose;

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
