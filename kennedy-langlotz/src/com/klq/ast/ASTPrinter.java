package com.klq.ast;

import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.bool.AndNode;
import com.klq.ast.impl.expr.bool.OrNode;
import com.klq.ast.impl.expr.comp.*;
import com.klq.ast.impl.expr.math.*;
import com.klq.logic.expression.operator.bool.And;

import java.util.ArrayList;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class ASTPrinter implements IVisitor<Void> {
    @Override
    public Void visit(QuestionnaireNode node) {
        System.out.println("Questionnaire Node");
        System.out.printf("children count: %s", node.getChildren().size());
        System.out.println();
        printLine();
        for(ANode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(QuestionNode node) {
        System.out.println("Question Node");
        node.printSelf();
        printLine();
        return null;
    }

    @Override
    public Void visit(ComputedQuestionNode node) {
        System.out.println("Computed Question Node");
        node.printSelf();
        printLine();
        node.getChild().accept(this);
        return null;
    }

    @Override
    public Void visit(GreaterThanNode node) {
        System.out.println("Greater Than Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(GreaterEqualsNode node) {
        System.out.println("Greater Than or Equals Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(LessThanNode node) {
        System.out.println("Less Than Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(LessEqualsNode node) {
        System.out.println("Less Than or Equals Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(EqualsNode node) {
        System.out.println("Equals Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(NotEqualsNode node) {
        System.out.println("Not Equals Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(AndNode node) {
        System.out.println("And Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(OrNode node) {
        System.out.println("Or Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(IdentifierNode node) {
        System.out.println("Identifier Node");
        System.out.println(node.getIdentifier());
        printLine();
        return null;
    }

    @Override
    public Void visit(ConditionalNode node) {
        System.out.println("Conditional Node");
        node.printSelf();
        printLine();
        node.getCondition().accept(this);
        for(ANode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StringNode node) {
        System.out.println("String Node");
        System.out.printf("Value: %s", node.getString());
        System.out.println();
        printLine();
        return null;
    }

    @Override
    public Void visit(NumberNode node) {
        System.out.println("Number Node");
        System.out.printf("Value: %s", node.getNumber());
        System.out.println();
        printLine();
        return null;
    }

    @Override
    public Void visit(DateNode node) {
        System.out.println("Date Node");
        System.out.printf("Value: %s", node.getDate());
        System.out.println();
        printLine();
        return null;
    }

    @Override
    public Void visit(MultiplyNode node) {
        System.out.println("Multiply Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(AddNode node) {
        System.out.println("Add Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(SubtractNode node) {
        System.out.println("Subtract Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    public Void visit(DivideNode node){
        System.out.println("Divide Node");
        node.printChildren();
        printLine();
        visitBinaryChildren(node);
        return null;
    }

    @Override
    public Void visit(ANode node) {
        return null;
    }

    private void printLine(){
        System.out.println("--------------------------------------------");
    }

    private void visitBinaryChildren(ABinaryExprNode node){
        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
    }
}
