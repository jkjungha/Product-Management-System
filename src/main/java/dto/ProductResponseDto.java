package dto;

public class ProductResponseDto {
    private boolean success;
    private String message;
    private long id;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto(boolean success, String message, long id){
        this.success = success;
        this.message = message;
        this.id = id;
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
