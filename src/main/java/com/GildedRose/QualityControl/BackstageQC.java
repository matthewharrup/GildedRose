package com.GildedRose.QualityControl;
import com.GildedRose.*;
import java.lang.Math.*;

public class BackstageQC implements QualityControl {

	private static final int ELEVEN_DAYS = 11;
	private static final int FIVE_DAYS = 5;
	
	private static final int NO_EXTRA_QUALITY_HIKE = 0;
	private static final int DOUBLE_EXTRA_QUALITY_HIKE = 2;
	private static final int EXTRA_QUALITY_HIKE = 1;

	public void updateQualityFor(Item backstagePass) {
		backstagePass.setQuality(newQualityFor(backstagePass));
	}

	private int newQualityFor(Item backstagePass) {
		return backstagePass.getSellIn() > 0
				? java.lang.Math.min(backstagePass.getQuality() + qualityHikeFor(backstagePass), MAX_QUALITY)
			    : 0;
	}
	
	private int qualityHikeFor(Item backstagePass) {
		return DEFAULT_QUALITY_INCREASE + extraQualityFor(backstagePass);
	}

	private int extraQualityFor(Item backstagePass) {
		if (concertIsWithinSixAndTenDays(backstagePass)) {
			return EXTRA_QUALITY_HIKE;
		} else if (concertIsInFiveOrLessDays(backstagePass)) {
			return DOUBLE_EXTRA_QUALITY_HIKE;
		}
		return NO_EXTRA_QUALITY_HIKE;
	}

	private boolean concertIsInFiveOrLessDays(Item backstagePass) {
		return backstagePass.getSellIn() <= FIVE_DAYS;
	}

	private boolean concertIsWithinSixAndTenDays(Item backstagePass) {
		return backstagePass.getSellIn() > FIVE_DAYS && backstagePass.getSellIn() < ELEVEN_DAYS;
	}


}