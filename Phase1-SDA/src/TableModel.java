//import packages
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhi
 */
public class TableModel extends AbstractTableModel{

    private List <Exhibit> exhibits;
    private String[] columnNames = { "Exhibit ID", "Exhibit name", "Description",
                "Location", "Weight", "Height"};
    
    //initialize the table model with list items
    public TableModel(List<Exhibit> exhibits){
         this.exhibits = exhibits;
    }
    
    //returns the number of rows
    @Override
    public int getRowCount() {
        return exhibits.size(); 
    }

    //return the number of columns
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    //returns the column name depending on columnIndex provided
    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }
    
    //returns the item located at specified row and column as in [i,j]
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exhibit ea = exhibits.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return ea.getExhibitId();
            case 1:
                return ea.getExhibitname();
            case 2:
                return ea.getDescription();
            case 3:
                return ea.getLocation();
            case 4:
                return ea.getWeight();
            case 5:
                return ea.getHeight(); 
           }
           return null;
    }
}// end class TableModel
