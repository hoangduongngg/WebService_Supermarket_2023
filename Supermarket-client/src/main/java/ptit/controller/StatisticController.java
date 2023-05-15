package ptit.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ptit.model.Product;
import ptit.model.Supplier;
import ptit.model.SupplierStat;
import ptit.model.SupplierStatRequest;
import ptit.service.ImportDetailService;
import ptit.service.ProductService;
import ptit.service.SupplierService;

import java.sql.Date;
import java.util.Arrays;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
    private final ProductService productService;
    private final ImportDetailService importDetailService;
    private final SupplierService supplierService;


    @Autowired
    public StatisticController(ProductService productService, ImportDetailService importDetailService, SupplierService supplierService) {
        this.productService = productService;
        this.importDetailService = importDetailService;
        this.supplierService = supplierService;
    }

//    @GetMapping("/supplier")
//    public String showSupplierStatisticView(
//            @ModelAttribute("product") Product product,
//            @RequestParam(value = "timeStart", required = false) Date timeStart,
//            @RequestParam(value = "timeEnd", required = false) Date timeEnd,
//            Model model
//    ){
//        model.addAttribute("products", productService.getAll());
//        if (product != null && product.getId() != null && timeStart != null && timeEnd != null){
//            SupplierStat[] stats = importDetailService.getSupplierStats(product.getId(), timeStart, timeEnd);
//            for (SupplierStat stat:stats){
//                Supplier supplier = supplierService.getById(stat.getId());
//                stat.setName(supplier.getName());
//                stat.setPhoneNumber(supplier.getPhoneNumber());
//            }
//            model.addAttribute("stats", stats);
//            model.addAttribute("product", product);
//            model.addAttribute("timeStart", timeStart);
//            model.addAttribute("timeEnd", timeEnd);
//        }
//        else {
//            model.addAttribute("product", new Product());
//        }
//        return "statistic/SupplierStatistic";
//    }

    @GetMapping("/supplier")
    public String showSupplierStatisticView(
            @ModelAttribute("statRequest") SupplierStatRequest supplierStatRequest,
            Model model,
            HttpSession session
    ){
        model.addAttribute("products", productService.getAll());
        if (
            supplierStatRequest != null &&
            supplierStatRequest.getProduct() != null &&
            supplierStatRequest.getProduct().getId() != null &&
            supplierStatRequest.getTimeStart() != null &&
            supplierStatRequest.getTimeEnd() != null
        ){
            SupplierStat[] stats = importDetailService.getSupplierStats(
                    supplierStatRequest.getProduct().getId(), supplierStatRequest.getTimeStart(), supplierStatRequest.getTimeEnd());
            for (SupplierStat stat:stats){
                Supplier supplier = supplierService.getById(stat.getId());
                stat.setName(supplier.getName());
                stat.setPhoneNumber(supplier.getPhoneNumber());
            }
            model.addAttribute("stats", stats);
            session.setAttribute("statRequest", supplierStatRequest);
        }
        else {
            SupplierStatRequest s = new SupplierStatRequest();
            s.setProduct(new Product());
            model.addAttribute("statRequest", s);
        }
        return "statistic/SupplierStatistic";
    }
    @PostMapping("/supplier/detail/{id}")
    public String showStatDetail(
            @SessionAttribute("statRequest") SupplierStatRequest supplierStatRequest,
            @PathVariable("id") Long supplierId,
            Model model
    ){
        model.addAttribute("product", supplierStatRequest.getProduct());
        model.addAttribute("supplier", supplierService.getById(supplierId));
        model.addAttribute("details", importDetailService.getSupplierStatDetail(supplierId, supplierStatRequest.getProduct().getId(), supplierStatRequest.getTimeStart(), supplierStatRequest.getTimeEnd()));
        return "statistic/SupplierStatDetail";
    }
}
