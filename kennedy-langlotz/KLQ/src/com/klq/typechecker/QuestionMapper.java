package com.klq.typechecker;

import com.klq.ast.ANode;
import com.klq.ast.IStatementVisitor;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.stmt.*;
import com.klq.ast.impl.expr.literal.DateNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.literal.StringNode;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class QuestionMapper implements IStatementVisitor<Void> {
    private QuestionTable table;

    public QuestionMapper(QuestionTable table) {
        this.table = table;
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
        table.add(node.getQuestionID(), node);
        return null;
    }

    @Override
    public Void visit(ComputedQuestionNode node) {
        table.add(node.getQuestionID(), node);
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