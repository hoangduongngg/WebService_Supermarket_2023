package ptit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class ImportBill {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    private Supplier supplier;
    private List<ImportDetail> details;
    private WarehouseWorker creator;
    public ImportBill() {
        details = new ArrayList<>();
    }
    @JsonIgnore
    public String getTotalPrice(){
        return String.format("%.2f", details.stream().map(detail -> detail.getQuantity() * detail.getUnitPrice()).reduce(0f, Float::sum));
    }
}
