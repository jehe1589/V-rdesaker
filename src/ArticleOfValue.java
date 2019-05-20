
public abstract class ArticleOfValue {	
	
	private String name;
	private double value;
	
	ArticleOfValue(String name){
		
		this.name = name;
	}
	
    public double valueAfterVAT(double value){
		
		double VAT = 1.25;
		
		return value * VAT;
	}

	public String getName(){
		
		return name;
	}
	
	public double getValue(){
		
		return value;
	}
	
	public abstract double calculateValue();
	
	public abstract String toString();
	
}
	

