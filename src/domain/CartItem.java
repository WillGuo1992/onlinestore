package domain;

/**
 * @description: 购物单品
 * @author: Will.Guo
 * @create: 2018-06-14 19:37
 **/
public class CartItem {
    private Product product;
    private int count;
    private double itemTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getItemTotal() {
        itemTotal = count * product.getShop_price();
        return itemTotal;
    }

}
