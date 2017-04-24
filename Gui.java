import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by user on 30/03/17.
 */
public class Gui implements ActionListener{
    JFrame loginFrame = new JFrame("Your Shop");

    JFrame dashboardFrame = new JFrame("Your Shop DashBoard");
    JFrame modifyProduct = new JFrame("Modify Product");
    JFrame newProduct = new JFrame("New Product");
    JFrame delete = new JFrame("Delete Product");

    JFrame order = new JFrame("Order");

    JLabel userNameLabel = new JLabel("User Name:");
    JLabel passwordLabel = new JLabel("Enter Password:");

//    JLabel productID = new JLabel("Product ID");
//    JLabel productName = new JLabel("Product NAme");
//    JLabel productPrice = new JLabel("Price");
//    JLabel productQuantity = new JLabel("Quantity");

    JLabel productID = new JLabel("Product ID");
    JLabel productName = new JLabel("Product NAme");
    JLabel productPrice = new JLabel("Price");
    JLabel productQuantity = new JLabel("Quantity");

    JLabel modproductID = new JLabel("Modify Product ID");
    JLabel modproductName = new JLabel("Modify  NAme");
    JLabel modproductPrice = new JLabel("Modify Price");
    JLabel modproductQuantity = new JLabel("Modify Quantity");

    JTextField userNameTextField = new JTextField("admin");
    JTextField passwordField = new JTextField("admin");

    JTextField searchTextField = new JTextField("");
    JButton clear = new JButton("Clear");


    JLabel showProductInfo = new JLabel();

    JLabel productInfo = new JLabel();

    JTextField orderQuantity = new JTextField();

    JLabel label = new JLabel();
    //JTable table = new JTable();

//    JTextField productIDtext = new JTextField("");
//    JTextField productNameText = new JTextField("");
//    JTextField priceText = new JTextField("");
//    JTextField quantitytext = new JTextField("");
//
//    JTextField productIDtext = new JTextField("");
//    JTextField productNameText = new JTextField("");
//    JTextField priceText = new JTextField("");
//    JTextField quantitytext = new JTextField("");

    JTextField productIDtext = new JTextField("");
    JTextField productNameText = new JTextField("");
    JTextField priceText = new JTextField("");
    JTextField quantitytext = new JTextField("");



    JButton signIn = new JButton("Sign In");
    JButton searchButton = new JButton("Search");
    JButton addOrder = new JButton("Add new Order");
    JButton addProducts = new JButton("Add new Product");
    JButton modifyProducts = new JButton("Modify Products");
    JButton deleteProducts = new JButton("Delete Products");
    JButton showProduct  = new JButton("Show Products");
    JButton done = new JButton("Done");
    JButton back = new JButton("Back");

    JLabel bg = new JLabel(new ImageIcon("bg.jpg"));

    //String column[]={"ID","Name","Price","Quantity"};
    int i=0;
    int j;
    static boolean foundProduct=false;
    double price;
    int quantity;

    String filename = "product.txt";
    FileWriter fw = new FileWriter(new File(filename),true);
    BufferedReader br = new BufferedReader(new FileReader(filename));


    public Gui() throws IOException {



        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setSize(500, 700);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);


        loginFrame.add(userNameLabel);
        userNameLabel.setBounds(30,50,100,20);
        userNameLabel.setVisible(true);


        loginFrame.add(userNameTextField);
        userNameTextField.setBounds(130,51,120,25);
        userNameTextField.setVisible(true);

        loginFrame.add(passwordLabel);
        passwordLabel.setBounds(30,90,100,10);
        passwordLabel.setVisible(true);


        loginFrame.add(passwordField);
        passwordField.setBounds(130,91,120,25);
        passwordField.setVisible(true);




        loginFrame.add(signIn);
        signIn.setBounds(130,140,100,30);
        //passwordField.setActionCommand(String.valueOf(new Login()));
        //passwordField.addActionListener(new Login());
        signIn.addActionListener(new DashBoard());
        loginFrame.add(bg);
        backGround();

    }
/*    void passwordCheck(){
        if( (userNameTextField.getText().equals("admin") && passwordField.getText().equals("admin")))
        {
            new DashBoard();
            loginFrame.dispose();
        }
        else
        {
            //JOptionPane.showMessageDialog(this,"incorrect login info");
            new DashBoard();
            System.out.println("wrong login info");
        }

    }*/
/*    public class Login extends Component implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            {
                passwordCheck();
                signIn.addActionListener(new DashBoard());
                loginFrame.dispose();
            }
            else
            {
                //JOptionPane.showMessageDialog(this,"incorrect login info");
                //System.out.println("wrong login info");
            }
        }
    }*/

    public static void main(String[] args) throws IOException {
        new Gui();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class DashBoard implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((userNameTextField.getText().equals("admin") && passwordField.getText().equals("admin"))) {
                String[] info;
                String id;

                dashboardFrame.setVisible(true);
                dashboardFrame.setSize(500, 700);
                dashboardFrame.setLayout(null);

                dashboardFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//            JMenuBar menuBar = new JMenuBar();
//            dashboardFrame.add(menuBar);
//            menuBar.setBounds(0,0,800,30);
//            menuBar.setVisible(true);
//            JMenuItem products = new JMenuItem("Products");
//            menuBar.add(products);
//            products.setBounds(0,0,100,20);


                dashboardFrame.add(searchTextField);
                searchTextField.setBounds(20, 50, 400, 30);


                dashboardFrame.add(searchButton);
                searchButton.setBounds(430, 48, 100, 30);


                dashboardFrame.add(addOrder);
                addOrder.setBounds(20, 100, 140, 30);
                addOrder.addActionListener(new AddOrder());


                dashboardFrame.add(addProducts);
                addProducts.setBounds(220, 100, 140, 30);
                addProducts.addActionListener(new AddNewProduct());


                dashboardFrame.add(modifyProducts);
                modifyProducts.setBounds(420, 100, 140, 30);
                modifyProducts.addActionListener(new modifyProduct());


                dashboardFrame.add(deleteProducts);
                deleteProducts.setBounds(420, 150, 140, 30);
                deleteProducts.addActionListener(new DeleteProduct());

                dashboardFrame.add(showProduct);
                showProduct.setBounds(0, 201, 140, 30);
                showProduct.setVisible(true);
                showProduct.addActionListener(new ShowProducts());
                //showProduct.setBounds();
                try {
                    if (br.readLine() != null) {
                        try {
                            id = br.readLine();
                            while (id != null) {
                                if(id==null)
                                {
                                    break;
                                }
                                if(id!=null&&id!=" ")
                                {

                                    info = id.split(" ");
                                    Products p = new Products(info[0], info[1], Double.parseDouble(info[2]), Integer.parseInt(info[3]));
                                    Store.productsArrayList.add(p);
                                    id = br.readLine();
                                }

                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                loginFrame.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Wrong password");
            }
            dashboardFrame.add(bg);
            backGround();

        }
        public class AddOrder implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                order.setVisible(true);
                order.setSize(500, 700);
                order.setLayout(null);

                JLabel enterQuantity = new JLabel("Enter Quantity");
                enterQuantity.setBounds(0,0,100,30);
                order.add(enterQuantity);
                enterQuantity.setVisible(true);

                orderQuantity.setVisible(true);
                order.add(orderQuantity);
                orderQuantity.setBounds(0,51,100,30);

                order.add(done);
                done.setVisible(true);
                done.setBounds(0,101,100,30);
                done.addActionListener(new OrderModify());
                order.add(bg);
                backGround();



            }
        }
        public class  OrderModify implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                i = 0;
                try {
                    while (Store.productsArrayList.get(i) != null) {
                        if (Store.productsArrayList.get(i).productID.equals(searchTextField.getText())) {

                            done.addActionListener(new Modifying());
                            foundProduct = true;
                            dashboardFrame.dispose();
                            if (foundProduct) {
                                if((Store.productsArrayList.get(i).productQuantity-=Integer.parseInt((orderQuantity.getText())))<=0)
                                {
                                    done.addActionListener(new DeleteProduct());
                                }
                                Store.productsArrayList.get(i).productQuantity-=Integer.parseInt((orderQuantity.getText()));
                                j = i;
                                break;
                            }
                        }
                        i++;
                    }
                } catch (Exception e1) {
                    e1.getMessage();
                }

            }
        }
        public class AddNewProduct implements ActionListener {


            @Override
            public void actionPerformed(ActionEvent e) {
                newProduct.setVisible(true);
                newProduct.setSize(500, 700);
                newProduct.setLayout(null);
                newProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                newProduct.add(productID);
                productID.setBounds(20, 40, 100, 50);


                newProduct.add(productName);
                productName.setBounds(20, 80, 100, 50);


                newProduct.add(productPrice);
                productPrice.setBounds(20, 120, 100, 50);


                newProduct.add(productQuantity);
                productQuantity.setBounds(20, 160, 100, 50);


                newProduct.add(productIDtext);
                productIDtext.getText();
                productIDtext.setText("");
                productIDtext.setBounds(120, 55, 130, 25);


                newProduct.add(productNameText);
                productNameText.getText();
                productNameText.setText("");
                productNameText.setBounds(120, 95, 130, 25);


                newProduct.add(priceText);
                priceText.getText();
                priceText.setText("");
                priceText.setBounds(120, 135, 130, 25);


                newProduct.add(quantitytext);
                quantitytext.getText();
                quantitytext.setText("");

                quantitytext.setBounds(120, 175, 130, 25);


                JButton done = new JButton("Done");
                newProduct.add(done);
                done.setBounds(160, 260, 100, 25);
                done.addActionListener(new AddProducts());

                JButton back = new JButton("Back");
                newProduct.add(back);
                back.setBounds(20, 260, 100, 25);

                back.addActionListener(new DashBoard());
                newProduct.add(bg);
                backGround();

                dashboardFrame.dispose();


            }
        }

        public class AddProducts implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                price = Double.parseDouble(priceText.getText());

                quantity = Integer.parseInt(quantitytext.getText());
                Products p = new Products(productNameText.getText(), productIDtext.getText(), price, quantity);
                Store.productsArrayList.add(p);
                try {
                    //PrintWriter pw = new PrintWriter(new File("product.txt"));
                    //BufferedWriter bw = new BufferedWriter(new File("product.txt"),true)
                    fw.write(productNameText.getText() + " " + productIDtext.getText() + " " + price + " " + quantity);
                    fw.write(System.getProperty("line.separator"));
                    fw.flush();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }


            }
        }

        public class modifyProduct implements ActionListener {


            @Override
            public void actionPerformed(ActionEvent e) {
                modifyProduct.setVisible(true);
                modifyProduct.setSize(500, 700);
                modifyProduct.setLayout(null);
                modifyProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                foundProduct = false;
                modifyProduct.add(modproductID);

                modproductID.setBounds(20, 40, 100, 50);


                modifyProduct.add(modproductName);
                modproductName.setBounds(20, 80, 100, 50);


                modifyProduct.add(modproductPrice);
                modproductPrice.setBounds(20, 120, 100, 50);


                modifyProduct.add(modproductQuantity);
                modproductQuantity.setBounds(20, 160, 100, 50);


                modifyProduct.add(productIDtext);
                productIDtext.getText();
                productIDtext.setText("");
                productIDtext.setBounds(120, 55, 130, 25);


                modifyProduct.add(productNameText);
                productNameText.getText();
                productNameText.setText("");
                productNameText.setBounds(120, 95, 130, 25);


                modifyProduct.add(priceText);
                priceText.getText();
                priceText.setText("");
                priceText.setBounds(120, 135, 130, 25);


                modifyProduct.add(quantitytext);
                quantitytext.getText();
                quantitytext.setText("");

                quantitytext.setBounds(120, 175, 130, 25);


                modifyProduct.add(done);
                done.setBounds(160, 260, 100, 25);


                modifyProduct.add(back);
                back.setBounds(20, 260, 100, 25);
                back.addActionListener(new DashBoard());

                i = 0;
                try {
                    while (Store.productsArrayList.get(i) != null) {
                        if (Store.productsArrayList.get(i).productID.equals(searchTextField.getText())) {

                            done.addActionListener(new Modifying());
                            foundProduct = true;
                            dashboardFrame.dispose();
                            if (foundProduct) {
                                j = i;
                                break;
                            }
                        }
                        i++;
                    }
                } catch (Exception e1) {
                    e1.getMessage();
                }


                modifyProduct.add(bg);
                backGround();
            }
        }

        public class Modifying implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                foundProduct = true;

                price = Double.parseDouble(priceText.getText());

                quantity = Integer.parseInt(quantitytext.getText());
                Store.productsArrayList.get(i).productName = productNameText.getText();
                Store.productsArrayList.get(i).productID = productIDtext.getText();
                Store.productsArrayList.get(i).productPrice = price;
                Store.productsArrayList.get(i).productQuantity = quantity;
                System.out.println(Store.productsArrayList.get(i).productName + Store.productsArrayList.get(i).productID + Store.productsArrayList.get(i).productPrice + Store.productsArrayList.get(i).productQuantity);
                String line;
                int i=0;
                try {

                    File inputFile = new File("product.txt");
                    File tempFile = new File("temp.txt");

                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                    try{
                        while(Store.productsArrayList.get(i)!=null)
                        {
                            writer.write(Store.productsArrayList.get(i).productName+ " " + Store.productsArrayList.get(i).productID + " " + Store.productsArrayList.get(i).productPrice + " " + Store.productsArrayList.get(i).productQuantity);
                            writer.write(System.getProperty("line.separator"));
                            writer.flush();
                            i++;
                        }

                        writer.close();
                        reader.close();
                    } catch (Exception e1){

                    }

                    boolean successful = tempFile.renameTo(inputFile);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        }

        public class DeleteProduct implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete.setVisible(true);
                delete.setSize(500, 700);
                delete.setLayout(null);
                delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                i = 0;
                try {
                    while (Store.productsArrayList.get(i) != null) {
                        if (Store.productsArrayList.get(i).productID.equals(searchTextField.getText())) {
                            delete.add(label);
                            label.setVisible(true);
                            label.setBounds(0,0,300,30);
                            label.setText(Store.productsArrayList.get(i).productName + " " + Store.productsArrayList.get(i).productID + " " + Store.productsArrayList.get(i).productPrice + " " + Store.productsArrayList.get(i).productQuantity);
                            done.addActionListener(new Modifying());
                            foundProduct = true;
                            dashboardFrame.dispose();
/*                            File tempFile = new File("temp.txt");
                            File prevFile = new File("product.txt");
                            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

                            String lineToRemove =Store.productsArrayList.get(i).productName + " " + Store.productsArrayList.get(i).productID + " " + Store.productsArrayList.get(i).productPrice + " " + Store.productsArrayList.get(i).productQuantity;
                            String currentLine;
                            while((currentLine = br.readLine()) != null) {
                                // trim newline when comparing with lineToRemove
                                String trimmedLine = currentLine.trim();
                                if(trimmedLine.equals(lineToRemove)) continue;
                                bw.write(currentLine + System.getProperty("line.separator"));
                            }
                            bw.close();
                            br.close();
                            tempFile.renameTo(prevFile);*/


                            if (foundProduct) {
                                File inputFile = new File("product.txt");
                                File tempFile = new File("temp.txt");

                                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                                String lineToRemove = Store.productsArrayList.get(i).productName + " " + Store.productsArrayList.get(i).productID + " " + Store.productsArrayList.get(i).productPrice + " " + Store.productsArrayList.get(i).productQuantity;
                                String currentLine;

                                while((currentLine = reader.readLine()) != null) {
                                    // trim newline when comparing with lineToRemove
                                    String trimmedLine = currentLine.trim();
                                    if(trimmedLine.equals(lineToRemove)) continue;
                                    writer.write(currentLine + System.getProperty("line.separator"));
                                }
                                //writer.close();
                                //reader.close();
                                boolean successful = tempFile.renameTo(inputFile);
                                writer.close();
                                reader.close();
                                Store.productsArrayList.remove(i);
                                j = i;
                                break;
                            }
                        }
                        i++;
                    }
                } catch (Exception e1) {
                    e1.getMessage();
                }
                if(!foundProduct)
                {
                    delete.add(label);
                    label.setVisible(true);
                    label.setBounds(0,0,300,30);
                    label.setText("Not Found");
                }
                delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                backGround();

                dashboardFrame.dispose();
            }
        }

        public class ShowProducts implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                i = 0;
                int y =251;


   /*             if(Store.productsArrayList!=null)
                {
                    try{
                        for(i=0;Store.productsArrayList.get(i)!=null;i++){

                            dashboardFrame.add(label);
                            label.setVisible(true);
                            label.setBounds(0,y,100,30);
                            label.setText("");
                            y+=30;


                        }
                    } catch (Exception e2){

                    }*/
                y=251;
                String product = "";
                try{
                    i=0;
                    while(Store.productsArrayList.get(i)!=null){


                            /*label.setText(Store.productsArrayList.get(i).productName + " " + Store.productsArrayList.get(i).productID + " " + Store.productsArrayList.get(i).productPrice + " " + Store.productsArrayList.get(i).productQuantity);
                            */
                        product+=Store.productsArrayList.get(i).productName + " " + Store.productsArrayList.get(i).productID + " " + Store.productsArrayList.get(i).productPrice + " " + Store.productsArrayList.get(i).productQuantity+"\n";
                        //y+=30;
                        i++;


                    }
                } catch (Exception e2){

                }
                dashboardFrame.add(label);
                label.setVisible(true);
                label.setBounds(0,251,500,300);
                label.setText(convertToMultiline(product));
                //label.setText(product);
                //label.



            }
            public String convertToMultiline(String forMultiline){
                return "<html>"+forMultiline.replace("\n","<br>");
            }

        }
        void showProductInfo() {
            int y = 251;
            if (Store.productsArrayList != null) {


                try {
                    for (i = 0; Store.productsArrayList.get(i) != null; i++) {
                        dashboardFrame.add(showProductInfo);
                        showProductInfo.setVisible(true);
                        showProductInfo.setBounds(0, y, 100, 30);
                        showProductInfo.setText(Store.productsArrayList.get(i).productName + " " + Store.productsArrayList.get(i).productID + " " + Store.productsArrayList.get(i).productPrice + " " + Store.productsArrayList.get(i).productQuantity);
                        y += 30;
                    }
                } catch (Exception e2) {

                }
            }

        }


    }
    void backGround()
    {
/*        loginFrame.add(bg);
        dashboardFrame.add(bg);
        modifyProduct.add(bg);
        newProduct.add(bg);
        delete.add(bg);
        order.add(bg);*/
        bg.setBounds(0,0,500,700);
        bg.setVisible(true);


    }
}