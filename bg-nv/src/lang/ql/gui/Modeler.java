package lang.ql.gui;

import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;

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
        List<Line> lines = new ArrayList<Line>();
        for (Statement s : form.getBody())
        {
            lines.add((Line) s.accept(this));
        }

        return new Canvas(form.getId(), lines);
    }

    @Override
    public GuiElement visit(Question q)
    {
        Label label = new Label(q.getLabel());
        Input input = InputBuilder.build(q.getId(), q.getType());
        return new Line(label, input);
    }

    @Override
    public GuiElement visit(CalculatedQuestion cq)
    {
        Label label = new Label(cq.getLabel());
        Input input = ExprInputBuilder.build(cq.getId(), cq.getCalculation(), cq.getType());
        return new Line(label, input);
    }

    @Override
    public GuiElement visit(IfCondition ifCond)
    {
        // TODO: figure out what to do with this - modify the gui model?
        for (Statement s : ifCond.getBody())
        {
            s.accept(this);
        }

        return null;
    }
}
