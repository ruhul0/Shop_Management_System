import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Marzan Hossain on 4/19/2017.
 */
public class Gui1 {

    JFrame product = new JFrame("Product");
    JTextField user = new JTextField("Enter Username");
    JTextField pass = new JTextField("Enter Password");
    JButton login = new JButton("Login");
    JFrame productListing = new JFrame("Product Listing");
    JButton addProduct = new JButton("Add product");
    JButton removeProduct = new JButton("Remove Product");
    JButton searchProduct = new JButton("Search Product");
    JButton modifyProduct = new JButton("Modify Product");
    JButton viewAllProduct = new JButton("View All Product");
    JFrame Adding = new JFrame("Add Product");
    JTextField productName = new JTextField("Enter Product name");
    JTextField productID = new JTextField("Enter Product ID");
    JTextField productQuantity = new JTextField("Enter Product quantity");
    JTextField productPrice = new JTextField("Enter Product Price");
    public Gui1()
    {
        product.setSize(500,500);
        product.setLayout(null);
        product.setVisible(true);
        product.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        product.add(user);
        user.setVisible(true);
        user.setBounds(130,51,120,25);
        product.add(pass);
        pass.setVisible(true);
        pass.setBounds(130,91,120,25);
        product.add(login);
        login.setVisible(true);
        login.setBounds(130,140,100,30);
        login.addActionListener(new Login());

    }
    public class Login implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(user.getText().equals("admin")&&pass.getText().equals("admin"))
            {
                productListing.setVisible(true);
                productListing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                productListing.setSize(500,500);
                productListing.setLayout(null);
                productListing.add(addProduct);
                addProduct.setVisible(true);
                addProduct.setBounds(0,0,150,30);
                productListing.add(removeProduct);
                removeProduct.setVisible(true);
                removeProduct.setBounds(0,51,150,30);
                productListing.add(modifyProduct);
                modifyProduct.setVisible(true);
                modifyProduct.setBounds(0,101,150,30);
                productListing.add(searchProduct);
                searchProduct.setVisible(true);
                searchProduct.setBounds(0,151,150,30);
                productListing.add(viewAllProduct);
                viewAllProduct.setVisible(true);
                viewAllProduct.setBounds(0,201,150,30);
                product.dispose();
                addProduct.addActionListener(new AddProduct());

            }
        }
    }
    public class AddProduct implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Adding.setSize(500,500);
            Adding.setLayout(null);
            Adding.setVisible(true);
            Adding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Adding.add(productName);
            productName.setVisible(true);
            productName.setBounds(0,0,100,30);
            Adding.add(productID);
            productID.setVisible(true);
            productID.setBounds(0,51,100,30);
            Adding.add(productQuantity);
            productQuantity.setVisible(true);
            productQuantity.setBounds(0,51,100,30);
            Adding.add(productPrice);
            productPrice.setVisible(true);
            productPrice.setBounds(0,51,100,30);



        }
    }

    public static void main(String[] args) {
        new Gui1();
    }
}
