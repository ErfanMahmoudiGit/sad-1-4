package ir.znu.sad.utils.datatype;

public class Pair<KEY, VALUE>{
    KEY key;
    VALUE value;

    public Pair(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    public KEY getKey() {
        return key;
    }

    public void setKey(KEY key) {
        this.key = key;
    }

    public VALUE getValue() {
        return value;
    }

    public void setValue(VALUE value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        Pair<KEY,VALUE> o= (Pair<KEY, VALUE>) obj;
        return key.equals(o.key) && value.equals(o.value);
    }

    @Override
    public int hashCode() {
        return key.hashCode()*31+value.hashCode();
    }

}
