package com.example.escape.service;

import com.example.escape.dao.ApiDao;
import com.example.escape.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {
    @Autowired
    ApiDao apiDao;


    public List<Product> getAllProducts() {
        return apiDao.getAllProducts();
    }

    public Product getProductByPdId(String pdId) {
        return apiDao.getProductByPdId(pdId);
    }

    public Product registerProduct(Product product) {
        return apiDao.insertProduct(product);
    }

    public void modifyProduct(String pdId, Product product) {
        apiDao.updateProduct(pdId, product);
    }

    public void removeProduct(String pdId) {
        apiDao.deleteProduct(pdId);
    }

    public Map<String, String> getTest (){
        Map<String, String>  res = new HashMap<>();
        res.put("test", "hi");

        return res;
    }
}
