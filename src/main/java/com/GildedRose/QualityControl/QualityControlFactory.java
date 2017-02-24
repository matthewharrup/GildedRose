package com.GildedRose.QualityControl;
import com.GildedRose.*;

public class QualityControlFactory {

	
	private static enum ItemQualityControl {
		AGED_BRIE(ItemNames.AGED_BRIE_ITEM_NAME, new AgedBrieQC()),
		SULFURAS(ItemNames.SULFURAS_ITEM_NAME, new SulfurasQC()),
		CONJURED(ItemNames.CONJURED_ITEM_NAME, new ConjuredQC()),
		BACKSTAGE(ItemNames.BACKSTAGE_PASS_ITEM_NAME,  new BackstageQC());
		
		private String itemName;
		private QualityControl qualityControl;

		private ItemQualityControl(String itemName, QualityControl qualityControl) {
			this.itemName = itemName;
			this.qualityControl = qualityControl;
		}
		
		public static QualityControl qualityControlFor(Item item) {
			for (ItemQualityControl itemQualityControl : ItemQualityControl.values()) {
				if (itemQualityControl.itemName.equals(item.getName())) {
					return itemQualityControl.qualityControl;
				}
			}
			return new DefaultQC();
		}
	}
	
	public QualityControl qualityControlFor(Item item) {
		return ItemQualityControl.qualityControlFor(item);
	}
}
