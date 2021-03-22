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


    /**
     * 모든 list 조회
     * @return
     */
    public List<Product> getAllProducts() {
        return apiDao.getAllProducts();
    }

    /**
     * id 로  데이터 조회 
     * @param pdId
     * @return
     * @throws Exception
     */
    public Product getProductByPdId(String pdId) throws Exception {
        return apiDao.getProductByPdId(pdId);
    }

    /**
     * product 상품 등록
     * @param product
     * @return
     * @throws Exception
     */
    public Product registerProduct(Product product) throws Exception {

        if((isDuplicatedPdId(product.getPdId()))){
            throw new RuntimeException("the Pdid already exixts");
        }

        return apiDao.insertProduct(product);
    }

    /**
     *  product 데이터 수정
     * @param pdId
     * @param product
     * @return
     * @throws Exception
     */
    public Product modifyProduct(String pdId, Product product) throws Exception {
        Product product1 = getProductByPdId(pdId);
        if(!(isDuplicatedPdId(pdId))){
            throw new RuntimeException("No Search Data by PdId");
        }

        return product1;

    }

    /**
     * pdid 로 해당 데이터 삭제
     * @param pdId
     * @throws Exception
     */
    public void removeProduct(String pdId)  throws Exception {
        if(!(isDuplicatedPdId(pdId))){
            throw new RuntimeException("No Search Data by PdId");
        }
         apiDao.deleteProduct(pdId);

    }

    public Map<String, String> getTest (){
        Map<String, String>  res = new HashMap<>();
        res.put("test", "hi");

        return res;
    }


    /**
     * 변경하려는 pdId 이미 있는지 확인
     *
     * @param pdId
     * @return boolean
     */
    private boolean isDuplicatedPdId(String pdId) throws Exception {
        if (apiDao.getProductByPdId(pdId) != null) {
            return true;
        }
        return false;
    }
}
