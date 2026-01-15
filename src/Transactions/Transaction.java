package Transactions;

import Assets.Asset;
import java.time.LocalDateTime;

public class Transaction {
    private Asset asset;
    private int quantity;
    private double price;
    private LocalDateTime date;
    private String type;

    public Transaction(Asset asset, int quantity, double price, String type) {
        this.asset = asset;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return type + " | " + asset.getSymbol() + " | Qty: " + quantity + " | Price: " + price + " | Date: " + date;
    }
}
