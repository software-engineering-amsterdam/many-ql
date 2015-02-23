package lang.ql.gui;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;
import lang.ql.gui.GuiElement;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.Visitor;
import lang.ql.semantics.values.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nik on 17-2-15.
 */
public class Modeler implements Visitor<GuiElement>, TypeVisitor<GuiElement>
{
    private ValueTable values;

    private Canvas canvas;
    private List<Line> lines;

    private Value currentValue;
    private Input currentInput;

    public Canvas getCanvas()
    {
        return this.canvas;
    }

    public Modeler(ValueTable values)
    {
        this.values = values;
    }

    @Override
    public GuiElement visit(Form form)
    {
        this.lines = new ArrayList<Line>();
        for (Statement s : form.getBody())
        {
            s.accept(this);
        }

        return new Canvas(form.getId(), this.lines);
    }

    @Override
    public GuiElement visit(Question q)
    {
        this.currentValue = values.getValue(q.getId());

        Label label = new Label(q.getLabel());
        q.getType().accept(this);

        this.lines.add(new Line(label, this.currentInput));

        this.currentInput = null;
        this.currentValue = null;

        return null;
    }

    @Override
    public GuiElement visit(CalculatedQuestion cq)
    {
        this.currentValue = values.getValue(cq.getId());

        Label label = new Label(cq.getLabel());
        cq.getType().accept(this);

        this.lines.add(new Line(label, this.currentInput));

        this.currentValue = null;
        this.currentInput = null;

        return null;
    }

    @Override
    public GuiElement visit(BoolType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new BoolInput((BooleanValue)this.currentValue);

        return null;
    }

    @Override
    public GuiElement visit(DateType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new DateInput((DateValue)this.currentValue);

        return null;
    }

    @Override
    public GuiElement visit(DecType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new DecInput((DecimalValue)this.currentValue);

        return null;
    }

    @Override
    public GuiElement visit(IntType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new IntInput((IntegerValue)this.currentValue);

        return null;
    }

    @Override
    public GuiElement visit(StrType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new StrInput((StringValue)this.currentValue);

        return null;
    }

    @Override
    public GuiElement visit(UndefinedType type)
    {
        // TODO: remove the cast somehow
        //this.currentInput = new StrInput((StringValue)this.currentValue);

        return null;
    }

    @Override
    public GuiElement visit(IfCondition ifCond)
    {
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
