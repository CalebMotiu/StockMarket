package Mediator;

import Assets.Asset;
import User.User;

public interface  MarketMediator {
    void buy(User user, Asset asset, int quantity);
    void sell(User user, Asset asset, int quantity);
}
