package CLASSWORK28LAB;

public enum ProductState {

    A(1,1.2),
    B(2,0.95),
    C(3,0.55),
    D(4,0.25),
    F(5,0.1);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private double priceCoeff;

    ProductState(int id, double priceCoeff) {
        this.id = id;
        this.priceCoeff = priceCoeff;
    }

    public double getPriceCoeff() {
        return priceCoeff;
    }
}
