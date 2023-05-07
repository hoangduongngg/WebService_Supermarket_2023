package microservice.importdetail.controller;

import microservice.importdetail.model.ImportBill;
import microservice.importdetail.model.ImportDetail;
import microservice.importdetail.model.entity.ImportDetailEntity;
import microservice.importdetail.repository.ImportDetailRepoAdapter;
import microservice.importdetail.repository.ImportDetailRepository;
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
    @GetMapping("/by-supplier")
    public List<ImportDetailEntity> getAllBySupplierAndCreatedTime(
            @RequestParam("supplierId") Long supplierId,
            @RequestParam("timeStart") Date timeStart,
            @RequestParam("timeEnd") Date timeEnd){
        System.out.println(supplierId + " " + timeEnd);
        return null;
    }
//    @GetMapping("/by-supplier")
//    public List<ImportDetailEntity> getAllBySupplierAndCreatedTime(@RequestBody Map<String, Object> data){
//        Long supplierId = data.get("supplierId");
//        Long
//    }
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
