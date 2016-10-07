/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import myplatform.DB;

/**
 *
 * @author crafttor
 */
public class RecipeBookTableModel extends AbstractTableModel {
    private int columnCount = 4;
    private ArrayList<String[]>dataArrayList;

    public RecipeBookTableModel() {
        dataArrayList = new ArrayList<String[]>();
        for(int i = 0; i < dataArrayList.size(); i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    public int getRowCount() {
        return dataArrayList.size();
    }

    public int getColumnCount() {
        return columnCount;
    }

    public  String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0: return "id";
            case 1: return "product";
            case 2: return "sum";
            case 3: return "unit";
        }
        return "";
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    public void addData(String [] row){
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }
    public void addData (DB db){
        ResultSet result = db.resultSetQuery("Select * FROM Products");
        dataArrayList.clear();
        try {
            while (result.next()){

                String []row = {
                        result.getString("id"),
                        result.getString("product"),
                        result.getString("sum"),
                        result.getString("unit")
                };
            addData(row);
            
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
