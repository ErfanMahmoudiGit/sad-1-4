package ir.znu.sad.ui.html;

import java.util.ArrayList;
import java.util.List;

public class Table<K> {

    String name;

    String[] columnNameList;

    List<K[]> rows;

    public Table(String name, String[] columnNameList) {
        this.name = name;
        this.columnNameList = columnNameList;
        this.rows=new ArrayList<>();
    }

    public boolean addRow(K[] row){
        if(row.length!=columnNameList.length){
            return false;
        }
        rows.add(row);
        return true;
    }

    public String getName() {
        return name;
    }

    public String[] getColumnNameList() {
        return columnNameList;
    }

    public List<K[]> getRows() {
        return rows;
    }
}
