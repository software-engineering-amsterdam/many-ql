package com.klq.ast.impl.expr;

import com.klq.ast.ANode;
import com.klq.ast.impl.expr.value.IdentifierValue;
import com.klq.ast.impl.expr.value.Value;

import java.util.Map;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class AExpression extends ANode {
    private final AExpression left;
    private final AExpression right;

    //TODO
    public AExpression(AExpression left, AExpression right, String location){
        super(location);
        this.left = left;
        this.right = right;
    }

    public abstract Value evaluate(Map<String, Value> variableTable);

    public AExpression getLeft() {
        return left;
    }

    public AExpression getRight() {
        return right;
    }
}
