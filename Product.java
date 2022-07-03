package CLASSWORK28LAB;

public enum Product {
        MEAT(150,ProductState.A,25),
    DRIEDFRUIT(100,ProductState.A,35),
        GRAIN(30,ProductState.A,50),
        POWDER(20,ProductState.A,45),
        FABRIC(300,ProductState.A,40),
        PAINTING(150,ProductState.A,25);

        private double price;
        private ProductState state;
        private double value;

    Product(double price, ProductState state,double value) {
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

    @Override
    public String toString() {
        return "price=" + price + "\n " +
                "state=" + state + "\n " +
                "value=" + value + "\n ";
    }
}
