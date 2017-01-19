/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myCraftForm;

/**
 *
 * @author crafttor
 */
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import myCraftForm.database.connection.DB;


import myCraftForm.database.visual.BookPanel;

public class Main {



    public static DB DBCon;


    public static void main(String[] args) throws InterruptedException, SQLException {

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


        frame.setVisible(true);// отображаем окно
    }


}
