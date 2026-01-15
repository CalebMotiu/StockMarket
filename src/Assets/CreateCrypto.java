package Assets;

public class CreateCrypto extends AssetsFactory{

	@Override
	public Asset createAsset(String name, String symbol, Double price) {
		return new Crypto(name,symbol,price);
	}

}
