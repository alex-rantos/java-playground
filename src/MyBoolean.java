package src;

import java.util.Objects;

public class MyBoolean {
    boolean val;

    public MyBoolean() {
    }

    public MyBoolean(boolean val) {
        this.val = val;
    }

    public boolean getVal() {
        return this.val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }

    public MyBoolean val(boolean val) {
        this.val = val;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MyBoolean)) {
            return false;
        }
        MyBoolean myInteger = (MyBoolean) o;
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
