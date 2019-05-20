
public class Appliance extends ArticleOfValue {
	
	private double price;
	private int levelOfWear;
	
	Appliance(String name, double price, int levelOfWear){
		
		super(name);
		if(levelOfWear <= 0 || levelOfWear > 10){
			throw new IllegalArgumentException();
		}
		this.price = price;
		this.levelOfWear = levelOfWear;
	}
	
	public double calculateValue(){
		
		double value;
		
		value = ((double)levelOfWear/10) * price;
		
		value = valueAfterVAT(value);
		
		return value;
	}
	
	public String toString(){
		
		return "Appliance: " + getName() + ", value: " + calculateValue() + ", price: " + price + ", level of wear: " + levelOfWear;
	}
}
