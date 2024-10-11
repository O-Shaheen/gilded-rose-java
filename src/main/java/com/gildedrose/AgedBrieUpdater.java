package com.gildedrose;

public class AgedBrieUpdater implements Updater{
    public void update(Item currentItem) {
        if(currentItem.quality < 50) {
            currentItem.quality++;
        }
        currentItem.sellIn--;
    }
}
