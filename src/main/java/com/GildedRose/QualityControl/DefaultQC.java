package com.GildedRose.QualityControl;

import com.GildedRose.*;

public class DefaultQC implements QualityControl {

		public void updateQualityFor(Item item) {
			item.setQuality(item.getQuality() - qualityDropFor(item));
		}
		
		private int qualityDropFor(Item item) {
			int defaultQualityDrop = defaultQualityDropFor(item);
			
			return item.getQuality() - defaultQualityDrop >= 0 
						? defaultQualityDrop
						: item.getQuality();
		}

		//by default, items decrease by 1 if before sell-by date or by 2 if after sell-by date
		private int defaultQualityDropFor(Item item) {
			return item.getSellIn() < 0
						? DEFAULT_QUALITY_DECREASE * 2 
						: DEFAULT_QUALITY_DECREASE;
		}
}
