package ql.gui;

import ql.ast.expression.BoolExpr;
import ql.ast.statement.*;
import ql.ast.type.Type;
import ql.gui.canvas.Canvas;
import ql.gui.input.ExprInputBuilder;
import ql.gui.input.Input;
import ql.gui.input.InputBuilder;
import ql.gui.label.Label;
import ql.gui.segment.Row;
import ql.gui.segment.Page;
import ql.gui.segment.RowStyle;
import ql.gui.segment.Segment;
import ql.semantics.ConditionalQuestion;
import ql.semantics.Flat;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nik on 17-2-15.
 */
public class SimpleModeler extends Modeler
{
    public SimpleModeler(Flat flat)
    {
        super(flat);
    }

    @Override
    public Canvas model()
    {
        List<Segment> segments = new ArrayList<>();
        for (ConditionalQuestion q : this.getFlat())
        {
            Segment segment = q.getQuestion().accept(this);
            segments.add(segment);
        }
        List<Segment> pages = new ArrayList<>();
        pages.add(new Page(segments, true));

        return new Canvas("Questionnaire", pages);
    }

    @Override
    public Row visit(Question q)
    {
        Label label = new Label(q.getLabel());
        Input input = InputBuilder.build(q.getId(), q.getType());
        //TODO: shorten this monster
        return new Row(this.getFlat().getConditionalQuestion(q.getId()).getCondition(), q.getType(), label, input);
    }

    @Override
    public Row visit(CalculatedQuestion cq)
    {
        Label label = new Label(cq.getLabel());
        Input input = ExprInputBuilder.build(cq.getId(), cq.getCalculation(), cq.getType());
        return new Row(this.getFlat().getConditionalQuestion(cq.getId()).getCondition(), cq.getType(), label, input);
    }

    @Override
    public Row visit(IfCondition ifCond)
    {
        return null;
    }


}
