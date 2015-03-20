package ql.gui;

import ql.ast.expression.Expr;
import ql.ast.statement.*;
import ql.gui.canvas.Canvas;
import ql.gui.input.ExprInputBuilder;
import ql.gui.input.Input;
import ql.gui.input.InputBuilder;
import ql.gui.label.Label;
import ql.gui.segment.Row;
import ql.gui.segment.Page;
import ql.gui.segment.Segment;
import ql.semantics.CondQuestionTable;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nik on 17-2-15.
 */
public class SimpleModeler extends Modeler
{
    public SimpleModeler(CondQuestionTable condQuestionTable)
    {
        super(condQuestionTable);
    }

    @Override
    public Canvas model()
    {
        List<Segment> segments = new ArrayList<>();
        for (Question q : this.getCondQuestionTable())
        {
            Segment segment = q.accept(this);
            segments.add(segment);
        }
        List<Segment> pages = new ArrayList<>();
        pages.add(new Page(segments, true));

        return new Canvas("Questionnaire", pages);
    }

    @Override
    public Row visit(Question q)
    {
        Expr expr = this.getCondition(q.getId());
        Label label = new Label(q.getLabel());
        Input input = InputBuilder.build(q.getId(), q.getType());
        return new Row(expr, q.getType(), label, input);
    }

    @Override
    public Row visit(CalculatedQuestion cq)
    {
        Expr expr = this.getCondition(cq.getId());
        Label label = new Label(cq.getLabel());
        Input input = ExprInputBuilder.build(cq.getId(), cq.getCalculation(), cq.getType());
        return new Row(expr, cq.getType(), label, input);
    }

    @Override
    public Row visit(IfCondition ifCond)
    {
        return null;
    }


}
