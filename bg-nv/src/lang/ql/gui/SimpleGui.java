package lang.ql.gui;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lang.ql.ast.form.Form;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.control.CheckBox;
import lang.ql.gui.control.Radios;
import lang.ql.gui.control.TextField;
import lang.ql.gui.input.expression.*;
import lang.ql.gui.input.regular.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.segment.Conditional;
import lang.ql.gui.segment.Page;
import lang.ql.gui.segment.Row;
import lang.ql.gui.segment.Segment;
import lang.ql.semantics.*;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui<T extends Node> implements ModelVisitor<Void>
{
    private ValueTable valueTable;
    private final Refresher refresher;

    public static void run(Form ast, Modeler modeler, Stage stage)
    {
        Flat flat = Flattener.flatten(ast);
        Canvas canvas = modeler.model(flat);

        SimpleGui gui = new SimpleGui(ast);

        DataStore dataStore = new DataStore(ast);
        //TODO: user feedback
        canvas.setSubmitAction(e -> dataStore.store(gui.valueTable));
        gui.start(canvas, stage);
    }

    private SimpleGui(Form ast)
    {
        this.valueTable = Evaluator.evaluate(ast);
        this.refresher = new Refresher();
    }

    private void start(Canvas canvas, Stage stage)
    {
        Parent parent = canvas.getParent();
        stage.setTitle(canvas.getName());
        stage.setScene(new Scene(parent, 600, 700));
        stage.show();
    }

    @Override
    public Void visit(Canvas c)
    {
        for (Segment s : c.getSegments())
        {
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Page page)
    {
        for (Segment subsegment : page.getSubsegments())
        {
            subsegment.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Conditional segment)
    {
        this.refresher.addItem(segment);
        segment.refreshElement(this.valueTable);

        for (Segment subsegment : segment.getSubsegments())
        {
            subsegment.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Row row)
    {
        row.getLabel().accept(this);
        row.getInput().accept(this);
        return null;
    }

    @Override
    public Void visit(BoolInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(DateInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(DecInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(IntInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(StrInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(BoolExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(DateExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(DecExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(IntExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(StrExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(TextField control)
    {
        return null;
    }

    @Override
    public Void visit(CheckBox control)
    {
        return null;
    }

    @Override
    public Void visit(Radios control)
    {
        return null;
    }

    @Override
    public Void visit(Label label)
    {
        return null;
    }

    private Void handleInputVisit(RegularInput input)
    {
        input.addObserver(this.refresher);
        input.attachListener(this.valueTable);

        return null;
    }

    private Void handleInputVisit (ExprInput input)
    {
        this.refresher.addItem(input);

        input.evaluate(this.valueTable);
        input.refreshElement(this.valueTable);

        return null;
    }
}
