package com.adapty.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.adapty.product.entities.Product;

public interface  ProductRepository extends JpaRepository<Product,String>{

    
    
}
