package com.klq.ast.impl.expr;

import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.Location;
import com.klq.ast.impl.ANode;
import com.klq.ast.impl.value.Value;
import com.klq.controller.VariableTable;

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

    public abstract <T> T  accept(IExpressionVisitor<T> visitor);

    public abstract Value evaluate(VariableTable variableTable);

    public boolean anyUndefined(Value leftChild, Value rightChild){
        return leftChild.isUndefined() || rightChild.isUndefined();
    }
}
