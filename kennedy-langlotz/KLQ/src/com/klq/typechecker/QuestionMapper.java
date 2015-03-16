package com.klq.typechecker;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.stmt.*;
import com.klq.typechecker.error.AError;

import java.util.List;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class QuestionMapper implements IStatementVisitor<Void> {
    private QuestionTable table;

    public QuestionMapper(List<AError> errors) {
        this.table = new QuestionTable(errors);
    }

    public QuestionTable getTable() {
        return table;
    }

    @Override
    public Void visit(QuestionnaireNode node) {
        for(AStatementNode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(QuestionNode node) {
        table.add(node.getID(), node);
        return null;
    }

    @Override
    public Void visit(ComputedQuestionNode node) {
        table.add(node.getID(), node);
        return null;
    }

    @Override
    public Void visit(ConditionalNode node) {
        for(AStatementNode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }
}