package ptit.service;

import org.springframework.stereotype.Service;
import ptit.model.ImportDetail;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImportDetailService extends AbsService{
    public ImportDetail[] getAllBySupplierAndCreatedTime(Long supplierId, Date timeStart, Date timeEnd){
        Map<String, Object> uriVars = new HashMap<>();
        uriVars.put("supplierId", supplierId);
        uriVars.put("timeStart", timeStart);
        uriVars.put("timeEnd", timeEnd);
        return rest.getForObject(ServiceURL.IMPORT_BILL_DETAIL_SERVICE_URL + "/by-supplier", ImportDetail[].class, uriVars);
    }
}
