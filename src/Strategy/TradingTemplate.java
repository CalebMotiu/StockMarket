package Strategy;

import Assets.Asset;
import User.User;

public abstract class TradingTemplate implements TradingStrategy {

    @Override
    public final boolean buy(User user, Asset asset, int quantity) {
        if (!canTrade(asset)) return false;
        preBuy(user, asset, quantity);
        boolean success = doBuy(user, asset, quantity);
        postBuy(user, asset, quantity);
        return success;
    }

    @Override
    public final boolean sell(User user, Asset asset, int quantity) {
        preSell(user, asset, quantity);
        boolean success = doSell(user, asset, quantity);
        postSell(user, asset, quantity);
        return success;
    }

    protected abstract boolean canTrade(Asset asset);
    protected abstract void preBuy(User user, Asset asset, int quantity);
    protected abstract boolean doBuy(User user, Asset asset, int quantity);
    protected abstract void postBuy(User user, Asset asset, int quantity);

    protected abstract void preSell(User user, Asset asset, int quantity);
    protected abstract boolean doSell(User user, Asset asset, int quantity);
    protected abstract void postSell(User user, Asset asset, int quantity);
}
