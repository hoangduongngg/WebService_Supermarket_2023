package ptit.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class SupplierStatRequest {
    private Product product;
    private Date timeStart;
    private Date timeEnd;
}
