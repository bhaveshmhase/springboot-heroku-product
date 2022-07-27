package com.adapty.product.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adapty.product.Repository.CartRepository;
import com.adapty.product.Repository.ProductRepository;
import com.adapty.product.entities.Cart;
import com.adapty.product.entities.STATUS;
import com.adapty.product.entities.Product;
import java.util.Optional;


@Service
public class CartImpl implements CartInterface {
    @Autowired
     CartRepository repoCart;
     @Autowired
     ProductRepository repoObj;
    
    
     //fetching all details of Cart with product id mention in cart and total price of cart.
     public ArrayList findAll(){
        float totalPrice=0;
        int i=0;
        ArrayList list = new ArrayList();
        List<Cart> c1 = repoCart.findAll();
        for(i = 0; i<c1.size();i++){
            Optional<Product> c2 = repoObj.findById(c1.get(i).getProductId());
            int c3 = c1.get(i).getCartItemQty();
            totalPrice = totalPrice + (c3*c2.get().getProductPrice()); 
            list.add(Arrays.asList(c1.get(i).getCartItemId(),c1.get(i).getCartItemQty(),c2.get().getProductImage(),c2.get().getProductName(),c2.get().getProductPrice(),c2.get().getProductCategory(),c2.get().getProductDescription(),c2.get().getProductStatus()));  
            list.add(totalPrice);
          }
        return list;
     }



    //Add new cart to cart table.
    public String addObjToCart(Cart cartObj){
        Optional<Product> a1 =repoObj.findById(cartObj.getProductId());
        if(a1.get().getProductStatus() == STATUS.ACTIVE){
            repoCart.save(cartObj);
            return "Object created Successfully";
         
        }
        else{
            return "SELECTED PRODUCT STATUS IS INACTIVE";
        }
    }

    //Delete Cart object by cart item id.
    public String deleteCartByCartID(String cartItemId){
        repoCart.deleteById(cartItemId);
        return "Cart object deleted successfully";
  }

  //Update Cart by cart item id.
    public Cart updateCartByItemId(Cart cartItemId){
        if(cartItemId.getCartItemId() == null){
            return cartItemId;
        }
        else{
            Optional<Cart> c1 = repoCart.findById(cartItemId.getCartItemId());
    
            
            c1.get().setCartItemQty(cartItemId.getCartItemQty());
            c1.get().setCartItemId(cartItemId.getCartItemId());
            c1.get().setProductId(cartItemId.getProductId());
          
    
            repoCart.deleteById(cartItemId.getCartItemId());
            return repoCart.save(c1.get());
        }
    }

    //delete cart object by product id.
    public String deleteCartByProductId(String productId){
        repoCart.deleteByProductId(productId);
        return "Product Id in cart deleted successfully.";
    }
    
    }


        
        



   
    
    

