package myCraftForm.database.visual;

/**
 *
 * @author crafttor
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import myCraftForm.database.connection.DB;
import myCraftForm.database.model.RecipeBookTableModel;



/**
 * Created by crafttor on 31.07.16.
 * Сама панель View
 */
public class BookPanel extends JPanel implements Runnable{
    private int delObj;
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

    }
    public void init() {
        for (int i =0; i < rbtm.getColumnCount(); i++) {
            recipeBook.getColumnModel().getColumn(i).setCellRenderer(new Renderer());
        }
        final JScrollPane recipeBookScroolPage = new JScrollPane(recipeBook);
        recipeBookScroolPage.setPreferredSize(new Dimension(400, 400));

        
        //определить значение курсора мыши
        recipeBook.addMouseListener(new MouseAdapter(){
            @Override            
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {//одинарный шелчок
                    int row = recipeBook.rowAtPoint(e.getPoint());
                        if (row > -1) {
                            int curRow = recipeBook.convertRowIndexToModel(row);
                            delObj = Integer.parseInt(recipeBook.getValueAt(curRow, 0).toString());
                        }
                }
            }
        });
        
        add(recipeBookScroolPage, new GridBagConstraints(0, 0, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        // добавляем кнопку на окно
        add(addButton, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //new AddForm();
                    JFrame frame = new JFrame("addform");
                    frame.setContentPane(new ADForm().getContentPane());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);

                }
            });
        // добавляем кнопку на окно
        add(deleteButton, new GridBagConstraints(1, 1, 1, 1, 1, 1,
             GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        con.sqlDeleteRow(delObj);
                    }
                });

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