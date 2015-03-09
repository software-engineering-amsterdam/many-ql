package com.klq.ast.impl.expr.value;

/**
 * Created by Timon on 03.03.2015.
 */
public class UndefinedValue extends ComparableValue {

    public UndefinedValue(){
        super(null, true);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UndefinedValue;
    }

    @Override
    public String toString() {
        return "---";
    }
}
