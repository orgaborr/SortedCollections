import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
	private final Map<String, StockItem> list;

	public StockList() {
		this.list = new LinkedHashMap<>(); //items are stored in order of adding them
	}
	
	public int addStock(StockItem item) {
		if(item  != null) {
			//check if we already have quantities of this item
			StockItem inStock = list.getOrDefault(item.getName(), item); //uses the item with the name,
																		 //or uses the item passed to the method
			//if there are already stocks of this item, adjust the quantity
			if(inStock != item) {
				item.adjustStock(inStock.quantityInStock());
			}
			
			list.put(item.getName(), item);
			return item.quantityInStock();
		}
		return 0;
	}
	
	public int sellStock(String item, int quantity) {
		StockItem inStock = list.getOrDefault(item, null); //key, defaultValue
		
		if((inStock != null) && (inStock.quantityInStock() >= quantity ) && (quantity > 0)) { //checks there are enough items
			inStock.adjustStock(-quantity);
			return quantity;
		}
		return 0;
	}
	
	public StockItem get(String key) {
		return this.list.get(key);
	}
	
	public Map<String, StockItem> Items() {
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nStock List\n";
		double totalCost = 0.0;
		for(Map.Entry<String, StockItem> item : list.entrySet()) {
			StockItem stockItem = item.getValue();
			
			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
			
			s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
			s = s + String.format("%.2f", itemValue) + "\n"; // "%.2f" only 2 decimals displayed
			totalCost += itemValue;
		}
		
		return s + "Total stock value " + totalCost;
	}
	
	
	
}
