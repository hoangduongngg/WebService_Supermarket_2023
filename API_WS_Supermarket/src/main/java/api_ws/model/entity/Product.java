package api_ws.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblproduct")
public class Product {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "mfgDate")
    private LocalDate mfgDate;

    @Column(name = "expDate")
    private LocalDate expDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "tblWareHouseid")
    private Integer tblWareHouseid;

}
