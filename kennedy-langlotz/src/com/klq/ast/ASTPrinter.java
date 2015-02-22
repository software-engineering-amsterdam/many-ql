package com.klq.ast;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.*;

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
    public void visit(MulDivNode node) {
        System.out.println("MulDiv Node");
        printLine();
    }

    @Override
    public void visit(ANode node) {
    }

    private void printLine(){
        System.out.println("--------------------------------------------");
    }
}
