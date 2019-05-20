

public class Ornament extends ArticleOfValue {
	
	private int numberOfGems;
	private String material;
	
	Ornament(String name, int numberOfGems, String material){
		
		super(name);
		this.numberOfGems = numberOfGems;
		this.material = material;
	}
	
	public double calculateValue(){
		
		double value = 0.0;
		
		materialValue(value);
		
		value += (numberOfGems * 500); 
		
		value = valueAfterVAT(value);
		
		return value;
	}
	
	public double materialValue(double value){
		
        if(material.equalsIgnoreCase("Gold")){
			
			value = 2000.0;
		}
		if(material.equalsIgnoreCase("Silver")){
			
			value = 700.0;
		}
		
		return value;
	}

	public String toString(){
		
		return "Ornament: " + getName() + ", value: " + calculateValue() + ", number of gems: " + numberOfGems + ", material: " + material; 
	}
}
