package ptit.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Product {
    private static final long serialVersionUID = 100000000000001L;
    private Long id;
    private String name;
    private String img;
    private int price;
    private int quantity;
    private String description;
    private String expirationDate;
}
