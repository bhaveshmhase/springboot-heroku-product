package com.adapty.product.entities;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Product {
@Id
private String productId;
String productName;
@Enumerated(EnumType.STRING)
CATEGORY productCategory;
int productPrice;
String productDescription;
String productImage;
@Enumerated(EnumType.STRING)
STATUS productStatus;
@OneToMany
@JoinColumn(name = "productId",referencedColumnName = "productId")
private List<Cart> cartObj= new LinkedList<>();




    public Product(String productId, String productName, CATEGORY productCategory, int productPrice, String productDescription, String productImage, STATUS productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productStatus = productStatus;
    }
public Product(){

}

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public String setProductName(String productName) {
        return this.productName = productName;
    }

    public CATEGORY getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(CATEGORY productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public STATUS getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(STATUS productStatus) {
        this.productStatus = productStatus;
    }


    @Override
    public String toString() {
        return "{" +
            " productId='" + getProductId() + "'" +
            ", productName='" + getProductName() + "'" +
            ", productCategory='" + getProductCategory() + "'" +
            ", productPrice='" + getProductPrice() + "'" +
            ", productDescription='" + getProductDescription() + "'" +
            ", productImage='" + getProductImage() + "'" +
            ", productStatus='" + getProductStatus() + "'" +
     
            "}";
    }
   
}