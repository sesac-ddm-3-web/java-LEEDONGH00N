package ch7.delivery;

public class Grocery extends Item{

    public Grocery(String name, long price) {
        super(name, price);
    }

    @Override
    public void calculateDeliveryFee() {
        this.deliveryFee = 5000;
    }
}
