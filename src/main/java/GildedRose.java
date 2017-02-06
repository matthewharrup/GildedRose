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

	public static void setItems (List<Item> newItems){
		items= newItems;
	}
	
	
    public static List<Item> updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
        	//if the quality is over 0 and it's not an item that improves with age, decrease quality
            if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) 
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
            else
            {//assumed that items are going up with age. Note that quality can't go over 50 for these 
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                        //this is a horrible pass-through incrementing backstage passes by 1+1+1 to get 3
                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }
            //decrease the sellin for non-legendary items
            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }
            //if past sell-by date
            if (items.get(i).getSellIn() < 0)
            {  //and not "Aged Brie"
                if (!"Aged Brie".equals(items.get(i).getName()))
                { //and not a backstage pass
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
                    { 
                        if (items.get(i).getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
                            {  //then reduce quality
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    { //it is a backstage pass, set it to zero
                        items.get(i).setQuality(0);
                    }
                }
                else
                { //it is "Aged Brie", increment quality
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }
        }
        return items;
    }

}