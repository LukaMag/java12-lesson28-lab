package CLASSWORK28LAB;

import java.util.List;

public class Merchant {

    private double value;
    private double cash;
    private int speed;
    private List<Product> products;
    private List<Event> eventList;

    public Merchant(double value, double cash, int speed, List<Product> products, List<Event> eventList) {
        this.value = value;
        this.cash = cash;
        this.speed = speed;
        this.products = products;
        this.eventList = eventList;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
