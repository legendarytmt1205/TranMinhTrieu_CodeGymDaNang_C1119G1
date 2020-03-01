
package java.entity;


public class ItemCart {
    private Product product;
    private int quatity;

    public ItemCart() {
    }

    public ItemCart(Product product, int quatity) {
        this.product = product;
        this.quatity = quatity;
    }

    public java.entity.Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }
    
    
}
