package User;

import Transactions.Transaction;
import java.util.ArrayList;
import java.util.List;

import Assets.Asset;
import Notifier.Observer;
import Strategy.TradingStrategy;

public class User implements Observer{
    private String username;
    private Portfolio portfolio = new Portfolio();
    private TradingStrategy strategy;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public User(String username) { 
    	this.username = username;
    }

    public void setStrategy(TradingStrategy strategy) { 
    	this.strategy = strategy; 
    }
    public TradingStrategy getStrategy() { 
    	return strategy; 
    }
    public Portfolio getPortfolio() { 
    	return portfolio; 
    }

    public void addTransaction(Transaction t) { 
    	transactionHistory.add(t); 
    }
    public void printTransactions() {
        if(transactionHistory.isEmpty()) System.out.println("No transactions yet.");
        else transactionHistory.forEach(System.out::println);
    }
    
    @Override
    public void update(Asset asset) {
        System.out.println("Notification for " + username + ": " + asset.getSymbol() + " price changed to " + asset.getPrice());
    }
}
