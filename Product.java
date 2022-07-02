package CLASSWORK28LAB;

public enum Product {
        MEAT(500,ProductState.A,15),
    DRIEDFRUIT(340,ProductState.A,25),
        GRAIN(100,ProductState.A,35),
        POWDER(60,ProductState.A,30),
        FABRIC(700,ProductState.A,20),
        PAINTING(450,ProductState.A,15);




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
}
