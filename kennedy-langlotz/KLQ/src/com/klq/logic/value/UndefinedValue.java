package com.klq.logic.value;

/**
 * Created by Timon on 03.03.2015.
 */
public class UndefinedValue extends Value<Void> {

    public UndefinedValue(){
        super(null);
    }

    @Override
    public String toString() {
        return "---";
    }
}
