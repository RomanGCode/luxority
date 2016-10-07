/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author crafttor
 */
public class Renderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column){

        Component cell = super.getTableCellRendererComponent(table,value,isSelected,hasFocus, row,column);
        if ((row % 2) == 0) cell.setBackground(Color.GREEN);
        else cell.setBackground(Color.BLUE);
        if(isSelected) cell.setBackground(Color.WHITE);
    return cell;
    }
}