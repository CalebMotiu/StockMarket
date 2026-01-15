package commands;

import Assets.Asset;
import Assets.ListOfStocks;
import User.User;

public class CommandHandler {

    public static void buy(User user, Asset asset, int quantity) {
        if (user.getStrategy() == null) {
            System.out.println("No trading strategy set for user!");
            return;
        }
        user.getStrategy().buy(user, asset, quantity);
    }

    public static void sell(User user, Asset asset, int quantity) {
        if (user.getStrategy() == null) {
            System.out.println("No trading strategy set for user!");
            return;
        }
        user.getStrategy().sell(user, asset, quantity);
    }
}
