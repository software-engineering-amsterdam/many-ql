package ql.gui;

import ql.ast.expression.Expr;
import ql.ast.statement.Question;
import ql.ast.statement.StatVisitor;
import ql.gui.canvas.Canvas;
import ql.gui.segment.Row;
import ql.semantics.CondQuestionTable;

/**
 * Created by Nik on 10-3-15.
 */
public abstract class Modeler implements StatVisitor<Row>
{
    private final CondQuestionTable condQuestionTable;

    public Modeler(CondQuestionTable condQuestionTable)
    {
        this.condQuestionTable = condQuestionTable;
    }

    protected CondQuestionTable getCondQuestionTable()
    {
        return this.condQuestionTable;
    }

    protected Expr getCondition(String questionId)
    {
        return this.condQuestionTable.getCondition(questionId);
    }

    protected Question getQuestion(String questionId)
    {
        return this.condQuestionTable.getQuestion(questionId);
    }

    // TODO: getCanvas() ?
    public abstract Canvas model();
}
