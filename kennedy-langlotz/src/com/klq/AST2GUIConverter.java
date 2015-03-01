package com.klq;

import com.klq.ast.IVisitor;
import com.klq.ast.ANode;
import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.logic.IKLQItem;
import com.klq.logic.controller.Store;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.operator.bool.*;
import com.klq.logic.expression.operator.math.Addition;
import com.klq.logic.expression.operator.math.Division;
import com.klq.logic.expression.operator.math.Multiplication;
import com.klq.logic.expression.operator.math.Subtraction;
import com.klq.logic.expression.terminal.*;
import com.klq.logic.expression.terminal.Number;
import com.klq.logic.question.*;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 17-2-15.
 */
public class AST2GUIConverter implements IVisitor<IKLQItem> {
    List<Question> questList = new ArrayList<Question>();
    OptionSet currentAnswers = new OptionSet();

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
        AExpression expr = (AExpression) node.getCondition().accept(this);
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
        Id id = new Id(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        return new Question(id, type, null, text);
    }

    @Override
    public IKLQItem visit(ComputedQuestionNode node) {
        Id id = new Id(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        OptionSet options = new OptionSet();

        for(ANode child : node.getChildren()){
            options.add((AExpression) child.accept(this));
        }
        return new Question(id, type, options, text);
    }

    @Override
    public IKLQItem visit(ANode node) {
        return visit(node);
    }

    /*==================================================================================================================
    Expressions - Mathematical
     ==================================================================================================================*/
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

    /*==================================================================================================================
    Expressions - Boolean
     ==================================================================================================================*/
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
        return new Identifier(node.getIdentifier());
    }
    /*==================================================================================================================
            Primitives
     ==================================================================================================================*/
    @Override
    public IKLQItem visit(StringNode node) {
        return new com.klq.logic.expression.terminal.String(node.getString());
    }

    @Override
    public IKLQItem visit(NumberNode node) {
        return new Number(String.valueOf(node.getNumber()));
    }

    @Override
    public IKLQItem visit(DateNode node) {
        return new Date(node.getDate().toString());
    }
}
