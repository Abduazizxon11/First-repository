package org.example.service.impl;

import org.example.model.Category;
import org.example.model.Product;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList<>();


    @Override
    public void create(Product product) {
        Product product1 = new Product();
        product1.setName(product1.getName());
        product1.setProductId(product1.getProductId());
        product1.setType(product1.getType());
        product1.setPrice(product1.getPrice());
        product1.setDescription(product1.getDescription());
        products.add(product1);
    }
    @Override
    public void update(int id, Product product) {
        long productId = product.getProductId();
        for (int i = 0; i < products.size(); i++) {
            Product product2 = products.get(i);
            if(productId == product2.getProductId()){
                if(!product.getName().equals("")){
                    product2.setName(product.getName());
                }
                if(!product.getType().equals("")){
                    product2.setType(product.getType());
                }
                if(!product.getDescription().equals("")){
                    product2.setDescription(product.getDescription());
                }if(product.getPrice() != 0){
                    product2.setPrice(product.getPrice());
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        Product temp = null;
        for (Product product:products) {
            if (product.getProductId() == id){
                temp = product;
            }
        }if (temp != null){
            products.remove(temp);
        }
    }

    @Override
    public Product get(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
