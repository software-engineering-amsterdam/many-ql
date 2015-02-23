package org.fugazi;

import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.UndefinedValue;

import java.util.HashMap;

/**
 * Value keeper: <identifier name, value >
 */
public class ValueStorage extends HashMap<String, ExpressionValue> {

    public void saveValue(String _id, ExpressionValue _val) {
        this.put(_id, _val);
    }

    public ExpressionValue getValue(String _id) {
        return this.containsKey(_id) ? this.get(_id) : new UndefinedValue();
    }

    public Boolean isValueExists(String _id) {
        return this.containsKey(_id);
    }

}
