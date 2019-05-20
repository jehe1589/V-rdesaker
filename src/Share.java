
public class Share extends ArticleOfValue {
	
	private int number;
	private double stockPrice;
	
	Share(String name, int number, double stockPrice){
		
		super(name);
		this.number = number;
		this.stockPrice = stockPrice;
	}
	
	public double calculateValue(){
		
		double value = 0.0;
		
		value = number * stockPrice;
		
		value = valueAfterVAT(value);
		
		return value;
	}
	
	public double changeStockPrice(){
		
		return stockPrice;
	}

	public String toString(){
		
		return "Share: " + getName() + ", value: " + calculateValue() + ", number: " + number + ", stock price: " + stockPrice;
	}
	
	public void setStockPrice(double newStockPrice){
		
		stockPrice = newStockPrice;
	}
}
