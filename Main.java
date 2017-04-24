import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 04/04/17.
 */
public class Main {
    // static public ArrayList<Store> productsArrayList = new ArrayList<Store>();
    //static public ArrayList<ProductCategory>productCategories = new ArrayList<ProductCategory>();


    public static void main(String[] args) {
        int choice;
        // Products products = new Products();
        Store store = new Store();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter (1) to Add Products " +
                    "\nEnter (2) to display all" +
                    "\nEnter (3) to Order " +
                    "\nEnter (4) to  modify a product" +
                    "\nEnter (5) to delete a product " +
                    "\nEnter (6) to Search Product"+
                    "\nEnter (7) to find top selling product"+
                    "\nEnter (8) to find Which products are stock out"+
                    "\nEnter (0) to exit ");


            choice = sc.nextInt();
            if (choice == 1) {
                store.addNewProducts();
            }
            if (choice == 2) {
                store.display();
            }
            if (choice==3){
                store.sell();
            }
            if (choice==4){
                store.productsModify();
            }
            if (choice==5){
                store.removeProducts();
            }
            if (choice==6){
                store.searchProducts();
            }
            if (choice==0){
                break;
            }



        }
    }


}

