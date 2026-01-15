package User;

import Assets.Asset;

public class Holding {

	private Asset asset;
	private int quantity;
	
	public Holding(Asset asset, int quantity) {
		this.asset = asset;
		this.quantity = quantity;
	}

	public Asset getAsset() {
		return asset;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
