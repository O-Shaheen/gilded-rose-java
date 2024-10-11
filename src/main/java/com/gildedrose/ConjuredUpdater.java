package com.gildedrose;

public class ConjuredUpdater implements Updater{
    public void update(Item currentItem) {
        currentItem.quality -= 2;
        if(currentItem.quality < 0) {
            currentItem.quality = 0;
        }
        currentItem.sellIn--;
    }
}
