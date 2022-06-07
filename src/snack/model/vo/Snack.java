package snack.model.vo;

public class Snack {


    private String name;    // 간식 이름
    private int price;      // 간식 가격
    private int stock;      // 간식 재고

    public Snack(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String inform() {
        return String.format("과자 이름: %s / 과자 가격: %d / 과자 재고: %d", name, price, stock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
