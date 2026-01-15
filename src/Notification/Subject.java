package Notification;

import Assets.Asset;

public interface Subject {
    void attach(Observer o);
    void notifyObservers(Asset asset);
}