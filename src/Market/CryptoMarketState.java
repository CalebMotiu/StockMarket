package Market;

import Assets.Asset;
import Assets.Crypto;

public class CryptoMarketState implements MarketState {
    public boolean canTrade(Asset asset) {
        return asset instanceof Crypto;
    }
}
