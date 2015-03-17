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
        Type type = node.getType();
        if (type == Type.BOOLEAN){
            return new BooleanRenderedQuestion(node, new ArrayList<>(), store);
        } else if (type == Type.DATE){
            return new DateRenderedQuestion(node, new ArrayList<>(), store);
        } else if (type == Type.STRING || type == Type.NUMERAL) {
            return new TextRenderedQuestion(node, new ArrayList<>(), store);
        }
        throw new IllegalArgumentException("Unknown type.");
    }

    @Override
    public IKLQItem visit(ComputedQuestionNode node) {
        return new ComputedRenderedQuestion(node, new ArrayList<>(), store);
    }
}
