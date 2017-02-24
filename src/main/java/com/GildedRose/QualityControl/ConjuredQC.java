package com.GildedRose.QualityControl;
import com.GildedRose.*;

	
	public class ConjuredQC implements QualityControl {

		private static final int CONJURED_QUALITY_DROP = DEFAULT_QUALITY_DECREASE * 2;

		public void updateQualityFor(Item item) {
			item.setQuality(item.getQuality() - qualityDropFor(item));
		}

		private int qualityDropFor(Item item) {
			return item.getQuality() - CONJURED_QUALITY_DROP > 0
						? CONJURED_QUALITY_DROP
					    : item.getQuality();
							
		}

	}

