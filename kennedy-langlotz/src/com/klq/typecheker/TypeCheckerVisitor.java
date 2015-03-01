package com.klq.typecheker;

import com.klq.ast.ANode;
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
import com.klq.typecheker.error.AError;
import com.klq.typecheker.error.NotAValidCondition;

import java.util.ArrayList;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class TypeCheckerVisitor implements IVisitor<AError> {
    private ArrayList<AError> errors;

    public TypeCheckerVisitor(ArrayList<AError> errors) {
        this.errors = errors;
    }

    public ArrayList<AError> getErrors() {//TODO make a collection class that contains all the errors. This class extends AError so that we can pass it through here. First discuss with Vadim/Thijs
        return errors;
    }

    @Override
    public AError visit(QuestionnaireNode node) {
        for(ANode child : node.getChildren()){
            AError error = child.accept(this);
            if(error != null) errors.add(error);
        }
        return null;
    }

    @Override
    public AError visit(QuestionNode node) {
        return null;
    }

    @Override
    public AError visit(ComputedQuestionNode node) {
        return null;
    }

    @Override
    public AError visit(StringNode node) {
        return null;
    }

    @Override
    public AError visit(NumberNode node) {
        return null;
    }

    @Override
    public AError visit(DateNode node) {
        return null;
    }

    @Override
    public AError visit(ANode node) {
        return null;
    }

    @Override
    public AError visit(MultiplyNode node) {
        return null;
    }

    @Override
    public AError visit(DivideNode node) {
        return null;
    }

    @Override
    public AError visit(AddNode node) {
        return null;
    }

    @Override
    public AError visit(SubtractNode node) {
        return null;
    }

    @Override
    public AError visit(ConditionalNode node) {
        if(node.getCondition() instanceof ABooleanNode){
            for(ANode child : node.getChildren()){
                return child.accept(this);
            }
        }
        return new NotAValidCondition(node);
    }

    @Override
    public AError visit(GreaterThanNode node) {
        return null;
    }

    @Override
    public AError visit(GreaterEqualsNode node) {
        return null;
    }

    @Override
    public AError visit(LessThanNode node) {
        return null;
    }

    @Override
    public AError visit(LessEqualsNode node) {
        return null;
    }

    @Override
    public AError visit(EqualsNode node) {
        return null;
    }

    @Override
    public AError visit(NotEqualsNode node) {
        return null;
    }

    @Override
    public AError visit(AndNode node) {
        return null;
    }

    @Override
    public AError visit(OrNode node) {
        return null;
    }

    @Override
    public AError visit(IdentifierNode node) {
        return null;
    }
}
