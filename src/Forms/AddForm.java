/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author crafttor
 */
/**
 * Для отрисовки форм
 */
public class AddForm extends JPanel {
    public AddForm(){

        //JTable addform = new JTable();
        JFrame frame = new JFrame("Frame");
        frame.setSize(new Dimension(800, 600));
        frame.setTitle("Еда");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // чтобы процесс не завершался после закрытия окна
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());
        panel4.setLayout(new BorderLayout());


        panel1.setBackground(Color.cyan);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.WEST);


        JTextField textField = new JTextField(50);
        panel1.add(textField, BorderLayout.NORTH);
        textField.setBackground(Color.GREEN);
        textField.setText("Название продукта");
        textField.getText();


        JTextField textField1 = new JTextField(50);
        panel2.add(textField1, BorderLayout.EAST);
        textField1.setBackground(Color.CYAN);
        textField1.setText("количество");
        textField1.getText();

        JTextField textField2 = new JTextField(50);
        panel3.add(textField2, BorderLayout.WEST);
        textField2.setBackground(Color.RED);
        textField2.setText("количество");
        textField2.getText();

        JTextField textField3 = new JTextField(50);
        panel4.add(textField3, BorderLayout.CENTER);
        textField3.setBackground(Color.GREEN);
        textField3.setText("количество");
        textField3.getText();




        JPanel panel5 = new JPanel();



        panel1.setBackground(Color.cyan);
        panel2.setBackground(Color.blue);
        panel3.setBackground(Color.RED);
        panel4.setBackground(Color.YELLOW);
        panel5.setBackground(Color.LIGHT_GRAY);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.add(panel3, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.EAST);
        frame.add(panel5, BorderLayout.CENTER);


       /* frame.setLayout(new GridBagLayout()); //для прогрессбара
            JProgressBar progressBar = new JProgressBar();
            progressBar.setStringPainted(true);
            progressBar.setIndeterminate(true);
            progressBar.setMinimum(0);
            progressBar.setMaximum(100);
*/






        frame.setVisible(true);


    }
}
