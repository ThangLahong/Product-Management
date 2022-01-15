// Class Product chứa thông tin của sản phẩm
public class Product {
    private String bCode;
    private String title;
    private int quantity;
    private double price;

    // Constructor mặc định
    public Product() {
    }

    // Tạo constructor để khởi tạo sản phẩm
    public Product(String bCode, String title, int quantity, double price) {
        this.bCode = bCode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    // Tạo các getter setter
    public String getBCode() {
        return this.bCode;
    }

    public String getTitle() {
        return this.title;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setBCode(String bCode) {
        this.bCode = bCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override hàm toString để hiển thị thông tin sản phẩm
    @Override
    public String toString() {
        return "    " + this.bCode + "    |    " + this.title + "    |    " + this.quantity + "    |    " + this.price + "\n";
    }
}
