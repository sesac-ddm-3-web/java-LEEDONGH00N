package sec7.delivery;

public class NormalItem extends Item{

    public NormalItem(String name, long price) {
        super(name, price);
    }

    @Override
    public void calculateDeliveryFee() {
        this.deliveryFee = 3000;
    }
}
