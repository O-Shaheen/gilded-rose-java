package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            if (currentItem.name.equals("Aged Brie")) {
                updateAgedBrie(currentItem);
            }
            else if(currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePasses(currentItem);
            }
            else if(currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                // do nothing
            }
            else {
                updateRestItem(currentItem);
            }
        }
    }

    private void updateRestItem(Item currentItem) {
        if (currentItem.quality > 0) {
            currentItem.quality--;
        }
        currentItem.sellIn--;

        if (currentItem.sellIn < 0 && currentItem.quality > 0) {
            currentItem.quality--;
        }
    }

    private void updateBackstagePasses(Item currentItem) {
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

    private void updateAgedBrie(Item currentItem) {
        if(currentItem.quality < 50) {
            currentItem.quality++;
        }
        currentItem.sellIn--;
    }
}