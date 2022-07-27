package com.adapty.product.ServiceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matcher;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adapty.product.Repository.CartRepository;
import com.adapty.product.Repository.ProductRepository;
import com.adapty.product.Service.CartImpl;
import com.adapty.product.Service.ProductImpl;
import com.adapty.product.entities.CATEGORY;
import com.adapty.product.entities.Cart;
import com.adapty.product.entities.Product;
import com.adapty.product.entities.STATUS;


@ExtendWith(MockitoExtension.class)
public class CartServiceTesting {
    @InjectMocks
    CartImpl  CartImplObj;
    @InjectMocks
    ProductImpl productImpl;
    @Mock
    CartRepository CartRepoObj;
    @Mock 
    ProductRepository productRepoObj;

    
    
   

    //Add new cart to cart table.
    @Test
    public void addObjToCart(){
    Cart c1=new Cart("1", 50, "1");
    CartRepoObj.save(c1);
    verify(CartRepoObj,times(1)).save(c1);
    }

    //Delete Cart object by cart item id.
    @Test
    public void deleteCartByCartID(){
        Cart c1 = new Cart("c1", 50, "1");
        lenient().when(CartRepoObj.findById("c1")).thenReturn(Optional.of(c1));
        String msg=CartImplObj.deleteCartByCartID("c1");
        assertEquals("Cart object deleted successfully",msg);
        
    }
   
    //Update Cart by cart item id.
    @Test
    public void updateCartByItemId(){
        Cart c1=new Cart("2", 10, "2");
    
        c1.setCartItemQty(4);
        c1.setProductId("2");


        Assertions.assertThat(c1.getCartItemQty()).isEqualTo(4);
        Assertions.assertThat(c1.getProductId()).isEqualTo("2");
        }

     //delete cart object by product id.
    @Test
    public void deleteCartByProductById(){
        Cart c1 = new Cart("1", 50, "1");
        lenient().when(CartRepoObj.findById("1")).thenReturn(Optional.of(c1));
        String msg=CartImplObj.deleteCartByProductId("1");
        assertEquals( "Product Id in cart deleted successfully.",msg);
        }
}


