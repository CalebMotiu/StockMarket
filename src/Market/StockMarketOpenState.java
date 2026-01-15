package Market;

import Assets.Asset;
import Assets.Stock;

public class StockMarketOpenState implements MarketState {
    public boolean canTrade(Asset asset) {
        return asset instanceof Stock && MarketClock.getInstance().isStockMarketOpen();
    }
}
