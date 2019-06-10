
public class MainChallenge {
	private static StockList stockList = new StockList();
	
	public static void main(String[] args) {
		
	}
	
	public static int putToBasket(Basket basket, String item, int quantity) {
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
