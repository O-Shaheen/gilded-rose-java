package com.gildedrose;

public class RestOfItermsUpdater implements Updater{
    public void update(Item currentItem) {
        if (currentItem.quality > 0) {
            currentItem.quality--;
        }
        currentItem.sellIn--;

        if (currentItem.sellIn < 0 && currentItem.quality > 0) {
            currentItem.quality--;
        }
    }
}
