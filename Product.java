package CLASSWORK28LAB;

public class Product{
        private String name;
        private double price;
        private ProductState state;
        private double value;

    public Product(String name, double price, ProductState state, double value) {
        this.name = name;
        this.price = price;
        this.state = state;
        this.value = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductState getState() {
        return state;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "price=" + price + "\n " +
                "state=" + state + "\n " +
                "value=" + value + "\n ";
    }
}
