package Assets;

public abstract class AssetsFactory {

	public abstract Asset createAsset(String name, String symbol, Double price);
}
