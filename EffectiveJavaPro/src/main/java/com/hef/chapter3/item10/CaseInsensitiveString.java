package com.hef.chapter3.item10;

import java.util.Objects;

/**
 * @Date 2020/1/2
 * @Author lifei
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s){
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
