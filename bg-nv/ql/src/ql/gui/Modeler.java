package ql.gui;

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

    public CondQuestionTable getCondQuestionTable()
    {
        return condQuestionTable;
    }

    // TODO: getCanvas() ?
    public abstract Canvas model();
}
