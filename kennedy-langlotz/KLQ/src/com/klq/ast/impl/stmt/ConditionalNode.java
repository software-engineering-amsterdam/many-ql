package com.klq.ast.impl.stmt;

import com.klq.ast.impl.Location;
import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.expr.AExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class ConditionalNode extends AStatementNode {
    AExpression condition;
    List<AStatementNode> children;

    public ConditionalNode(AExpression condition, ArrayList<AStatementNode> children, Location location) {
        super(location);
        init(condition, children);
    }

    public ConditionalNode(AExpression condition, ArrayList<AStatementNode> children) {
        super();
        init(condition, children);
    }

    private void init(AExpression condition, ArrayList<AStatementNode> children) {
        this.condition = condition;
        this.children = children;
    }

    public AExpression getCondition() {
        return condition;
    }

    public List<AStatementNode> getChildren() {
        return children;
    }

    public void printSelf() {
        System.out.printf("Condition class: %s", condition.getClass());
        System.out.println();
        System.out.printf("Children size: %s", children.size() );
        System.out.println();
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
