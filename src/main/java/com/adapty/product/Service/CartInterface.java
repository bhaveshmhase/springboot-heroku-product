package com.adapty.product.Service;
import java.util.ArrayList;


import com.adapty.product.entities.Cart;

public interface CartInterface {
    //fetching all details of Cart with product id mention in cart and total price of cart.
    public ArrayList findAll();
    
    //Add new cart to cart table.
    public String addObjToCart(Cart cartObj);
    
    //Delete Cart object by cart item id.
    public String deleteCartByCartID(String cartItemId);
    
    //Update Cart by cart item id.
    public Cart updateCartByItemId(Cart cartObj);
    
    //delete cart object by product id.
    public String deleteCartByProductId(String productId);
    

}
