package com.gildedrose;
import static com.gildedrose.UpdateFactory.updating;
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            updating(currentItem).update(currentItem);
        }
    }
}