
import Assets.*;
import Market.*;
import User.*;
import commands.CommandHandler;
import Strategy.*;

public class Main {
    public static void main(String[] args) {
        // --- Step 1: Create stocks and crypto ---
        AssetsFactory stockFactory = new CreateStock();
        AssetsFactory cryptoFactory = new CreateCrypto();

        Asset apple = stockFactory.createAsset("Apple Inc.", "AAPL", 150.0);
        Asset tesla = stockFactory.createAsset("Tesla Inc.", "TSLA", 700.0);
        Asset bitcoin = cryptoFactory.createAsset("Bitcoin", "BTC", 30000.0);

        // --- Step 2: Add assets to ListOfStocks (market inventory) ---
        ListOfStocks market = ListOfStocks.getInstance();
        market.addStock(apple, 100);
        market.addStock(tesla, 50);
        market.addStock(bitcoin, 10);

        System.out.println("=== Available Stocks in Market ===");
        market.displayStocks();

        // --- Step 3: Create a user ---
        User user = new User("JohnDoe");

        // --- Step 4: Set trading strategy ---
        // Example: Day trading strategy
        user.setStrategy(new DayTradingStrategy());

        // --- Step 5: User buys stocks ---
        System.out.println("\n--- User buys 5 AAPL ---");
        CommandHandler.buy(user, apple, 5);

        System.out.println("\n--- User buys 2 TSLA ---");
        CommandHandler.buy(user, tesla, 2);

        System.out.println("\n--- User tries to buy 1 BTC (crypto) using day trading ---");
        CommandHandler.buy(user, bitcoin, 1); // Should fail because DayTradingStrategy only allows stocks

        // --- Step 6: Show updated portfolio and market ---
        System.out.println("\n=== User Portfolio ===");
        user.getPortfolio().print();

        System.out.println("\n=== Available Stocks in Market After Buying ===");
        market.displayStocks();

        // --- Step 7: User sells a stock ---
        System.out.println("\n--- User sells 2 AAPL ---");
        CommandHandler.sell(user, apple, 2);

        System.out.println("\n=== User Portfolio After Selling ===");
        user.getPortfolio().print();

        System.out.println("\n=== Available Stocks in Market After Selling ===");
        market.displayStocks();

        // --- Step 8: Switch strategy to LongTermStrategy ---
        System.out.println("\n--- Switching user strategy to Long-Term Strategy ---");
        user.setStrategy(new LongTermStrategy());

        System.out.println("\n--- User buys 3 TSLA using Long-Term Strategy ---");
        CommandHandler.buy(user, tesla, 3);

        System.out.println("\n=== Final User Portfolio ===");
        user.getPortfolio().print();

        System.out.println("\n=== Final Available Stocks in Market ===");
        market.displayStocks();
    }
}
