package com.klq.ast.impl;

import com.common.ast.Location;
import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

import java.util.ArrayList;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class ConditionalNode extends ANode {
    ANode condition;
    ArrayList<ANode> children;

    public ConditionalNode(ANode condition, ArrayList<ANode> children, Location location) {
        super(location);
        this.condition = condition;
        this.children = children;
    }

    public ConditionalNode(ANode condition, ArrayList<ANode> children) {
        super();
        this.condition = condition;
        this.children = children;
    }

    public ANode getCondition() {
        return condition;
    }

    public ArrayList<ANode> getChildren() {
        return children;
    }

    @Override
    public void printSelf() {
        System.out.printf("Condition class: %s", condition.getClass());
        System.out.println();
        System.out.printf("Children size: %s", children.size() );
        System.out.println();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
