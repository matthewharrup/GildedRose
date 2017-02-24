package com.GildedRose.QualityControl;
import com.GildedRose.Item;

public interface QualityControl {
	
	//the default values from the spec
	int MAX_QUALITY = 50;
	int DEFAULT_QUALITY_INCREASE = 1;
	int DEFAULT_QUALITY_DECREASE = 1;
	
	void updateQualityFor(Item item);
}
