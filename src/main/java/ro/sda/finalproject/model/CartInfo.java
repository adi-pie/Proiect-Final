package ro.sda.finalproject.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

    private int orderNum;
    private User customerInfo;
    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

    public CartInfo(){}


    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public User getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(User customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<CartLineInfo> getCartLines() {
        return this.cartLines;
    }

    private CartLineInfo findLineByCode(int code) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProductInfo().getProduct_id() == code) {
                return line;
            }
        }
        return null;
    }

    public void addProduct(Product productInfo, int quantity) {
        CartLineInfo line = this.findLineByCode(productInfo.getProduct_id());

        if (line == null) {
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setProductInfo(productInfo);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }

    public void validate() {

    }

    public void updateProduct(int code, int quantity) {
        CartLineInfo line = this.findLineByCode(code);

        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }

    public void removeProduct(Product productInfo) {
        CartLineInfo line = this.findLineByCode(productInfo.getProduct_id());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }

    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }


    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }

    public double getAmountTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }

    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getProductInfo().getProduct_id(), line.getQuantity());
            }
        }

    }

}
