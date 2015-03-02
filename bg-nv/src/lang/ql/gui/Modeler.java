package lang.ql.gui;

import lang.ql.ast.expression.*;
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
public class Modeler implements FormVisitor<GuiElement>, StatVisitor<GuiElement>, ExprVisitor<GuiElement>
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

    @Override
    public GuiElement visit(BoolExpr e)
    {
        return null;
    }

    @Override
    public GuiElement visit(IntExpr e)
    {
        return null;
    }

    @Override
    public GuiElement visit(DecExpr e)
    {
        return null;
    }

    @Override
    public GuiElement visit(StrExpr e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Ident e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Neg e)
    {
        return null;
    }

    @Override
    public GuiElement visit(lang.ql.ast.expression.Pos e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Not e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Add e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Sub e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Mul e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Div e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Gt e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Lt e)
    {
        return null;
    }

    @Override
    public GuiElement visit(GtEqu e)
    {
        return null;
    }

    @Override
    public GuiElement visit(LtEqu e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Equ e)
    {
        return null;
    }

    @Override
    public GuiElement visit(NotEqu e)
    {
        return null;
    }

    @Override
    public GuiElement visit(And e)
    {
        return null;
    }

    @Override
    public GuiElement visit(Or e)
    {
        return null;
    }
}
