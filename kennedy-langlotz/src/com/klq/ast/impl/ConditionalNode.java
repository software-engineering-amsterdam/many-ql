package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

import java.util.ArrayList;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class ConditionalNode extends ANode {
    ANode condition;
    ArrayList<ANode> children;

    public ConditionalNode(ANode condition, ArrayList<ANode> children) {
        this.condition = condition;
        this.children = children;
    }

    @Override
    public void printSelf() {
        System.out.printf("Condition class: %s", condition.getClass());
        System.out.println();
        System.out.printf("Children size: %s", children.size() );
        System.out.println();
    }

    @Override
    public void accept(IVisitor visitor) {
        condition.accept(visitor);
        for(ANode child: children){
            child.accept(visitor);
        }
        visitor.visit(this);
    }
}
