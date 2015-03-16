package com.klq.typechecker;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.stmt.*;
import com.klq.typechecker.error.AError;
import com.klq.typechecker.error.NotUniqueID;

import java.util.List;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class QuestionMapper implements IStatementVisitor<Void> {
    private QuestionTable table;
    private List<AError> errors;

    public QuestionMapper(List<AError> errors) {
        this.errors = errors;
        this.table = new QuestionTable();
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
        checkDuplicateId(node);
        return null;
    }

    @Override
    public Void visit(ComputedQuestionNode node) {
        checkDuplicateId(node);
        return null;
    }

    @Override
    public Void visit(ConditionalNode node) {
        for(AStatementNode child : node.getChildren()){
            child.accept(this);
        }
        return null;
    }

    private void checkDuplicateId(QuestionNode node){
        if(table.has(node.getID())){
            errors.add(new NotUniqueID(node.getID(), node.getLocation()));
        }
        else{
            table.add(node.getID(), node);
        }
    }
}