package Strategy;

import Assets.Asset;
import Assets.Stock;
import Market.MarketClock;
import User.User;
import User.Portfolio;

public class DayTradingStrategy implements TradingStrategy {

    @Override
    public boolean buy(User user, Asset asset, int quantity) {
        if (!(asset instanceof Stock)) {
            System.out.println("Day trading is allowed only for stocks!");
            return false;
        }

        // Check if market is open
        if (!MarketClock.getInstance().isStockMarketOpen()) {
            System.out.println("Stock market is closed. Cannot buy now.");
            return false;
        }

        // Attempt to buy from ListOfStocks
        if (Assets.ListOfStocks.getInstance().removeStock(asset.getSymbol(), quantity)) {
            user.getPortfolio().add(asset, quantity);
            System.out.println("Bought " + quantity + " of " + asset.getSymbol() + " for day trading.");
            return true;
        } else {
            System.out.println("Not enough stock available to buy.");
            return false;
        }
    }

    @Override
    public boolean sell(User user, Asset asset, int quantity) {
        Portfolio portfolio = user.getPortfolio();

        // Check if user owns enough
        if (portfolio == null || portfolio.getHoldings().get(asset.getSymbol()) == null
                || portfolio.getHoldings().get(asset.getSymbol()).getQuantity() < quantity) {
            System.out.println("Not enough stock in portfolio to sell.");
            return false;
        }

        // Sell stock
        portfolio.remove(asset, quantity);
        Assets.ListOfStocks.getInstance().addStock(asset, quantity);
        System.out.println("Sold " + quantity + " of " + asset.getSymbol() + " (day trading).");
        return true;
    }
}
