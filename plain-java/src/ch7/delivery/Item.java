package ch7.delivery;

public abstract class Item {

    protected long price;
    protected long deliveryFee;
    protected long finalPrice;
    protected String name;

    public Item(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public void calculateFinalPrice() {
        this.finalPrice = this.price + this.deliveryFee;
    }

    public void displayInfo() {
        System.out.printf("상품명: %s, 가격: %d원\n", this.name, this.price);
    }

    public long getFinalPrice(){
        return this.finalPrice;
    }

    public abstract void calculateDeliveryFee();
}
