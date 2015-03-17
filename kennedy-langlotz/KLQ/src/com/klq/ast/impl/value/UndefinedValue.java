package com.klq.ast.impl.value;

/**
 * Created by Timon on 03.03.2015.
 */
public class UndefinedValue extends ComparableValue {

    public UndefinedValue(){
        super(null);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UndefinedValue;
    }

    @Override
    public boolean isUndefined() {
        return true;
    }

    @Override
    public String toString() {
        return "---";
    }
}
