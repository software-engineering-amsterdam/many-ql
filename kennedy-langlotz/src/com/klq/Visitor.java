package com.klq;

import com.klq.ast.IVisitor;
import com.klq.ast.ANode;
import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.bool.AndNode;
import com.klq.ast.impl.expr.bool.OrNode;
import com.klq.ast.impl.expr.comp.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.logic.IKLQItem;
import com.klq.logic.question.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 17-2-15.
 */
public class Visitor implements IVisitor<IKLQItem> {
    List<Question> questList = new ArrayList<Question>();
    OptionSet currentAnswers = new OptionSet();

    /*==================================================================================================================
    Statements
     ==================================================================================================================*/
    @Override
    public IKLQItem visit(QuestionnaireNode node) {
        return null;
    }

    @Override
    public IKLQItem visit(QuestionNode node) {
        Id id = new Id(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        Question question = new Question(type, null, text, null);
        questList.add(question);
        return null;
    }

    @Override
    public IKLQItem visit(ComputedQuestionNode node) {
        Id id = new Id(node.getQuestionID());
        Type type = node.getQuestionType();
        Text text = new Text(node.getText());

        Question question = new Question(type, currentAnswers, text, null);
        questList.add(question);
        currentAnswers = new OptionSet(); //reset the currentAnswers since the end of the question is reached
        return null;
    }

    @Override
    public IKLQItem visit(ANode node) {
        return null;
    }

    /*==================================================================================================================
    Expressions - Mathmetical
     ==================================================================================================================*/
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

    /*==================================================================================================================
    Expressions - Boolean
     ==================================================================================================================*/
    @Override
    public IKLQItem visit(ConditionalNode node) {
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

    @Override
    public IKLQItem visit(IdentifierNode node) {
        return null;
    }
    /*==================================================================================================================
            Primitives
     ==================================================================================================================*/
    @Override
    public IKLQItem visit(StringNode node) {
        currentAnswers.add(new Answer(node.getString()));
        return null;
    }

    @Override
    public IKLQItem visit(NumberNode node) {
        currentAnswers.add(new Answer(String.valueOf(node.getNumber())));
        return null;
    }

    @Override
    public IKLQItem visit(DateNode node) {
        currentAnswers.add(new Answer(String.valueOf(node.getDate())));
        return null;
    }

    public List<Question> getQuestList() {
        return questList;
    }
}
