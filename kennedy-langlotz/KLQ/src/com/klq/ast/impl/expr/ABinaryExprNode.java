package com.klq.ast.impl.expr;

import com.klq.ast.impl.Location;

/**
 * Created by Juriaan on 21-2-2015.
 */
public abstract class ABinaryExprNode extends AExpression {
    private AExpression leftChild;
    private AExpression rightChild;

    public ABinaryExprNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(location);
        init(leftChild, rightChild);
    }

    public ABinaryExprNode(AExpression leftChild, AExpression rightChild) {
        super();
        init(leftChild, rightChild);
    }

    private void init(AExpression leftChild, AExpression rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public AExpression getLeftChild() {
        return leftChild;
    }

    public AExpression getRightChild() {
        return rightChild;
    }

    //for testing purposes, maybe remove later?
    public void printChildren(){
        System.out.printf("Left child: %s", leftChild.getClass());
        /*if(leftChild instanceof NumberNode){
            System.out.printf(", Left value: %s", ((NumberNode) leftChild).getNumber());
        }
        System.out.println();
        System.out.printf("Right child: %s", rightChild.getClass());
        if(rightChild instanceof NumberNode){
            System.out.printf(", Right value: %s", ((NumberNode)rightChild).getNumber());
        }
        System.out.println();*/
    }
}
