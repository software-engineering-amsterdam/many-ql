package com.klq.typechecker;

import com.klq.ast.ANode;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.ComputedQuestionNode;
import com.klq.ast.impl.ConditionalNode;
import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.QuestionnaireNode;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.literal.DateNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.literal.StringNode;
import com.klq.ast.impl.expr.math.*;
import com.klq.logic.question.Type;
import com.common.typechecker.error.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 2-3-15.
 */
public class TypeCheckerVisitor implements IExpressionVisitor<Type>, IStatementVisitor<Void> {
    private ArrayList<AError> errors;
    private QuestionTable table;
    private CyclicDetector cyclicDetector;
    private String currentQuestion; //tracks for which question we are currently detecting the cycle

    private List<Type> allowedMathExprTypes;
    private List<Type> allowedBooleanExprTypes;
    private List<Type> allowedAndOrExprTypes;

    public TypeCheckerVisitor(ArrayList<AError> errors, QuestionTable table) {
        this.errors = errors;
        this.table = table;
        this.cyclicDetector = new CyclicDetector(); //TODO fill this and run it
        this.currentQuestion = null;

        allowedMathExprTypes = new ArrayList<Type>();
        allowedMathExprTypes.add(Type.NUMERAL);

        allowedBooleanExprTypes = new ArrayList<Type>();
        allowedBooleanExprTypes.add(Type.BOOLEAN);
        allowedBooleanExprTypes.add(Type.DATE);
        allowedBooleanExprTypes.add(Type.NUMERAL);
        allowedBooleanExprTypes.add(Type.STRING);

        allowedAndOrExprTypes = new ArrayList<Type>();
        allowedAndOrExprTypes.add(Type.BOOLEAN);
    }

    /*==================================================================================================================
        Statements
    ==================================================================================================================*/
    @Override
    public Void visit(QuestionnaireNode node) {
        for(ANode child : node.getChildren()){
            child.accept(this);
        }

        cyclicDetector.calculateFullDependencies();
        if(cyclicDetector.hasCycles()){
            for(String cyclicId : cyclicDetector.getCyclicIds()){
                errors.add(new CyclicDependency(table.get(cyclicId)));
            }
        }
        return null;
    }

    @Override
    public Void visit(QuestionNode node) {
        cyclicDetector.addKey(node.getQuestionID());
        return null;
    }

    @Override
    public Void visit(ComputedQuestionNode node) {
        cyclicDetector.addKey(node.getQuestionID());
        currentQuestion = node.getQuestionID();

        Type childType = (Type) node.getComputedAnswer().accept(this);
        if(childType != node.getQuestionType()){
            errors.add(new TypeMismatch(node, childType));
        }

        return null;
    }

    @Override
    public Void visit(ConditionalNode node) {
        if(node.getCondition() instanceof ABooleanNode) {
            node.getCondition().accept(this);
        }
        else{
            errors.add(new InvalidCondition(node));
        }

        for(ANode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

    /*==================================================================================================================
    Primitives
    ==================================================================================================================*/
    @Override
    public Type visit(StringNode node) {
        return Type.STRING;
    }

    @Override
    public Type visit(NumberNode node) {
        return Type.NUMERAL;
    }

    @Override
    public Type visit(DateNode node) {
        return Type.DATE;
    }

    @Override
    public Type visit(IdentifierNode node) {
        if(table.has(node.getIdentifier())){
            cyclicDetector.addDependency(currentQuestion, node.getIdentifier());
            return table.getQuestionType(node.getIdentifier());
        }
        else {
            errors.add(new QuestionIDReference(node));
            return null;
        }
    }

    @Override
    public Type visit(ANode node) {
        return null;
    }

    /*==================================================================================================================
    Expressions - Mathematical
    ==================================================================================================================*/
    @Override
    public Type visit(MultiplyNode node) {
        return visitBinaryNode(node, "*", allowedMathExprTypes);
    }

    @Override
    public Type visit(DivideNode node) {
        return visitBinaryNode(node, "/", allowedMathExprTypes);
    }

    @Override
    public Type visit(AddNode node) {
        return visitBinaryNode(node, "+", allowedMathExprTypes);
    }

    @Override
    public Type visit(SubtractNode node) {
        return visitBinaryNode(node, "-", allowedMathExprTypes);
    }

    /*==================================================================================================================
    Expressions - Boolean
    ==================================================================================================================*/
    @Override
    public Type visit(GreaterThanNode node) {
        return visitBinaryNode(node, ">", allowedBooleanExprTypes);
    }

    @Override
    public Type visit(GreaterEqualsNode node) {
        return visitBinaryNode(node, ">=", allowedBooleanExprTypes);
    }

    @Override
    public Type visit(LessThanNode node) {
        return visitBinaryNode(node, "<", allowedBooleanExprTypes);
    }

    @Override
    public Type visit(LessEqualsNode node) {
        return visitBinaryNode(node, "<=", allowedBooleanExprTypes);
    }

    @Override
    public Type visit(EqualsNode node) {
        return visitBinaryNode(node, "==", allowedBooleanExprTypes);
    }

    @Override
    public Type visit(NotEqualsNode node) {
        return visitBinaryNode(node, "!=", allowedBooleanExprTypes);
    }

    @Override
    public Type visit(AndNode node) {
        return visitBinaryNode(node, "&&", allowedAndOrExprTypes);
    }

    @Override
    public Type visit(OrNode node) {
        return visitBinaryNode(node, "||", allowedAndOrExprTypes);
    }

    private Type visitBinaryNode(ABinaryExprNode node, String operator, List<Type> allowedTypes){
        Type leftChild = (Type) node.getLeftChild().accept(this);
        Type rightChild = (Type) node.getRightChild().accept(this);

        if(!allowedTypes.contains(leftChild)){
            errors.add(new InvalidTypeForOperator(node.getLeftChild().getLocation(), leftChild, operator));
        }

        if(!allowedTypes.contains(rightChild)){
            errors.add(new InvalidTypeForOperator(node.getRightChild().getLocation(), rightChild, operator));
        }

        if(leftChild != rightChild){
            errors.add(new Incomparable(node, operator, leftChild, rightChild));
        }

        return leftChild;
    }

}
