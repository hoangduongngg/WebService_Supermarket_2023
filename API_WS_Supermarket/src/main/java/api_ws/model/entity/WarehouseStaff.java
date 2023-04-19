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
@Table(name = "tblwarehousestaff")
public class WarehouseStaff {
    @Id
    @Column(name = "tblMemberid")
    private Integer tblMemberid;

}
