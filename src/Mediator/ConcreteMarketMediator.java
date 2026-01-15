package Mediator;

import Assets.Asset;
import User.User;
import commands.CommandHandler;

public class ConcreteMarketMediator implements MarketMediator {
	@Override
    public void buy(User user, Asset asset, int quantity) {
        CommandHandler.buy(user, asset, quantity);
    }

    @Override
    public void sell(User user, Asset asset, int quantity) {
        CommandHandler.sell(user, asset, quantity);
    }
}
