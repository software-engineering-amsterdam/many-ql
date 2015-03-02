package com.klq.typecheker;

import com.klq.ast.ANode;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.IStatementVisitor;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.ComputedQuestionNode;
import com.klq.ast.impl.ConditionalNode;
import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.QuestionnaireNode;
import com.klq.ast.impl.expr.DateNode;
import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.ast.impl.expr.NumberNode;
import com.klq.ast.impl.expr.StringNode;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.logic.question.Type;
import com.klq.typecheker.error.AError;
import com.klq.typecheker.error.Incomparable;

import java.util.ArrayList;

/**
 * Created by juriaan on 2-3-15.
 */
public class TypeCheckerVisitorNew implements IExpressionVisitor<Type>, IStatementVisitor<Void> {
    private ArrayList<AError> errors;

    public TypeCheckerVisitorNew(ArrayList<AError> errors) {
        this.errors = errors;
    }

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
        for(ANode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalNode node) {
        node.getCondition().accept(this);
        for(ANode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

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
        return null;
    }

    @Override
    public Type visit(ANode node) {
        return null;
    }

    @Override
    public Type visit(MultiplyNode node) {
        Type leftChild = (Type) node.getLeftChild().accept(this);
        Type rightChild = (Type) node.getRightChild().accept(this);

        if(leftChild != rightChild){
            errors.add(new Incomparable(node, "*", leftChild, rightChild));
        }

        return leftChild;
    }

    @Override
    public Type visit(DivideNode node) {
        return null;
    }

    @Override
    public Type visit(AddNode node) {
        return null;
    }

    @Override
    public Type visit(SubtractNode node) {
        return null;
    }

    @Override
    public Type visit(GreaterThanNode node) {
        return null;
    }

    @Override
    public Type visit(GreaterEqualsNode node) {
        return null;
    }

    @Override
    public Type visit(LessThanNode node) {
        return null;
    }

    @Override
    public Type visit(LessEqualsNode node) {
        return null;
    }

    @Override
    public Type visit(EqualsNode node) {
        return null;
    }

    @Override
    public Type visit(NotEqualsNode node) {
        return null;
    }

    @Override
    public Type visit(AndNode node) {
        return null;
    }

    @Override
    public Type visit(OrNode node) {
        return null;
    }
}
