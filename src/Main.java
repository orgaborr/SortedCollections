import java.util.Map;

public class Main {
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		
		//adding items to our stockList
		StockItem temp = new StockItem("chair", 10.90, 50);
		stockList.addStock(temp);
		
		temp = new StockItem("table", 20.50, 25);
		stockList.addStock(temp);
		temp = new StockItem("table", 18.00, 3);
		stockList.addStock(temp);
		
		temp = new StockItem("owen", 50.00, 20);
		stockList.addStock(temp);
		
		temp = new StockItem("sofa", 15.99, 10);
		stockList.addStock(temp);
		
		temp = new StockItem("couch", 12.45, 10);
		stockList.addStock(temp);
		
		temp = new StockItem("fridge", 39.80, 4);
		stockList.addStock(temp);
		
		System.out.println(stockList);
		
		
		//now selling
		Basket gaborsBasket = new Basket("Gabor");
		
		sellItem(gaborsBasket, "fridge", 3);
		System.out.println(gaborsBasket);
		
		sellItem(gaborsBasket, "fridge", 1);
		System.out.println(gaborsBasket);
		
		//should be errors, 0 fridge left
		if(sellItem(gaborsBasket, "fridge", 1) == 0) {
			System.out.println("No more fridges left");
		}
		sellItem(gaborsBasket, "sink", 1);
		System.out.println(gaborsBasket);
		
		sellItem(gaborsBasket, "table", 1);
		sellItem(gaborsBasket, "chair", 4);
		System.out.println(gaborsBasket);
		
		System.out.println(stockList);
		
//		temp = new StockItem("pen", 1.10);
//		stockList.Items().put(temp.getName(), temp); // the unmodifiableMap sends an error, but individual
													 // items can still be changed
		
		for(Map.Entry<String, Double> price : stockList.priceList().entrySet()) {
			System.out.println(price.getKey() + " costs " + price.getValue());
		}

	}
	
	public static int sellItem(Basket basket, String item, int quantity) {
		//retrieve the item from stock list
		StockItem stockItem = stockList.get(item);
		if(stockItem == null) {
			System.out.println("We don't sell " + item);
		}
		
		//makes sure there are some left in stock
		if(stockList.sellStock(item, quantity) != 0) { 
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		return 0;

	}

}
