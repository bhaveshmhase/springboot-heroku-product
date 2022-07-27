package com.adapty.product.Service;

import java.util.List;
import java.util.Optional;

import com.adapty.product.entities.Product;
public interface ProductInterface {
    //Fetching all details about Products.
    public List<Product> findAllProduct();

    //find product by product id.
    public Optional<Product>  findProductByproductId(String productId);
    
    //Update product by producy id.
    public Product updateProductByProductId(Product productObj);
    
    //Delete product object by product id.
    public String deleteProductByProductId(Product productsObj);
    
}
