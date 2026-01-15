package Market;

import Assets.Asset;

public interface MarketState {
    boolean canTrade(Asset asset);

}
