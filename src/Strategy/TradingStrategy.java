
package Strategy;

import Assets.Asset;
import User.User;

public interface TradingStrategy {
    boolean buy(User user, Asset asset, int quantity);
    boolean sell(User user, Asset asset, int quantity);
}
