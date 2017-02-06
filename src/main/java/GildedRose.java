import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;

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

		updateQuality();
	}

	public static void setItems(List<Item> newItems) {
		items = newItems;
	}

	public static List<Item> updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			// handle all quality changes;
			if ("Aged Brie".equals(items.get(i).getName())) {
				if (items.get(i).getQuality() < 50) {
					items.get(i).setQuality(items.get(i).getQuality() + 1);
				}

			} else if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())
					&& items.get(i).getQuality() < 50) {

				if (items.get(i).getSellIn() >= 11) {// over 11 days away from
														// concert, quality goes
														// up 1 per day
					items.get(i).setQuality(items.get(i).getQuality() + 1);
				} else if (items.get(i).getSellIn() < 11 && items.get(i).getSellIn() > 5)
				// between 6 and 10 days, quality goes up by 2
				{
					items.get(i).setQuality(items.get(i).getQuality() + 2);
				} else if (items.get(i).getSellIn() <= 5) // below 5 days,
															// quality goes up
															// by 3 per day
				{
					items.get(i).setQuality(items.get(i).getQuality() + 3);
				}
				if (items.get(i).getSellIn() <= 0) { // if the concert has
													// happened, the ticket is
													// useless
					items.get(i).setQuality(0);
				}
			} else if ("Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
				// do nothing; no change in quality for a legendary item

			} else {
			
				// it is a standard item, decrease the quality but not to below
				// zero
				if (items.get(i).getQuality() > 0 && items.get(i).getSellIn() >=0 ) { 
					//item is not beyond the sell by date, decrease quality by 1
					items.get(i).setQuality(items.get(i).getQuality() - 1);
				} else if (items.get(i).getQuality() > 0 && items.get(i).getSellIn() <0 ) {
					//item is after its sell by date, decrease quality by 2
					items.get(i).setQuality(items.get(i).getQuality() - 2);
				}
			}

			// now update the sellin values; all items except for Sulfuras (which never expires) get decremented
			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
				items.get(i).setSellIn(  items.get(i).getSellIn() - 1);
			}

		}
		return items;
	}

}