package ptit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SupplierStat extends Supplier{
    private List<ImportDetail> details;
    @JsonIgnore
    public int totalQuantity(){
        return details.stream().map(ImportDetail::getQuantity).reduce(0, Integer::sum);
    }
    @JsonIgnore
    public String totalAmount(){
        return String.format("%.2f", details.stream().map(detail -> detail.getQuantity() * detail.getUnitPrice()).reduce(0f, Float::sum));
    }
}
