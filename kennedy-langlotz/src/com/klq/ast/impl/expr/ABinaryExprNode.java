package com.klq.ast.impl.expr;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

/**
 * Created by Juriaan on 21-2-2015.
 */
public abstract class ABinaryExprNode extends ANode {
    private ANode leftChild;
    private ANode rightChild;

    public ABinaryExprNode(ANode leftChild, ANode rightChild, String location) {
        super(location);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public ANode getLeftChild() {
        return leftChild;
    }

    public ANode getRightChild() {
        return rightChild;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    //for testing purposes, maybe remove later?
    public void printChildren(){
        System.out.printf("Left child: %s", leftChild.getClass());
        if(leftChild instanceof NumberNode){
            System.out.printf(", Left value: %s", ((NumberNode) leftChild).getNumber());
        }
        System.out.println();
        System.out.printf("Right child: %s", rightChild.getClass());
        if(rightChild instanceof NumberNode){
            System.out.printf(", Right value: %s", ((NumberNode)rightChild).getNumber());
        }
        System.out.println();
    }
}
