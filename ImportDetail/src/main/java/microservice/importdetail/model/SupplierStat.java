package microservice.importdetail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class SupplierStat extends Supplier{
    private List<ImportDetail> details;
    @JsonIgnore
    public int totalQuantity(){
        return details.stream().map(ImportDetail::getQuantity).reduce(0, Integer::sum);
    }
    public SupplierStat(Long id){
        this.id = id;
        details = new ArrayList<>();
    }
}
