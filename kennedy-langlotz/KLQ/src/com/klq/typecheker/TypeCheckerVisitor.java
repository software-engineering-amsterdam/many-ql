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
import com.klq.logic.question.Type;
import com.klq.typecheker.error.AError;
import com.klq.typecheker.error.InvalidCondition;
import com.klq.typecheker.error.NotAnError;
import com.klq.typecheker.error.QuestionIDReference;

import java.util.ArrayList;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class TypeCheckerVisitor implements IVisitor<AError> {
    private ArrayList<AError> errors;
    private QuestionTable table;

    public TypeCheckerVisitor(ArrayList<AError> errors, QuestionTable table) {
        this.errors = errors;
        this.table = table;
    }

    public ArrayList<AError> getErrors() {//TODO make a collection class that contains all the errors. This class extends AError so that we can pass it through here. First discuss with Vadim/Thijs
        return errors;
    }
    /*==================================================================================================================
    Statements
    ==================================================================================================================*/
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

    //TODO refactor and test this crappy code
    @Override
    public AError visit(ComputedQuestionNode node) {
        //return node.getChild().accept(this);
        for(ANode child : node.getChildren()){
            AError childError = child.accept(this);

            if(childError != null){ //if there is an error in a child return that.
                return child.accept(this);
            }
            else if(node.getChildren().get(node.getChildren().size() - 1) == child){ //if we have reached the last child and it has no errors, return no errors found
                return null;
            }
        }
        return null;
    }

    //TODO refactor and test this crappy code
    @Override
    public AError visit(ConditionalNode node) {
        if(node.getCondition() instanceof ABooleanNode){
            AError condition = node.getCondition().accept(this);

            if(condition == null){ //if no error in the condition expression continue
                for(ANode child : node.getChildren()){
                    AError childError = child.accept(this);

                    if(childError != null){ //if there is an error in a child return that.
                        return child.accept(this);
                    }
                    else if(node.getChildren().get(node.getChildren().size() - 1) == child){ //if we have reached the last child and it has no errors, return no errors found
                        return null;
                    }
                }
            }else{
                return condition;
            }
        }
        return new InvalidCondition(node);
    }
    /*==================================================================================================================
    Primitives
    ==================================================================================================================*/
    @Override
    public AError visit(StringNode node) {
        //return new NotAnError(node, Type.STRING);
        return null;
    }

    @Override
    public AError visit(NumberNode node) {
        //return new NotAnError(node, Type.NUMERAL);
        return null;
    }

    @Override
    public AError visit(DateNode node) {
        //return new NotAnError(node, Type.DATE);
        return null;
    }

    @Override
    public AError visit(ANode node) {
        return null;
    }

    @Override
    public AError visit(IdentifierNode node) {
        if(table.has(node.getIdentifier())){
            //return new NotAnError(node, table.getQuestionType(node.getIdentifier()));
            return null;
        }
        return new QuestionIDReference(node);
    }

    /*==================================================================================================================
    Expressions - Mathematical
    ==================================================================================================================*/
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

    /*==================================================================================================================
    Expressions - Boolean
    ==================================================================================================================*/
    @Override
    public AError visit(GreaterThanNode node) {
        AError leftChild = node.getLeftChild().accept(this);
        AError rightChild = node.getRightChild().accept(this);

        if(leftChild == null && rightChild == null){
            return null;
        }
        else if(rightChild == null){
            return leftChild;
        }
        else{
            return rightChild;
        }
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
}
