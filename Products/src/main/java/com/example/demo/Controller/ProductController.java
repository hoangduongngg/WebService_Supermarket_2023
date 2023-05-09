/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.ProductRequest;
import com.example.demo.Repository.ProductRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

/**
 *
 * @author ben
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@RequestParam Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/add-product")
    @ResponseBody
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        Optional<Product> product = productRepository.findByNameAndIdSupplied(productRequest.name, productRequest.idSupplier);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();

        } else {

            Product newProduct = new Product(productRequest);
            productRepository.save(newProduct);
            return ResponseEntity.ok(newProduct);
        }
    }

    @PostMapping("/update-product")
    @ResponseBody
    public ResponseEntity<Product> updateProduct(@RequestBody ProductRequest productRequest) {
        Optional<Product> product = productRepository.findByNameAndIdSupplied(productRequest.name, productRequest.idSupplier);
        if (product.isPresent()) {
            Product newProduct = new Product(productRequest);
            productRepository.save(newProduct);
            return ResponseEntity.ok(newProduct);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PostMapping("/update-product/img")
    @ResponseBody
    public ResponseEntity<String> updateImgCustomer(@RequestParam("img") MultipartFile img,
            @RequestParam Integer id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            try {
                Map<String, String> config = new HashMap<>();
                config.put("cloud_name", "dne2tjjym");
                config.put("api_key", "871314462855254");
                config.put("api_secret", "m_8hFHYWag6pdETWKh4_rhCkBTg");
                Cloudinary cloudinary = new Cloudinary(config);

                String url = (String) cloudinary.uploader().upload(img.getBytes(), ObjectUtils.asMap(
                        "folder", "products",
                        "public_id", "product_" + id)).get("url");
                product.get().setImg(url);
                productRepository.save(product.get());
                return ResponseEntity.ok("ok");

            } catch (Exception e) {
                System.out.println(e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
            }
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/delete-product")
    @ResponseBody
    public ResponseEntity<Product> deleteProduct(@RequestParam Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/search-product")
    @ResponseBody
    public List<Product> searchProductByName(   @RequestParam String keyword,
                                                @RequestParam Integer minPrice,
                                                @RequestParam Integer maxPrice) {
        
        if (minPrice < 0) {
            minPrice = 0;
        }
        if(maxPrice <= 0){
            if(keyword == null){
                return productRepository.findByPriceGreaterThan(minPrice);
            }
            else{
                return productRepository.findByNameContainingIgnoreCaseAndPriceGreaterThan(keyword, minPrice);
            }
        }
        else{
            if(keyword == null){
                return productRepository.findByPriceBetween(minPrice, maxPrice);
            }
            else{
                return productRepository.findByNameContainingIgnoreCaseAndPriceBetween(keyword, minPrice,maxPrice);
            }
        }
        
    }

}
