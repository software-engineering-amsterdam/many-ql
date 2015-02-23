package lang.ql.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;
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
public class Modeler implements Visitor, TypeVisitor
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
    public void visit(Form form)
    {
        this.lines = new ArrayList<Line>();
        for (Statement s : form.getBody())
        {
            s.accept(this);
        }
        this.canvas = new Canvas(form.getId(), this.lines);
        this.lines = null;
    }

    @Override
    public void visit(Question q)
    {
        this.currentValue = values.getValue(q.getId());

        Label label = new Label(q.getLabel());
        q.getType().accept(this);

        this.lines.add(new Line(label, this.currentInput));

        this.currentInput = null;
        this.currentValue = null;
    }

    @Override
    public void visit(CalculatedQuestion cq)
    {
        this.currentValue = values.getValue(cq.getId());

        Label label = new Label(cq.getLabel());
        cq.getType().accept(this);

        this.lines.add(new Line(label, this.currentInput));

        this.currentValue = null;
        this.currentInput = null;
    }

    @Override
    public void visit(BoolType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new BoolInput((BooleanValue)this.currentValue);
    }

    @Override
    public void visit(DateType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new DateInput((DateValue)this.currentValue);
    }

    @Override
    public void visit(DecType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new DecInput((DecimalValue)this.currentValue);
    }

    @Override
    public void visit(IntType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new IntInput((IntegerValue)this.currentValue);
    }

    @Override
    public void visit(StrType type)
    {
        // TODO: remove the cast somehow
        this.currentInput = new StrInput((StringValue)this.currentValue);
    }

    @Override
    public void visit(IfCondition ifCond)
    {
        for (Statement s : ifCond.getBody())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(BoolExpr e)
    {

    }

    @Override
    public void visit(IntExpr e)
    {

    }

    @Override
    public void visit(DecExpr e)
    {

    }

    @Override
    public void visit(StrExpr e)
    {

    }

    @Override
    public void visit(Indent e)
    {

    }

    @Override
    public void visit(Neg e)
    {

    }

    @Override
    public void visit(lang.ql.ast.expression.Pos e)
    {

    }

    @Override
    public void visit(Not e)
    {

    }

    @Override
    public void visit(Add e)
    {

    }

    @Override
    public void visit(Sub e)
    {

    }

    @Override
    public void visit(Mul e)
    {

    }

    @Override
    public void visit(Div e)
    {

    }

    @Override
    public void visit(Gt e)
    {

    }

    @Override
    public void visit(Lt e)
    {

    }

    @Override
    public void visit(GtEqu e)
    {

    }

    @Override
    public void visit(LtEqu e)
    {

    }

    @Override
    public void visit(Equ e)
    {

    }

    @Override
    public void visit(NotEqu e)
    {

    }

    @Override
    public void visit(And e)
    {

    }

    @Override
    public void visit(Or e)
    {

    }
}
