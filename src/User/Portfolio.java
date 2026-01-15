package User;

import java.util.HashMap;
import java.util.Map;

import Assets.Asset;

public class Portfolio {
	private Map<String,Holding> holdings = new HashMap<>();
	
	public void add(Asset asset, int quantity) {
		holdings.merge(asset.getSymbol(),
	            new Holding(asset, quantity),
	            (h, n) -> { h.setQuantity(h.getQuantity() + quantity); return h;});
	}
	
	public void remove(Asset asset, int quantity) {
		Holding h = holdings.get(asset.getSymbol());
		if (h != null)
			if (h.getQuantity() >= quantity)
				h.setQuantity(h.getQuantity() - quantity);
	}
	
	public void print() {
        holdings.values().forEach(h ->
            System.out.println(h.getAsset().getSymbol() + ": " + h.getQuantity()));
    }

	public Map<String, Holding> getHoldings() {
        return holdings;
    }
}
