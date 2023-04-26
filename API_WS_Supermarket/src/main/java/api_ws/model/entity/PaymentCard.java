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
@Table(name = "tblpaymentcard")
public class PaymentCard {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "cardCVV")
    private String cardCvv;

    @Column(name = "cardName")
    private String cardName;

    @Column(name = "cardOutDate")
    private LocalDate cardOutDate;

}
