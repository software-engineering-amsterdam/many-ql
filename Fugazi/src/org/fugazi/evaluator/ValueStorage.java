package org.fugazi.evaluator;

import java.util.HashMap;

public class ValueStorage extends HashMap<String, ExpressionValue> {

    public void saveValue(String _id, ExpressionValue _val) {
        this.put(_id, _val);
    }

    public ExpressionValue getValue(String _id) {
        return this.containsKey(_id) ? this.get(_id) : new UndefinedValue();
    }
}
