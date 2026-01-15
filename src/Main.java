import Assets.ListOfStocks;
import Assets.ObservableAsset;
import Mediator.ConcreteMarketMediator;
import Strategy.DayTradingStrategy;
import User.User;
import Assets.Asset;

public class Main {
    public static void main(String[] args) {
        Asset apple = new ObservableAsset("Apple Inc.", "AAPL", 150.0);
        Asset tesla = new ObservableAsset("Tesla Inc.", "TSLA", 700.0);
        Asset bitcoin = new ObservableAsset("Bitcoin", "BTC", 30000.0);

        ListOfStocks market = ListOfStocks.getInstance();
        market.addStock(apple, 100);
        market.addStock(tesla, 50);
        market.addStock(bitcoin, 10);

        User user1 = new User("JohnDoe");
        User user2 = new User("JaneDoe");

        ((ObservableAsset)apple).attach(user1);
        ((ObservableAsset)tesla).attach(user1);
        ((ObservableAsset)bitcoin).attach(user1);

        ConcreteMarketMediator mediator = new ConcreteMarketMediator();
        TradingFacade facade = new TradingFacade();

        user1.setStrategy(new DayTradingStrategy());

        System.out.println("\n--- User buys 5 AAPL ---");
        facade.buyAsset(user1, apple, 5);

        System.out.println("\n--- User sells 2 AAPL ---");
        facade.sellAsset(user1, apple, 2);

        System.out.println("\n--- Transactions ---");
        user1.printTransactions();

        System.out.println("\n--- Update stock price to trigger notification ---");
        apple.setPrice(155.0);

        System.out.println("\n--- Final Market ---");
        market.displayStocks();
    }
}
