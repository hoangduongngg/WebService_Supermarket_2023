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
@Table(name = "tblorder")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "paymentType")
    private String paymentType;

    @Column(name = "orderDate")
    private LocalDate orderDate;

    @Column(name = "paymentDate")
    private LocalDate paymentDate;

    @Column(name = "cancelDate")
    private LocalDate cancelDate;

    @Column(name = "deliveryDate")
    private LocalDate deliveryDate;

    @Column(name = "reasonCancel")
    private String reasonCancel;

    @Column(name = "statusDelivery")
    private String statusDelivery;

    @Column(name = "statusOrder")
    private String statusOrder;

    @Column(name = "note")
    private String note;

    @Column(name = "tblCustomerid")
    private Integer tblCustomerid;

    @Column(name = "tblShipperid")
    private Integer tblShipperid;
}
