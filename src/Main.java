
public class Main {
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		StockItem temp = new StockItem("chair", 10.90, 50);
		stockList.addStock(temp);
		
		temp = new StockItem("table", 20.50, 25);
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

	}

}
