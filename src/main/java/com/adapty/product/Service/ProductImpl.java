package com.adapty.product.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adapty.product.Repository.ProductRepository;
import com.adapty.product.entities.Product;
// import com.adapty.product.entities.STATUS;
import com.adapty.product.entities.STATUS;

@Service
public class ProductImpl implements ProductInterface {
    @Autowired
    private ProductRepository repoObj;

    //Fetching all details about Products.
    public List<Product> findAllProduct() {
        return repoObj.findAll();
    }

    //find product by product id.
    public Optional<Product> findProductByproductId(String productId) {
        return repoObj.findById(productId);
    }

    //Add new object to product table.
    public String addProduct(Product ProductObj)
    {
        repoObj.save(ProductObj);
        return "Object saved";

    }
    
    //Update product by producy id.
    public Product updateProductByProductId(Product productObj){
        if(productObj.getProductId() == null){
            return productObj;
        }
        else{
            Optional<Product> p1 = repoObj.findById(productObj.getProductId());
    
            p1.get().setProductCategory(productObj.getProductCategory());
            p1.get().setProductDescription(productObj.getProductDescription());
            p1.get().setProductName(productObj.getProductName());
            p1.get().setProductImage(productObj.getProductImage());
            p1.get().setProductPrice(productObj.getProductPrice());
            p1.get().setProductStatus(productObj.getProductStatus());
    
            repoObj.deleteById(productObj.getProductId());
            return repoObj.save(p1.get());
            
        }
        
    }

    //Delete product object by product id.
    public String deleteProductByProductId(Product productsObj){
        if(productsObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
        else{
            Optional<Product> d1 = repoObj.findById(productsObj.getProductId());
            if(d1.get().getProductStatus() == STATUS.ACTIVE){
                d1.get().setProductStatus(STATUS.INACTIVE);
                repoObj.save(d1.get());
                return "Object Deleted Successfully";
             
            }
            else{
                return "Object does not exists";
            }
        
    }
    }

    }



