package User;

import Strategy.TradingStrategy;

public class User {
	private String username;
    private Portfolio portfolio = new Portfolio();
    private TradingStrategy strategy;

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
}
