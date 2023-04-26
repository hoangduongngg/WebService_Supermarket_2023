package ptit.service;

import org.springframework.stereotype.Service;
import ptit.model.ImportBill;

@Service
public class WarehouseService extends AbsService{
    public void save(ImportBill importBill){
        rest.postForObject("http://localhost:8084/api/warehouse/import", importBill, Integer.class);
    }
}
