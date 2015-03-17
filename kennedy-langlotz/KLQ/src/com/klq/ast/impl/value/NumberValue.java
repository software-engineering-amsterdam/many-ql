package com.klq.ast.impl.value;

import java.math.BigDecimal;

/**
 * Created by Timon on 03.03.2015.
 */
public class NumberValue extends ComparableValue<BigDecimal> {

    public NumberValue(BigDecimal value){
        super(value);
    }
}
