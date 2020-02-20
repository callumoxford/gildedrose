package com.gildedrose;

class ConjurerItemUpdater extends ItemUpdater {
    public ConjurerItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void age() {
        super.age();
        if (item.sellIn < 0) {
            decreaseQuality(item, 4);
        } else {
            decreaseQuality(item, 2);
        }
    }
}
