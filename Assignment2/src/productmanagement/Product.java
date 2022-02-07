package productmanagement;

public class Product {

    // declare variables of product
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;

    // define constructors to create product object
    public Product(String productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // getters & setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // modify toString method to customize the string representation of the product object
    @Override
    public String toString() {

        //formatting with left justifying within specified width
        return String.format("%-15s| %-15s| %-15d|  %.1f", productId, productName, quantity, unitPrice);
    }
}
