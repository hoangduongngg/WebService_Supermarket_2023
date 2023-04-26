package microservice.controller;

import microservice.model.ImportBillDetail;
import microservice.repository.ImportBillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/import-bill-detail", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ImportBillDetailRestController {
    private ImportBillDetailRepository importBillDetailRepository;

    @Autowired
    public ImportBillDetailRestController(ImportBillDetailRepository importBillDetailRepository){
        this.importBillDetailRepository = importBillDetailRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public int save(@RequestBody List<ImportBillDetail> details){
        return importBillDetailRepository.saveAll(details).size();
    }

    @PostMapping(value = "/delete/cascade", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int supplierCascadeDelete(@RequestBody Map<String, Object> data) {
        Long supplierId = (Long) data.get("id");
        return (int) importBillDetailRepository.deleteAllByImportBillSupplierId(supplierId);
    }
}
