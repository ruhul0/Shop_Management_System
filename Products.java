/**
 * Created by user on 04/04/17.
 */
public class Products {
    String productName;
    String productID;
    double productPrice;
    int productQuantity;


    public Products(String productName, String productID, double productPrice,int productQuantity) {
        super();
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;

        //productID = 100+(Math.random()*999+"");

    }



    void displayProducts(){
        System.out.println("Product name: "+productName+
                "\nproduct ID: "+productID+
                "\nQuantity: "+productQuantity+
                "\nPrice: "+productPrice);
    }


}
