package api_ws.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblcustomer")
public class Customer {
    @Id
    @Column(name = "tblMemberid")
    private Integer tblMemberid;

    @Column(name = "tblPaymentCardid")
    private Integer tblPaymentCardid;

   }