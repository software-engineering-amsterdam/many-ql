package com.klq.ast.impl.expr;

import com.common.Location;
import com.klq.ast.ANode;
import com.klq.ast.impl.expr.value.Value;

import java.util.Map;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class AExpression extends ANode {

    public AExpression(Location location){
        super(location);
    }

    public AExpression() {
        super();
    }

    public abstract Value evaluate(Map<String, Value> variableTable);

    public boolean anyUndefined(Value leftChild, Value rightChild){
        return leftChild.isUndefined() || rightChild.isUndefined();
    }
}
