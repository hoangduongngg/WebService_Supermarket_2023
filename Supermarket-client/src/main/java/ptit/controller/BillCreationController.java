package ptit.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ptit.controller.command.ImportDetailInjector;
import ptit.model.*;
import ptit.service.ProductService;
import ptit.service.SupplierService;
import ptit.service.WarehouseService;

import java.sql.Date;

@Controller
@RequestMapping("/warehouse/import")
public class BillCreationController {
    private final WarehouseService warehouseService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private final ImportDetailInjector importDetailInjector;

    @Autowired
    public BillCreationController(WarehouseService warehouseService, SupplierService supplierService, ProductService productService, ImportDetailInjector importDetailInjector) {
        this.warehouseService = warehouseService;
        this.supplierService = supplierService;
        this.productService = productService;
        this.importDetailInjector = importDetailInjector;
    }

    @GetMapping("/new-bill")
    public String showNewBillView(Model model, HttpSession session){
        if (session.getAttribute("importBill") == null){
            ImportBill importBill = new ImportBill();
            importBill.setCreator((WarehouseWorker) session.getAttribute("user"));
            session.setAttribute("importBill", importBill);
        }
        model.addAttribute("suppliers", supplierService.getAll());
        model.addAttribute("products", productService.getAll());

        Product productProxy = new Product();
        ImportDetail detailProxy = new ImportDetail();
        detailProxy.setProduct(productProxy);

        model.addAttribute("detail", detailProxy);
        return "warehouse/import/CreateImportBill";
    }

    @PostMapping("/new-bill/set-supplier")
    public String setSupplier(@RequestParam("supplierId") Long supplierId, @SessionAttribute ImportBill importBill){
        importBill.setSupplier(supplierService.getById(supplierId));
        return "redirect:../new-bill";
    }

    @PostMapping("/new-bill/add-detail")
    public String addDetail(@ModelAttribute("detail") ImportDetail detail, @SessionAttribute ImportBill importBill){
        if (detail.getProduct().getId() != null){
            importDetailInjector.addDetail(detail, importBill);
        }
        return "redirect:../new-bill";
    }

    @PostMapping("/new-bill/undo")
    public String undo(){
        importDetailInjector.removeMostRecentDetail();
        return "redirect:../new-bill";
    }

    @PostMapping("/new-bill/save")
    public String save(HttpSession session, Model model){
        ImportBill importBill = (ImportBill) session.getAttribute("importBill");
        importBill.setCreatedTime(new Date(new java.util.Date().getTime()));
        warehouseService.saveImportBill(importBill);
        session.removeAttribute("importBill");
        model.addAttribute("importBill", importBill);
        return "warehouse/import/SavedBill";
    }
}
