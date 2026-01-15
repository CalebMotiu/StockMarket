package Strategy;

import Assets.Asset;
import User.User;

public class ThresholdStrategy implements TradingStrategy {
    private double buyThreshold;
    private double sellThreshold;

    public ThresholdStrategy(double buyThreshold, double sellThreshold) {
        this.buyThreshold = buyThreshold;
        this.sellThreshold = sellThreshold;
    }

    @Override
    public boolean buy(User user, Asset asset, int quantity) {
        if (asset.getPrice() <= buyThreshold) {
            return user.getStrategy().buy(user, asset, quantity); // delegate actual buy
        }
        System.out.println(asset.getSymbol() + " price too high to auto-buy.");
        return false;
    }

    @Override
    public boolean sell(User user, Asset asset, int quantity) {
        if (asset.getPrice() >= sellThreshold) {
            return user.getStrategy().sell(user, asset, quantity); // delegate actual sell
        }
        System.out.println(asset.getSymbol() + " price too low to auto-sell.");
        return false;
    }
}
