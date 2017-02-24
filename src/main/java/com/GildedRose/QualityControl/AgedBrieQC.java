package com.GildedRose.QualityControl;
import com.GildedRose.*;
import  java.lang.Math.*;

public class AgedBrieQC implements QualityControl {

		public void updateQualityFor(Item item){
			item.setQuality(Math.min(item.getQuality()+DEFAULT_QUALITY_INCREASE, MAX_QUALITY));
		}
	
	
	
}
