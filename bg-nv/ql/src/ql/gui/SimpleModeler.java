package ql.gui;

import ql.ast.statement.*;
import ql.gui.canvas.Canvas;
import ql.gui.input.*;
import ql.gui.label.Label;
import ql.gui.segment.Conditional;
import ql.gui.segment.Page;
import ql.gui.segment.Row;
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
    @Override
    public Canvas model(Flat flat)
    {
        List<Segment> segments = new ArrayList<>();
        for (ConditionalQuestion q : flat)
        {
            segments.add(q.getQuestion().accept(this));
        }
        List<Segment> pages = new ArrayList<>();
        pages.add(new Page(segments, true));

        return new Canvas("Questionnaire", pages);
    }

    @Override
    public Segment visit(Question q)
    {
        Label label = new Label(q.getLabel());
        Input input = InputBuilder.build(q.getId(), q.getType());
        return new Row(label, input);
    }

    @Override
    public Segment visit(CalculatedQuestion cq)
    {
        Label label = new Label(cq.getLabel());
        Input input = ExprInputBuilder.build(cq.getId(), cq.getCalculation(), cq.getType());
        return new Row(label, input);
    }

    @Override
    public Segment visit(IfCondition ifCond)
    {
        List<Segment> segments = new ArrayList<Segment>();
        for (Statement s : ifCond.getBody())
        {
            segments.add(s.accept(this));
        }
        return new Conditional(ifCond.getCondition(), segments);
    }
}
