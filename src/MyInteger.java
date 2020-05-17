package src;

import java.util.Objects;

public class MyInteger {
    int val;

    public MyInteger() {
    }

    public MyInteger(int val) {
        this.val = val;
    }

    public void increment() {
        this.val++;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MyInteger val(int val) {
        this.val = val;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MyInteger)) {
            return false;
        }
        MyInteger myInteger = (MyInteger) o;
        return val == myInteger.val;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }

    @Override
    public String toString() {
        return "{" +
            " val='" + getVal() + "'" +
            "}";
    }
    
}