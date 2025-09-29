package sec7.delivery;

public class Furniture extends Item{

    public Furniture(String name, long price) {
        super(name, price);
    }

    @Override
    public void calculateDeliveryFee() {
        int extraFee = (int) (this.price * 0.05);
        this.deliveryFee = 3000 + extraFee;
    }
}
