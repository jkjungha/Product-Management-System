package dto;

public class ProductRequestDto {
    private String command;
    private long id;
    private String name;
    private int price;
    private int stock;

    public ProductRequestDto(String command, Long id){
        this.command = command;
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
