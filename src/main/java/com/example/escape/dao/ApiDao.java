package com.example.escape.dao;

import com.example.escape.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApiDao {
    public static List<Product> products;

    //B가 없으니 임시로 세팅해놓음
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"testName1","testId1", "1234"));
        products.add(new Product(2,"testName2","testId2", "1234"));
        products.add(new Product(3,"testName3","testId3", "1234"));
        products.add(new Product(4,"testName4","testId4", "1234"));
        products.add(new Product(5,"testName5","testId5", "1234"));
    }

    // Select all user.
    public List<Product> getAllProducts() {
        return products;
    }


    //select one product by pdId
    public  Product getProductByPdId(String pdId){
        return  products
                .stream()
                .filter(pd -> pd.getPdId().equals(pdId))
                .findAny()
                .orElse(new Product(-1, "","",""));

    }

    //insert
    public Product insertProduct(Product product){
        products.add(product);
        return product;
    }

    //update
    public  void updateProduct (String pdId, Product product){
        products.stream()
                .filter(curProduct -> curProduct.getPdId().equals(pdId))
                .findAny()
                .orElse(new Product(-1, "","",""))
                .setPdName(product.getPdName());

    }

    //delect
    public void deleteProduct(String pdId){
        products.removeIf(product -> product.getPdId().equals(pdId));
    }

}
