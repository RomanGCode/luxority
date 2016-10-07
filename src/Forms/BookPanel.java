/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import myplatform.DB;

/**
 *
 * @author crafttor
 */
public class BookPanel extends JPanel implements Runnable{

    private DB con;
    private RecipeBookTableModel rbtm = new RecipeBookTableModel();
    private JTable recipeBook = new JTable(rbtm);

    private JButton addButton = new JButton("Добавить");// создаём кнопку
    private JButton deleteButton = new JButton("Удалить");// создаём кнопку
    private JButton clearButton = new JButton("Очистить");// создаём кнопку


    public BookPanel(DB con){
        this.con = con;
        setLayout(new GridBagLayout());

        (new Thread(this)).start();//запуск потока самого себя
        //TODO Разобраться как работают потоки
    }
  public void init() {
        for (int i =0; i < rbtm.getColumnCount(); i++) {
            recipeBook.getColumnModel().getColumn(i).setCellRenderer(new Renderer());
        }
        JScrollPane recipeBookScroolPage = new JScrollPane(recipeBook);
        recipeBookScroolPage.setPreferredSize(new Dimension(400, 400));


        add(recipeBookScroolPage, new GridBagConstraints(0, 0, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        // добавляем кнопку на окно
        add(addButton, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddForm();
                }
            });
        // добавляем кнопку на окно
        add(deleteButton, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        // добавляем кнопку на окно
        add(clearButton, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

    }


    @Override
    public void run() {
        //вечный ход
        while (true){
            try {
                rbtm.addData(con);
                repaint();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
