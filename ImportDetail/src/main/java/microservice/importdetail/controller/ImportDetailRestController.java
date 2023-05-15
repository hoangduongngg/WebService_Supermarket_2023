package microservice.importdetail.controller;

import microservice.importdetail.model.*;
import microservice.importdetail.repository.ImportDetailRepoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/import-detail", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ImportDetailRestController {
    private ImportDetailRepoAdapter importDetailRepoAdapter;

    @Autowired
    public ImportDetailRestController(ImportDetailRepoAdapter importDetailRepoAdapter){
        this.importDetailRepoAdapter = importDetailRepoAdapter;
    }
    @GetMapping("/statistic/supplier")
    public List<SupplierStat> getSupplierStats(
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "timeStart") Date timeStart,
            @RequestParam(name = "timeEnd") Date timeEnd
    ){
        return this.importDetailRepoAdapter.getSupplierStats(productId, timeStart, timeEnd);
    }
    @GetMapping("/statistic/supplier/detail")
    public List<ImportDetail> getSupplierStatDetail(
            @RequestParam(name = "supplierId") Long supplierId,
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "timeStart") Date timeStart,
            @RequestParam(name = "timeEnd") Date timeEnd
    ){
        return this.importDetailRepoAdapter.getSupplierStatDetail(supplierId, productId, timeStart, timeEnd);
    }
    @PostMapping(value = "/by-bill/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public long saveImportBill(@RequestBody ImportBill importBill){
        return importDetailRepoAdapter.saveImportBill(importBill);
    }

    @PostMapping(value = "/by-supplier/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public long deleteBySupplier(@RequestBody Long supplierId) {
        return importDetailRepoAdapter.deleteAllBySupplierId(supplierId);
    }
}
