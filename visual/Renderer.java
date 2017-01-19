package myCraftForm.database.visual;

/**
 *
 * Раскраска таблицы посторочно
 */
 
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Renderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column){

        Component cell = super.getTableCellRendererComponent(table,value,isSelected,hasFocus, row,column);
        if ((row % 2) == 0) cell.setBackground(Color.pink);
        else cell.setBackground(Color.CYAN);
        if(isSelected) cell.setBackground(Color.WHITE);
    return cell;
    }
}
