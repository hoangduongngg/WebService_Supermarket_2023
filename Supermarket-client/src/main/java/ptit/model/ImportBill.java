package ptit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ImportBill {
    private static final long serialVersionUID = 100000000000002L;
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    private Supplier supplier;
    private List<ImportBillDetail> details;
}
