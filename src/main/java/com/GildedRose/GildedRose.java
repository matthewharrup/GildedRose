package com.GildedRose;
import java.util.ArrayList;

import java.util.List;
import com.GildedRose.QualityControl.*;
import com.GildedRose.SellInControl.*;

public class GildedRose {

	private static List<Item> items = null;
	private QualityControlFactory qualityControlFactory;
	private SellInControl sellInControl;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		//updateQuality();
	}
	
	public GildedRose(QualityControlFactory qualityControl, SellInControl sellInControl) {
		this.qualityControlFactory = qualityControl;
		this.sellInControl = sellInControl;
	}

	public static void setItems(List<Item> newItems) {
		items = newItems;
	}
	
	
	public void updateQuality(List<Item> items) {
		for (Item item : items) {
			udpateSellInFor(item);
			updateQualityFor(item);
		}
	}
	
	private void updateQualityFor(Item item) {
		QualityControl qualityControl = qualityControlFactory.qualityControlFor(item);
		qualityControl.updateQualityFor(item);
	}	
	
	private void udpateSellInFor(Item item) {
		sellInControl.updateSellInFor(item);
	}

}