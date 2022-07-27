package com.adapty.product.Repository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adapty.product.entities.Cart;



public interface CartRepository extends JpaRepository<Cart,String>{
    @Transactional
    public String deleteByProductId(String productId);

   
    


    
}
