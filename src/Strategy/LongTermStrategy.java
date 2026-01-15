package Strategy;

import Assets.Asset;
import Assets.Stock;
import Market.MarketClock;
import User.User;
import User.Portfolio;

public class LongTermStrategy implements TradingStrategy {

    @Override
    public boolean buy(User user, Asset asset, int quantity) {
        if (!(asset instanceof Stock)) {
            System.out.println("Long-term strategy only applies to stocks!");
            return false;
        }

        if (!MarketClock.getInstance().isStockMarketOpen()) {
            System.out.println("Stock market is closed. Cannot buy now.");
            return false;
        }

        if (Assets.ListOfStocks.getInstance().removeStock(asset.getSymbol(), quantity)) {
            user.getPortfolio().add(asset, quantity);
            System.out.println("Bought " + quantity + " of " + asset.getSymbol() + " for long-term holding.");
            return true;
        } else {
            System.out.println("Not enough stock available to buy.");
            return false;
        }
    }

    @Override
    public boolean sell(User user, Asset asset, int quantity) {
        Portfolio portfolio = user.getPortfolio();

        if (portfolio.getHoldings().get(asset.getSymbol()) == null
                || portfolio.getHoldings().get(asset.getSymbol()).getQuantity() < quantity) {
            System.out.println("Not enough stock in portfolio to sell.");
            return false;
        }

        // Check if it's a same-day sale → day trade fee
        // For simplicity, let's assume all buys today are same-day trades
        boolean isDayTrade = true; // Can be improved by tracking buy date
        double fee = 0;
        if (isDayTrade) {
            fee = asset.getPrice() * quantity * 0.05; // 5% fee
            System.out.println("Day trade penalty applied: " + fee);
        }

        portfolio.remove(asset, quantity);
        Assets.ListOfStocks.getInstance().addStock(asset, quantity);
        System.out.println("Sold " + quantity + " of " + asset.getSymbol() + " (long-term strategy).");
        return true;
    }
}
