import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void testDexVestQualityDecreases() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 19);
        
	}
	
	@Test
	public void testDexVestSellInDecreases() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getSellIn(), 9);
        
	}
	@Test
	public void testDexVestExpiredQualityDecreases() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", -1, 20));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 18);
        
	}	
	@Test
	public void testDexVestNonNegativeQuality() {  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", -1, 0));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 0); //quality would normally be decremented by 1 to -1, but can never go below zero
        
	}	
	@Test
	public void testAgedBrieGoesUpInQuality() {  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Aged Brie", 2, 0));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 1); 
        
	}		
	@Test
	public void testQualityNeverMoreThanFifty() {  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Aged Brie", 2, 50));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 50); 
        
	}	
	@Test
	public void testSulfurasNeverChangesQuality(){  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 80); 
        
	}	
	@Test
	public void testSulfurasNeverChangesSellin(){  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getSellIn(), 0);
        
	}		
	@Test
	public void testBackstagePassIncreasesInQualityOverTenDays(){  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        GildedRose gr = new GildedRose();
        System.out.println( "Quality "+ items.get(0).getQuality() );
        gr.setItems(items);
        items =gr.updateQuality();
        System.out.println( "Quality "+ items.get(0).getQuality() );
        assertEquals(items.get(0).getQuality(), 21);
        
	}	
	@Test
	public void testBackstagePassIncreasesInQualityDoublyUnderTenDays(){  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 22); //should go up by 2 if between 6-10 days left
	}		
	
	@Test
	public void testBackstagePassIncreasesInQualityTriplyUnderFiveDays(){  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 23); //should go up by 3 if between 1-5 days left
	}		
	
	@Test
	public void testBackstagePassDropsQualityAfterConcert(){  
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 0); 
	}	
	
	@Test
	public void testConjuredItemsDecreaseTwiceAsFast(){  
        List<Item> items = new ArrayList<Item>();
		items.add(new Item("Conjured Mana Cake", 3, 6));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 4); //4, because this would normally degrade by 1 except twice as fast as it's "conjured"
	}		
	@Test
	public void testConjuredItemsDecreaseTwiceAsFastAfterSellin(){  
        List<Item> items = new ArrayList<Item>();
		items.add(new Item("Conjured Mana Cake", -1, 6));
        GildedRose gr = new GildedRose();
        gr.setItems(items);
        items =gr.updateQuality();
        assertEquals(items.get(0).getQuality(), 2); //2, because it's conjured and expired hence four times faster degradation
	}		
	

	

}
