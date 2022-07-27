package com.adapty.product.Controller;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adapty.product.Service.CartImpl;
import com.adapty.product.entities.Cart;

@RestController
public class CartController {

    @Autowired
    private CartImpl srvCart;

    //fetching all details of Cart with product id mention in cart and total price of cart.
    @GetMapping(value ="/api/cart")
    public ArrayList findAll(){
        return srvCart.findAll();
    }

    
    //Add new cart to cart table.
    @PostMapping(value ="/api/addnewcart")
    public String addObjToCart(@RequestBody Cart cartObj){
        return srvCart.addObjToCart(cartObj);
    }
    
    //Delete Cart object by cart item id.
    @DeleteMapping(value = "/api/delete/cart/{cartItemID}")
    public String  deleteCartByCartID(@PathVariable String cartItemID){
        return srvCart.deleteCartByCartID(cartItemID);
    }

     
    //Update Cart by cart item id.
    @PutMapping(value="/api/modify/{cartItemId}")
    public Cart updateCartByItemId(@RequestBody Cart  cartItemId){
        return srvCart.updateCartByItemId(cartItemId);
    }

     //delete cart object by product id.
    @DeleteMapping(value = "/api/item/{productId}")
    public String deleteCartByProductId(@PathVariable String productId){
    return srvCart.deleteCartByProductId(productId);
    }
    
}

