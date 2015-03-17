package com.klq.gui;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.value.IdentifierValue;
import com.klq.ast.impl.stmt.*;
import com.klq.controller.Store;
import com.klq.gui.control.*;

import java.util.ArrayList;

/**
 * Created by juriaan on 17-2-15.
 */
public class AST2GUIConverter implements IStatementVisitor<IKLQItem> {
    private Store store;

    /*==================================================================================================================
    Statements
     ==================================================================================================================*/
    @Override
    public IKLQItem visit(QuestionnaireNode node) {
        store = new Store();
        for(AStatementNode child : node.getChildren()){
            if(child instanceof QuestionNode) {
                ARenderedQuestion question = (ARenderedQuestion) child.accept(this);
                store.add(question);
            }
            else if(child instanceof ConditionalNode){
                QuestionList questionList = (QuestionList) child.accept(this);
                for(ARenderedQuestion question : questionList.getList()){
                    store.add(question);
                }
            }
        }
        return store;
    }

    @Override
    public IKLQItem visit(ConditionalNode node) {
        AExpression expr = node.getCondition();
        QuestionList questionList = new QuestionList();

        //todo refactor
        for(AStatementNode child : node.getChildren()){
            if(child instanceof QuestionNode) {
                ARenderedQuestion question = (ARenderedQuestion) child.accept(this);
                question.addDependency(expr);
                questionList.add(question);
            }
            else if(child instanceof ConditionalNode){
                QuestionList questionListOfChild = (QuestionList) child.accept(this);
                for(ARenderedQuestion question : questionListOfChild.getList()){
                    question.addDependency(expr);
                    questionList.add(question);
                }
            }
        }
        return questionList;
    }

    @Override
    public IKLQItem visit(QuestionNode node) {
        String id = node.getID();
        Type type = node.getType();
        String text = new String(node.getText());

        if (type == Type.BOOLEAN){
            return new BooleanRenderedQuestion(id, type, text, new ArrayList<>(), store);
        } else if (type == Type.DATE){
            return new DateRenderedQuestion(id, type, text, new ArrayList<>(), store);
        } else if (type == Type.STRING || type == Type.NUMERAL) {
            return new TextRenderedQuestion(id, type, text, new ArrayList<>(), store);
        }
        throw new IllegalArgumentException("Unknown type.");
    }

    @Override
    public IKLQItem visit(ComputedQuestionNode node) {
        IdentifierValue id = new IdentifierValue(node.getID());
        Type type = node.getType();
        String text = new String(node.getText());

        return new ComputedRenderedQuestion(id.toString(), type, text, new ArrayList<>(), node.getComputedAnswer(), store);
    }

    /*
    *//*==================================================================================================================
    Expressions - Mathematical
     ==================================================================================================================*//*
    @Override
    public IKLQItem visit(MultiplyNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new Multiplication(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(DivideNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new Division(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(AddNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new Addition(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(SubtractNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new Subtraction(leftChild, rightChild);
    }

    *//*==================================================================================================================
    Expressions - Boolean
     ==================================================================================================================*//*
    @Override
    public IKLQItem visit(GreaterThanNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new GreaterThan(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(GreaterEqualsNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new GreaterEquals(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(LessThanNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new LessThan(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(LessEqualsNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new LessEquals(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(EqualsNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new Equals(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(NotEqualsNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new NotEquals(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(AndNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new And(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(OrNode node) {
        AExpression leftChild = (AExpression) node.getLeftChild().accept(this);
        AExpression rightChild = (AExpression) node.getRightChild().accept(this);
        return new Or(leftChild, rightChild);
    }

    @Override
    public IKLQItem visit(IdentifierNode node) {
        if(identifiers.containsKey(node.getIdentifier())){
            return identifiers.get(node.getIdentifier());
        }
        else {
            IdentifierValue id = new IdentifierValue(node.getIdentifier());
            identifiers.put(node.getIdentifier(), id);
            return id;
        }
    }
    *//*==================================================================================================================
            Primitives
     ==================================================================================================================*//*
    @Override
    public IKLQItem visit(StringNode node) {
        return new StringValue(node.getString());
    }

    @Override
    public IKLQItem visit(NumberNode node) {
        return new NumberValue(node.getNumber());
    }

    @Override
    public IKLQItem visit(DateNode node) {
        return new DateValue(node.getDate());
    }*/
}
