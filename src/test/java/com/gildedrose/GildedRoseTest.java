package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    public void lower_sellIn_quality_each_day() throws Exception {
        Item[] items = new Item[] { new Item("Item", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void lower_quality_twice_SellIn_is_zero() throws Exception {
        Item[] items = new Item[] { new Item("Item", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void min_quality_is_zero() throws Exception {
        Item[] items = new Item[] { new Item("Item", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void aged_brie_increase_quality_daily() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void aged_brie_max_quality_is_50() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfuras_quality_sellIn_unchangeable() throws Exception {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(5, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_increase_daily() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void backstage_passes_add_2_when_sellIn_is_equal_or_less_than_10() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void backstage_passes_add_3_when_sellIn_equal_or_less_than_5() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void backstage_passes_max_quality_is_50() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_becomes_zero_if_sellIn_zero_or_neg() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void conjured_quality_degrade_twice_as_fast() throws Exception {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    public void conjured_quality_min_value_is_zero() throws Exception {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
