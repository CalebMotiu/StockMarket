import Assets.Asset;
import Strategy.TradingStrategy;
import User.User;

public class TradingFacade {
	public void buyAsset(User user, Asset asset, int quantity) {
        if (user.getStrategy() != null)
            user.getStrategy().buy(user, asset, quantity);
        else System.out.println("No strategy set for user.");
    }

    public void sellAsset(User user, Asset asset, int quantity) {
        if (user.getStrategy() != null)
            user.getStrategy().sell(user, asset, quantity);
        else System.out.println("No strategy set for user.");
    }

    public void switchStrategy(User user, TradingStrategy strategy) {
        user.setStrategy(strategy);
        System.out.println("Strategy switched for " + user.getPortfolio());
    }
}
