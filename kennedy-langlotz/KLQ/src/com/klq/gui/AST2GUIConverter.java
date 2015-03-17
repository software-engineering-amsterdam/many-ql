package com.klq.gui;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.stmt.*;
import com.klq.controller.Controller;
import com.klq.gui.control.*;

import java.util.ArrayList;

/**
 * Created by juriaan on 17-2-15.
 */
public class AST2GUIConverter implements IStatementVisitor<IKLQItem> {
    private Controller controller;

    /*==================================================================================================================
    Statements
     ==================================================================================================================*/
    @Override
    public IKLQItem visit(QuestionnaireNode node) {
        controller = new Controller();
        for(AStatementNode child : node.getChildren()){
            if(child instanceof QuestionNode) {
                ARenderedQuestion question = (ARenderedQuestion) child.accept(this);
                controller.add(question);
            }
            else if(child instanceof ConditionalNode){
                QuestionList questionList = (QuestionList) child.accept(this);
                for(ARenderedQuestion question : questionList.getList()){
                    controller.add(question);
                }
            }
        }
        return controller;
    }

    @Override
    public IKLQItem visit(ConditionalNode node) {
        AExpression expr = node.getCondition();
        QuestionList questionList = new QuestionList();

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
            return new BooleanRenderedQuestion(node, new ArrayList<>(), controller);
        } else if (type == Type.DATE){
            return new DateRenderedQuestion(node, new ArrayList<>(), controller);
        } else if (type == Type.STRING || type == Type.NUMERAL) {
            return new TextRenderedQuestion(node, new ArrayList<>(), controller);
        }
        throw new IllegalArgumentException("Unknown type.");
    }

    @Override
    public IKLQItem visit(ComputedQuestionNode node) {
        return new ComputedRenderedQuestion(node, new ArrayList<>(), controller);
    }
}
