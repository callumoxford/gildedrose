package com.gildedrose;

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
