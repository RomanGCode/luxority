/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author crafttor
 */
public class MyButtonActionListener implements ActionListener{


    public void actionPerformed(ActionEvent event) {
            if (event.getSource() instanceof JButton) {

                String nameButtonStr = ((JButton) event.getSource()).getText();
                System.out.println("Вы запустили " + nameButtonStr);
                 if (nameButtonStr == "Добавить" ) {
                     System.out.println("да");
                        new AddForm();
                 }
                 else System.out.println("нет");
            }

            System.out.println("Hello My Wife");

        }


    }