package com.klq.ast;

import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.comp.GreaterThanNode;
import com.klq.ast.impl.expr.math.*;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class ASTPrinter implements IVisitor {
    @Override
    public void visit(QuestionnaireNode node) {
        System.out.println("Questionnaire Node");
        System.out.printf("children count: %s", node.getChildren().size());
        System.out.println();
        printLine();
    }

    @Override
    public void visit(QuestionNode node) {
        System.out.println("Question Node");
        node.printSelf();
        printLine();
    }

    @Override
    public void visit(ComputedQuestionNode node) {
        System.out.println("Computed Question Node");
        node.printSelf();
        printLine();
    }

    @Override
    public void visit(GreaterThanNode node) {
        System.out.println("Greater Than Node");
        node.printChildren();
        printLine();
    }

    @Override
    public void visit(ConditionalNode node) {
        System.out.println("Conditional Node");
        node.printSelf();
        printLine();
    }

    @Override
    public void visit(StringNode node) {
        System.out.println("String Node");
        System.out.printf("Value: %s", node.getString());
        System.out.println();
        printLine();
    }

    @Override
    public void visit(NumberNode node) {
        System.out.println("Number Node");
        System.out.printf("Value: %s", node.getNumber());
        System.out.println();
        printLine();
    }

    @Override
    public void visit(DateNode node) {
        System.out.println("Date Node");
        System.out.printf("Value: %s", node.getDate());
        System.out.println();
        printLine();
    }

    @Override
    public void visit(MultiplyNode node) {
        System.out.println("Multiply Node");
        node.printChildren();
        printLine();
    }

    @Override
    public void visit(AddNode node) {
        System.out.println("Add Node");
        node.printChildren();
        printLine();
    }

    @Override
    public void visit(SubtractNode node) {
        System.out.println("Subtract Node");
        node.printChildren();
        printLine();
    }

    public void visit(DivideNode node){
        System.out.println("Divide Node");
        node.printChildren();
        printLine();
    }

    @Override
    public void visit(ANode node) {
    }

    private void printLine(){
        System.out.println("--------------------------------------------");
    }
}
