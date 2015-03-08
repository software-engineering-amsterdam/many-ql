package com.klq;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.ComputedQuestionNode;
import com.klq.ast.impl.ConditionalNode;
import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.QuestionnaireNode;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.literal.DateNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.literal.StringNode;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.logic.IKLQItem;
import com.klq.logic.controller.Store;
import com.klq.logic.question.*;
import com.klq.ast.impl.expr.value.*;

import java.util.HashMap;

/**
 * Created by juriaan on 17-2-15.
 */
public class AST2GUIConverter implements IVisitor<IKLQItem> {
    private HashMap<String, IdentifierNode> identifiers;

    public AST2GUIConverter(){
        this.identifiers = new HashMap<String, IdentifierNode>();
    }

    /*==================================================================================================================
    Statements
     ==================================================================================================================*/
    @Override
    public IKLQItem visit(QuestionnaireNode node) {
        Store store = new Store();
        for(ANode child : node.getChildren()){
            if(child instanceof QuestionNode) {
                Question question = (Question) child.accept(this);
                store.add(question);
            }
            else if(child instanceof ConditionalNode){
                QuestionList questionList = (QuestionList) child.accept(this);
                for(Question question : questionList.getList()){
                    store.add(question);
                }
            }
        }
        return store;
    }

    @Override
    public IKLQItem visit(ConditionalNode node) {
        AExpression expr = (AExpression) node.getCondition();
        QuestionList questionList = new QuestionList();

        for(ANode child : node.getChildren()){
            if(child instanceof QuestionNode) {
                Question question = (Question) child.accept(this);
                question.addDependency(expr);
                questionList.add(question);
            }
            else if(child instanceof ConditionalNode){
                QuestionList questionListOfChild = (QuestionList) child.accept(this);
                for(Question question : questionListOfChild.getList()){
                    question.addDependency(expr);
                    questionList.add(question);
                }
            }
        }
        return questionList;
    }

    @Override
    public IKLQItem visit(QuestionNode node) {
        IdentifierValue id = new IdentifierValue(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        return new Question(id, type, null, text);
    }

    @Override
    public IKLQItem visit(ComputedQuestionNode node) {
        IdentifierValue id = new IdentifierValue(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        OptionSet options = new OptionSet();
        for(AExpression child : node.getChildren()){
            options.add(child.evaluate(null)); //TODO temp fix, need to change when computed questions can take expressions
        }
        return new Question(id, type, options, text);
    }

    @Override
    public IKLQItem visit(ANode node) {
        return visit(node);
    }

    @Override
    public IKLQItem visit(StringNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(NumberNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(DateNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(IdentifierNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(MultiplyNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(DivideNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(AddNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(SubtractNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(GreaterThanNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(GreaterEqualsNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(LessThanNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(LessEqualsNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(EqualsNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(NotEqualsNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(AndNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(OrNode node) {
        return null;
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
