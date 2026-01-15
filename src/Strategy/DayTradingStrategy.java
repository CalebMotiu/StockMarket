package Strategy;

import Assets.Asset;
import Assets.ListOfStocks;
import Assets.Stock;
import User.User;
import Transactions.Transaction;
import Market.MarketClock;

public class DayTradingStrategy extends TradingTemplate {

    @Override
    protected boolean canTrade(Asset asset) {
        return asset instanceof Stock && MarketClock.getInstance().isStockMarketOpen();
    }

    @Override
    protected void preBuy(User user, Asset asset, int quantity) {
        if (!(asset instanceof Stock)) {
            System.out.println("Day trading allowed only for stocks!");
        }
    }

    @Override
    protected boolean doBuy(User user, Asset asset, int quantity) {
        // Remove from market
        if (!ListOfStocks.getInstance().removeStock(asset.getSymbol(), quantity)) {
            System.out.println("Not enough stock in market to buy.");
            return false;
        }
        // Add to user's portfolio
        user.getPortfolio().add(asset, quantity);
        // Record transaction
        user.addTransaction(new Transaction(asset, quantity, asset.getPrice(), "BUY"));
        System.out.println("Bought " + quantity + " of " + asset.getSymbol() + " (Day Trading)");
        return true;
    }

    @Override
    protected void postBuy(User user, Asset asset, int quantity) {
        // Nothing extra for post-buy
    }

    @Override
    protected void preSell(User user, Asset asset, int quantity) {
        // Check if user owns enough
        if (user.getPortfolio().getHoldings().get(asset.getSymbol()) == null ||
                user.getPortfolio().getHoldings().get(asset.getSymbol()).getQuantity() < quantity) {
            System.out.println("Not enough stock in portfolio to sell.");
        }
    }

    @Override
    protected boolean doSell(User user, Asset asset, int quantity) {
        // Remove from portfolio
        user.getPortfolio().remove(asset, quantity);
        // Add back to market
        ListOfStocks.getInstance().addStock(asset, quantity);
        // Record transaction
        user.addTransaction(new Transaction(asset, quantity, asset.getPrice(), "SELL"));
        System.out.println("Sold " + quantity + " of " + asset.getSymbol() + " (Day Trading)");
        return true;
    }

    @Override
    protected void postSell(User user, Asset asset, int quantity) {
        // Nothing extra for post-sell
    }
}
