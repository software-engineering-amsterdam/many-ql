package lang.ql.gui;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lang.ql.ast.form.Form;
import lang.ql.gui.canvas.Canvas;
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
public class SimpleGui<T extends Node> implements ModelVisitor<Node>
{
    private ValueTable valueTable;
    private final Refresher refresher;

    public static void run(Form ast, Stage stage)
    {
        Canvas canvas = (Canvas) ast.accept(new Modeler());

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
        Parent parent = (Parent) canvas.accept(this);
        stage.setTitle(canvas.getName());
        stage.setScene(new Scene(parent, 600, 700));
        stage.show();
    }

    @Override
    public Node visit(Canvas c)
    {
        for (Page page: c.getPages())
        {
            page.accept(this);
        }

        return c.getParent();
    }

    @Override
    public Node visit(Page page)
    {
        for (Segment subsegment : page.getSubsegments())
        {
            subsegment.accept(this);
        }
        return page.getContainer();
    }

    @Override
    public Node visit(Conditional segment)
    {
        this.refresher.addItem(segment);
        segment.refreshElement(this.valueTable);

        for (Segment subsegment : segment.getSubsegments())
        {
            subsegment.accept(this);
        }

        return segment.getContainer();
    }

    @Override
    public Node visit(Row row)
    {
        row.getLabel().accept(this);
        row.getInput().accept(this);
        return row.getContainer();
    }

    @Override
    public Node visit(BoolInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(DateInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(DecInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(IntInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(StrInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(BoolExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(DateExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(DecExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(IntExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(StrExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Node visit(Label label)
    {
        return label.getTextNode();
    }

    private Node handleInputVisit(RegularInput input)
    {
        input.addObserver(this.refresher);
        input.attachListener(this.valueTable);

        return input.getInputNode();
    }

    private Node handleInputVisit (ExprInput input)
    {
        this.refresher.addItem(input);

        input.evaluate(this.valueTable);
        input.refreshElement(this.valueTable);

        return input.getInputNode();
    }
}
