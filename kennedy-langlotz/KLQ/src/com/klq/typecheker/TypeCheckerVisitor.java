package com.klq.typecheker;

import com.klq.ast.ANode;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.IStatementVisitor;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.ComputedQuestionNode;
import com.klq.ast.impl.ConditionalNode;
import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.QuestionnaireNode;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.logic.question.Type;
import com.klq.typecheker.error.*;

import java.util.ArrayList;

/**
 * Created by juriaan on 2-3-15.
 */
public class TypeCheckerVisitor implements IExpressionVisitor<Type>, IStatementVisitor<Void> {
    private ArrayList<AError> errors;
    private QuestionTable table;

    public TypeCheckerVisitor(ArrayList<AError> errors, QuestionTable table) {
        this.errors = errors;
        this.table = table;
    }

    /*==================================================================================================================
        Statements
    ==================================================================================================================*/
    @Override
    public Void visit(QuestionnaireNode node) {
        for(ANode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(QuestionNode node) {
        return null;
    }

    @Override
    public Void visit(ComputedQuestionNode node) {
        if(node.getQuestionType() == Type.SET) {
            for (ANode child : node.getChildren()) {
                child.accept(this);
            }
        }
        else{
            Type childType = (Type) node.getChildren().get(0).accept(this);
            if(childType != node.getQuestionType()){
                errors.add(new TypeMismatch(node, childType));
            }
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
        return visitBinaryNode(node, "*");
    }

    @Override
    public Type visit(DivideNode node) {
        return visitBinaryNode(node, "/");
    }

    @Override
    public Type visit(AddNode node) {
        return visitBinaryNode(node, "+");
    }

    @Override
    public Type visit(SubtractNode node) {
        return visitBinaryNode(node, "-");
    }

    /*==================================================================================================================
    Expressions - Boolean
    ==================================================================================================================*/
    @Override
    public Type visit(GreaterThanNode node) {
        return visitBinaryNode(node, ">");
    }

    @Override
    public Type visit(GreaterEqualsNode node) {
        return visitBinaryNode(node, ">=");
    }

    @Override
    public Type visit(LessThanNode node) {
        return visitBinaryNode(node, "<");
    }

    @Override
    public Type visit(LessEqualsNode node) {
        return visitBinaryNode(node, "<=");
    }

    @Override
    public Type visit(EqualsNode node) {
        return visitBinaryNode(node, "==");
    }

    @Override
    public Type visit(NotEqualsNode node) {
        return visitBinaryNode(node, "!=");
    }

    @Override
    public Type visit(AndNode node) {
        return visitBinaryNode(node, "&&");
    }

    @Override
    public Type visit(OrNode node) {
        return visitBinaryNode(node, "||");
    }

    private Type visitBinaryNode(ABinaryExprNode node, String operator){
        Type leftChild = (Type) node.getLeftChild().accept(this);
        Type rightChild = (Type) node.getRightChild().accept(this);

        if(leftChild != rightChild){
            errors.add(new Incomparable(node, operator, leftChild, rightChild));
        }

        return leftChild;
    }
}
