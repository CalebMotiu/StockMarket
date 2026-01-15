package Assets;

public class CreateStock extends AssetsFactory{

	@Override
	public Asset createAsset(String name, String symbol, Double price) {
		return new Stock(name,symbol,price);
	}

}