package com.GildedRose.SellInControl;
import com.GildedRose.*;

public class SellInControl {


	private static final int DEFAULT_DECREASE = 1;
	private static final int NO_DECREASE = 0;

	public void updateSellInFor(Item item) {
		item.setSellIn(item.getSellIn() - sellInDecreaseFor(item));
	}

	//Sulfuras has no sell-by date, everything else decreases by 1 each day
	private int sellInDecreaseFor(Item item) {
		return ItemNames.SULFURAS_ITEM_NAME.equals(item.getName()) ? NO_DECREASE : DEFAULT_DECREASE; 
	}
	
}
