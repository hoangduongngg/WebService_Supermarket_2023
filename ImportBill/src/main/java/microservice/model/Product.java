package microservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String img;
    private int price;
    private int quantity;
    private String description;
    private String expirationDate;
}
