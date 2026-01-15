package Assets;

import java.util.ArrayList;
import java.util.List;

import Notifier.Observer;
import Notifier.Subject;

public class ObservableAsset extends Asset implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public ObservableAsset(String name, String symbol, Double price) {
        super(name, symbol, price);
    }

    @Override
    public void setPrice(Double price) {
        super.setPrice(price);
        notifyObservers();
    }

    @Override
    public void attach(Observer o) { observers.add(o); }

    @Override
    public void detach(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) o.update(this);
    }
}