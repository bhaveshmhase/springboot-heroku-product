package com.adapty.product.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adapty.product.Service.ProductImpl;
import com.adapty.product.entities.Product;

@RestController
public class ProductController {

    @Autowired
    private ProductImpl srv;

    //Fetching all details about Products.
    @GetMapping(value ="/api/allproducts")
    public List<Product> findAllProduct(){
        return srv.findAllProduct();
    }

    //find product by product id.
    @GetMapping(value="/api/product/{id}")
    public Optional<Product> findProductByproductId(@PathVariable("id") String productId)
    {
        return srv.findProductByproductId(productId);
    }

    //Add new product object to product  table.
    @PostMapping(value="/api/newproduct")
    public String addProduct(@RequestBody Product ProductObj){
        return srv.addProduct(ProductObj);
    }

    //Update product object by product id.
    @PutMapping(value="/api/updateproduct/{id}")
    public Product updateProductByProductId(@PathVariable("id") Product obj){
        return srv.updateProductByProductId(obj);
    }

    //Delete product object by product id.
    @DeleteMapping(value = "/api/deleteproduct/{id}")
    public String deleteProductByProductId(@PathVariable("id") Product productObj)
    {
        return srv.deleteProductByProductId(productObj);
    }


}

    
