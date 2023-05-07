package microservice.importdetail.model;

import lombok.Data;

import java.sql.Date;

@Data
public class SupplierStats {
    private Product product;
    private Date timeStart;
    private Date timeEnd;
}
