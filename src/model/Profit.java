package model;

public class Profit {
    private int count;
    private double price;

    public Profit(int count, double price) {
        this.count = count;
        this.price = price;
    }

    @Override
    public String toString() {
        return "sold: " + count + " books "+ "for a total price " + price;
    }
}
