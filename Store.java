import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 09/04/17.
 */
public class Store {
    static public ArrayList<Products> productsArrayList = new ArrayList<Products>();



    Scanner sc = new Scanner(System.in);
    boolean found;

    void addNewProducts()
    {
        System.out.println("Enter Product Name: ");
        String productName = sc.next();
        System.out.println("Enter product ID");
        String productID = sc.next();
        System.out.println("Enter product price");
        double productPrice = sc.nextDouble();
        System.out.println("Enter product Quantity");
        int productQuantity = sc.nextInt();
        productsArrayList.add(new Products(productName,productID,productPrice,productQuantity));

    }



    void sell(){
        System.out.println("Enter the name you want to sell");
        String name = sc.next();
        System.out.println("How many copy you want ?");
        int productQuantity = sc.nextInt();
        for (int i=0;i<productsArrayList.size();i++)
        {
            if(productsArrayList.get(i).productName.equals(name)){
                {
                    if (productsArrayList.get(i).productQuantity>productQuantity){
                        productsArrayList.get(i).productQuantity-=productQuantity;
                        System.out.println("Enter (a) for add another order or (e) for exit");
                        
                        break;
                    }
                    else {
                        System.out.println("Not Available");
                    }

                }

            }
        }
    }


    void productsModify(){
        System.out.println("Enter product ID you want that to modify");
        String id = sc.next();
        for (int i=0;i<productsArrayList.size();i++){
            if(productsArrayList.get(i).productID.equals(id)){
                System.out.println("Enter new Name: ");
                productsArrayList.get(i).productName= sc.next();
                System.out.println("Enter new price");
                productsArrayList.get(i).productPrice=sc.nextDouble();
//                System.out.println("Enter new ID");
//                productsArrayList.get(i).productID = sc.next();
                System.out.println("Enter new Quantity");
                productsArrayList.get(i).productQuantity = sc.nextInt();
            }
        }
    }

    void removeProducts(){
        System.out.println("Which product you want to remove?");
        String name = sc.next();
        for (int i=0;i<productsArrayList.size();i++){
            if (productsArrayList.get(i).productName.equals(name)) {
                productsArrayList.remove(i);
            }
        }
    }


    void searchProducts(){
        System.out.println("Enter the name you want to search");
        String name = sc.next();
        System.out.println("Product ID\t\tProduct Name\tQuantity\tPrice");
        for(int i=0;i<productsArrayList.size();i++)
        {
            if(name.equals(productsArrayList.get(i).productName))
            {
                System.out.println("\t"+productsArrayList.get(i).productID+
                        "\t\t\t"+productsArrayList.get(i).productName+
                        "\t\t\t"+productsArrayList.get(i).productQuantity+
                        "\t\t\t"+productsArrayList.get(i).productPrice);
                found=!found;
            }
        }
        if(!found)
        {
            System.out.println("Product not Found");
        }
/*        ArrayList <Products> resList = new ArrayList<Products>();
        for(Products products:resList){

        }*/

    }


    void display(){
        System.out.println("Product ID\t\tProduct Name\tQuantity\tPrice");
        for (int i=0;i<productsArrayList.size();i++){
            System.out.println("\t"+productsArrayList.get(i).productID+
                    "\t\t\t"+productsArrayList.get(i).productName+
                    "\t\t\t"+productsArrayList.get(i).productQuantity+
                    "\t\t\t"+productsArrayList.get(i).productPrice);
        }
    }



}



