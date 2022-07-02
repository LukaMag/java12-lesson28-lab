package CLASSWORK28LAB;

public enum City {
    MOSCOW(1),
    ALMATA(2),
    BISHKEK(3),
    OSH(4),
    TASHKENT(5),
    DUSHANBE(6);

    private int id;

    public int getId() {
        return id;
    }

    City(int id) {
        this.id = id;
    }

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
