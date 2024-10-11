package com.gildedrose;

public class BackstagePassesUpdater implements Updater{
    public void update(Item currentItem) {
        if(currentItem.sellIn <= 0) {
            currentItem.quality = 0;
        }
        else if(currentItem.quality < 50) {
            if(currentItem.sellIn <= 5) {
                currentItem.quality += 2;
            }
            else if(currentItem.sellIn <= 10){
                currentItem.quality += 1;
            }
            currentItem.quality ++;
        }
        currentItem.sellIn--;
    }
}
