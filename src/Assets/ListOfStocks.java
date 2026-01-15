package Assets;

import java.util.HashMap;
import java.util.Map;

import User.Holding;

public class ListOfStocks {
    private static ListOfStocks instance = new ListOfStocks();
    private Map<String, Holding> listOfStocks = new HashMap<>();

    private ListOfStocks() {}

    public static ListOfStocks getInstance() {
        return instance;
    }

    public void addStock(Asset stock, int quantity) {
        if (listOfStocks.containsKey(stock.getSymbol())) {
        	Holding entry = listOfStocks.get(stock.getSymbol());
            entry.setQuantity(entry.getQuantity() + quantity);
        } else {
            listOfStocks.put(stock.getSymbol(), new Holding(stock, quantity));
        }
    }

    public boolean removeStock(String symbol, int quantity) {
        if (!listOfStocks.containsKey(symbol)) return false;
        Holding entry = listOfStocks.get(symbol);
        if (entry.getQuantity() < quantity) return false;

        entry.setQuantity(entry.getQuantity() - quantity);
        if (entry.getQuantity() == 0) listOfStocks.remove(symbol);
        return true;
    }

    public Double getPrice(String symbol) {
        if (!listOfStocks.containsKey(symbol)) return (double) 0;
        return listOfStocks.get(symbol).getAsset().getPrice();
    }

    public void displayStocks() {
        if (listOfStocks.isEmpty()) {
            System.out.println("Nu există stock-uri disponibile.");
            return;
        }

        System.out.println("Stock-uri disponibile:");
        for (Map.Entry<String, Holding> entry : listOfStocks.entrySet()) {
            String symbol = entry.getKey();
            Holding stockEntry = entry.getValue();
            System.out.println(symbol + " | Cantitate: " + stockEntry.getQuantity() 
                               + " | Preț: " + stockEntry.getAsset().getPrice());
        }
    }
}
