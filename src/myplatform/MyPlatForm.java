/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myplatform;

import Forms.BookPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author crafttor
 */
public class MyPlatForm {

    /**
     * @param args the command line arguments
     */



    public static DB DBCon;

    public static void main(String[] args) throws InterruptedException {

        DBCon = new DB();
        DBCon.db();




        JFrame frame = new JFrame("Frame");
        frame.setSize(new Dimension(600, 400));
        frame.setTitle("Еда");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        BookPanel bookPanel = new BookPanel(DBCon);
        frame.add(bookPanel, BorderLayout.CENTER);
        bookPanel.init();
        /*JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());
        panel4.setLayout(new BorderLayout());

        panel1.setBackground(Color.cyan);
        panel2.setBackground(Color.blue);
        panel3.setBackground(Color.RED);
        panel4.setBackground(Color.YELLOW);
        panel5.setBackground(Color.LIGHT_GRAY);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.add(panel3, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.EAST);
        frame.add(panel5, BorderLayout.CENTER);*/


        //frame.pack(); спакует все
        //frame.setLayout(new GridBagLayout()); //для прогрессбара
    /*    JProgressBar progressBar = new JProgressBar();
            progressBar.setStringPainted(true);
            progressBar.setIndeterminate(true);
            progressBar.setMinimum(0);
            progressBar.setMaximum(100);
            frame.add(progressBar, BorderLayout.PAGE_START);                                                            //сверху
            for (int i = progressBar.getMinimum(); i <= progressBar.getMaximum(); i++) {
                Thread.sleep(500);
                progressBar.setValue(i);
            }*/


        /*JTextField textField = new JTextField(20);
        panel1.add(textField, BorderLayout.NORTH);
        textField.setBackground(Color.GREEN);
        textField.setText("Введите необходимый рецепт");
        textField.getText();






        //myButton.setBackground(new Color(147, 188, 235));
        //myButton.setForeground(Color.ORANGE);
            Cursor cursor = new Cursor(Cursor.W_RESIZE_CURSOR);
        myButton.setCursor(cursor);

            JButton myButton2 = new JButton("Вторая кнопка");
        panel3.add(myButton2, BorderLayout.WEST);
        myButton2.addActionListener(new MyButtonActionListener());

        myButton2.setBackground(new Color(11, 12, 200));
        myButton2.setForeground(Color.yellow);
            Cursor cursor2 = new Cursor(Cursor.W_RESIZE_CURSOR);
        myButton2.setCursor(cursor2);*/



        frame.setVisible(true);




 /*       String query = "select * from Products where availability = 1"; //найти все доступные продукты
        try {
            Statement statement = DB.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Products Product = new Products();
                Product.setId(resultSet.getInt(1));
                Product.setProduct(resultSet.getString(2));
                Product.setDescription(resultSet.getString(6));
                System.out.println(Product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


    }


}

    

