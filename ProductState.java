package CLASSWORK28LAB;

public enum ProductState {

    A(1.2),
    B(0.95),
    C(0.55),
    D(0.25),
    F(0.1);

    private double priceCoeff;

    ProductState(double priceCoeff) {
        this.priceCoeff = priceCoeff;
    }

    public double getPriceCoeff() {
        return priceCoeff;
    }
}
