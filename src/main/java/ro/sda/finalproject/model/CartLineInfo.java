package ro.sda.finalproject.model;

public class CartLineInfo {

    private Product productInfo;
    private int quantity;

    public CartLineInfo(){
        this.quantity = 0;
    }
    public Product getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Product productInfo) {
        this.productInfo = productInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return this.productInfo.getPrice() * this.quantity;
    }

}
