package com.adapty.product.ServiceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adapty.product.Repository.ProductRepository;
import com.adapty.product.Service.ProductImpl;
import com.adapty.product.entities.CATEGORY;
import com.adapty.product.entities.Product;
import com.adapty.product.entities.STATUS;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTesting {
    @InjectMocks
    ProductImpl productImplObj;
    @Mock
    ProductRepository productRepoObj;
//find all product 
    @Test
    public void findAllProduct(){
        List<Product> list = new LinkedList<Product>();
        Product prOne = new Product("1", "oneplus", CATEGORY.ELECTRONICS ,36000, "Phone", "url/sdfsgfsdf/dfsd", STATUS.INACTIVE);
        Product prTwo = new Product("1", "Calvin Tshirt", CATEGORY.CLOTHES ,500, "cotton tshirt", "url/sdfsgfsdf/dfsd", STATUS.INACTIVE);
         list.add(prOne);
         list.add(prTwo);
        when(productRepoObj.findAll()).thenReturn(list);
        List<Product> prlist=productRepoObj.findAll();
        assertEquals(2, prlist.size());
        verify(productRepoObj, times(1)).findAll();
    }   
//find product details  by product id
    @Test        
    public void findProductByproductId(){
        Product p1 = new Product("1", "oneplus", CATEGORY.ELECTRONICS ,36000, "Phone", "url/sdfsgfsdf/dfsd", STATUS.ACTIVE);
        when(productRepoObj.findById("1")).thenReturn(Optional.of(p1));
        Optional<Product> p2=productImplObj.findProductByproductId("1");
        assertEquals(STATUS.ACTIVE,p2.get().getProductStatus());
        assertEquals(p1.getProductId(),p2.get().getProductId());
}
//add product object to product list
@Test
public void addProduct(){
    Product p1 = new Product("1", "oneplus", CATEGORY.ELECTRONICS ,36000, "Phone", "url/sdfsgfsdf/dfsd", STATUS.ACTIVE);
    when(productRepoObj.save(p1)).thenReturn(p1);
    String msg=productImplObj.addProduct(p1);
    assertNotNull(p1,"Object is created");
}
//update product object by poduct id
@Test
public void updateProductByProductId(){
    Product p1=new Product("1", "one plus", CATEGORY.ELECTRONICS, 100000, "Its a smarphone", "ur/setimag/",STATUS.ACTIVE);

   p1.setProductName("tshirt");
   p1.setProductCategory(CATEGORY.CLOTHES);
   p1.setProductPrice(200);
   p1.setProductDescription("cotton tshirt");
   p1.setProductImage("url/hghg/");
   p1.setProductStatus(STATUS.ACTIVE);

    Assertions.assertThat(p1.getProductName()).isEqualTo("tshirt");
    Assertions.assertThat(p1.getProductCategory()).isEqualTo(CATEGORY.CLOTHES);
    Assertions.assertThat(p1.getProductPrice()).isEqualTo(200);
    Assertions.assertThat(p1.getProductDescription()).isEqualTo("cotton tshirt");
    Assertions.assertThat(p1.getProductImage()).isEqualTo("url/hghg/");
    Assertions.assertThat(p1.getProductStatus()).isEqualTo(STATUS.ACTIVE);

}

//delete product object by product id
@Test
public void deleteProductByProductId(){
    Product p1 = new Product("1", "oneplus", CATEGORY.ELECTRONICS ,36000, "Phone", "url/sdfsgfsdf/dfsd", STATUS.ACTIVE);
    when(productRepoObj.findById("1")).thenReturn(Optional.of(p1));
    String msg=productImplObj.deleteProductByProductId(p1);
    assertEquals( "Object Deleted Successfully",msg);
    }
}