package microservice.service;

import microservice.WarehouseApplication;
import microservice.chain.ImportGoods;
import microservice.model.ImportBill;
import org.springframework.stereotype.Service;

@Service
public class ImportBillDetailService extends AbsService implements ImportGoods {
    @Override
    public boolean save(ImportBill importBill) {
        Integer response = rest.postForObject(WarehouseApplication.IMPORT_BILL_DETAIL_SERVICE_URL, importBill.getDetails(), Integer.class);
        return response == importBill.getDetails().size();
    }
}
