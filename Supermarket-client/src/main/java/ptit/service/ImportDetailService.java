package ptit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import ptit.model.ImportDetail;
import ptit.model.SupplierStat;

import java.net.URI;
import java.sql.Date;


@Service
public class ImportDetailService extends AbsService{
    public SupplierStat[] getSupplierStats(Long productId, Date timeStart, Date timeEnd){
        URI uri = UriComponentsBuilder.fromHttpUrl(ServiceURL.IMPORT_DETAIL_SERVICE_URL + "/statistic/supplier")
                .queryParam("productId", productId)
                .queryParam("timeStart", timeStart)
                .queryParam("timeEnd", timeEnd)
                .build().toUri();
        return rest.getForObject(uri, SupplierStat[].class);
    }
    public ImportDetail[] getSupplierStatDetail(Long supplierId, Long productId, Date timeStart, Date timeEnd){
        URI uri = UriComponentsBuilder.fromHttpUrl(ServiceURL.IMPORT_DETAIL_SERVICE_URL + "/statistic/supplier/detail")
                .queryParam("supplierId", supplierId)
                .queryParam("productId", productId)
                .queryParam("timeStart", timeStart)
                .queryParam("timeEnd", timeEnd)
                .build().toUri();
        return rest.getForObject(uri, ImportDetail[].class);
    }
}
