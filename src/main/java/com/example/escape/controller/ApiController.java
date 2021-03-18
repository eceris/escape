package com.example.escape.controller;

import com.example.escape.model.Product;
import com.example.escape.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    //read
    @GetMapping("/test")
    public Map<String, String> th(){
        Map<String, String>  res = this.apiService.getTest();

        return res;

    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return apiService.getAllProducts();
    }

    @GetMapping("/{pdId}")
    public Product getProductByPdId (@PathVariable String pdId){
        return apiService.getProductByPdId(pdId);
    }

    @PostMapping("")
    public Product registerProduct (@RequestBody  Product product){
        return apiService.registerProduct(product);
    }

    @PutMapping("/{pdId}")
    public void modifyProduct (@PathVariable String pdId, @RequestBody Product product){
         apiService.modifyProduct("pdId",product);
    }

    @DeleteMapping("/{pdId}")
    public  void removeProduct (@PathVariable String pdId){
        apiService.removeProduct(pdId);
    }

}
