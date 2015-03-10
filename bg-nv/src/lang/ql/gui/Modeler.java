package lang.ql.gui;

import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.segment.Conditional;
import lang.ql.gui.segment.Page;
import lang.ql.gui.segment.Row;
import lang.ql.gui.segment.Segment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nik on 17-2-15.
 */
public class Modeler implements FormVisitor<GuiElement>, StatVisitor<GuiElement>
{
    @Override
    public Canvas visit(Form form)
    {
        List<Segment> segments = new ArrayList<Segment>();
        for (Statement s : form.getBody())
        {
            segments.add((Segment)s.accept(this));
        }

        //TODO: handle this properly for both QL/QLS
        List<Page> pages = new ArrayList<>();
        pages.add(new Page(segments, true));

        return new Canvas(form.getId(), pages);
    }

    @Override
    public GuiElement visit(Question q)
    {
        Label label = new Label(q.getLabel());
        Input input = InputBuilder.build(q.getId(), q.getType());
        return new Row(label, input);
    }

    @Override
    public GuiElement visit(CalculatedQuestion cq)
    {
        Label label = new Label(cq.getLabel());
        Input input = ExprInputBuilder.build(cq.getId(), cq.getCalculation(), cq.getType());
        return new Row(label, input);
    }

    @Override
    public GuiElement visit(IfCondition ifCond)
    {
        List<Segment> segments = new ArrayList<Segment>();
        for (Statement s : ifCond.getBody())
        {
            segments.add((Segment)s.accept(this));
        }
        return new Conditional(ifCond.getCondition(), segments);
    }
}
