package ir.znu.sad.utils.datatype;

public class BaseResult <T> {
    T result;

    public BaseResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}
