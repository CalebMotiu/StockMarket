package Assets;

public abstract class Asset {
	private String name;
	private String symbol;
	private Double price;
	
	
	public Asset(String name, String symbol, Double price) {
		this.name = name;
		this.symbol = symbol;
		this.price = price;
	}


	public String getSymbol() {
		return symbol;
	}


	public String getName() {
		return name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
