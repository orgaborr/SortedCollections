import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
	private final String name;
	private final Map<StockItem, Integer> list; //item and quantity in the basket
	/**
	 * @param name
	 */
	public Basket(String name) {
		this.name = name;
		this.list = new HashMap<>();
	}
	
	public int addToBasket(StockItem item, int quantity) {
		if((item != null) && (quantity > 0)) {
			int inBasket = list.getOrDefault(item,  0); //if not in the basket yet, sets to 0 in it
			list.put(item, inBasket + quantity); //than adds the quantity to the amount found already
			return inBasket;
		}
		return 0;
	}
	
	public Map<StockItem, Integer> Items() {
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
		double totalCost = 0.0;
		for(Map.Entry<StockItem, Integer> item : list.entrySet()) {
			s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
			totalCost += item.getKey().getPrice() * item.getValue(); //value here is the quantity
		}
		return s + "Total cost " + totalCost;
	}
	
	
}
