package ir.znu.sad.data.datatype;

import ir.znu.sad.utils.datatype.Pair;

import java.util.ArrayList;
import java.util.List;

public class Table {
    String name;
    Pair<String,ColumnType>[] columns;
    List<String[]> values=new ArrayList<>();

    public Table(String name, Pair<String, ColumnType>[] columns) {
        this.name = name;
        this.columns = columns;
    }

    public Table(String name, List<Pair<String, ColumnType>> columns) {
        this.name = name;
        this.columns = columns.stream().toArray(Pair[]::new);
    }

    public String getName() {
        return name;
    }

    public Pair<String, ColumnType>[] getColumns() {
        return columns;
    }

    public boolean addRowValue(String[] rowValue){
        if(rowValue.length!=columns.length)
            return false;
        else{
            values.add(rowValue);
            return true;
        }
    }

    public List<String[]> getValues() {
        return values;
    }
    public List<String[]> getRows() {
        return getValues();
    }

    public static enum ColumnType{
        STRING,
        INT,
        LONG,
        BOOLEAN
    }
}