package ql.gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ql.gui.canvas.Canvas;
import ql.gui.control.*;
import ql.gui.input.*;
import ql.gui.label.Label;
import ql.gui.segment.*;
import ql.semantics.*;

/**
 * Created by Nik on 23-2-15.
 */
public class Renderer implements ModelVisitor<Void>
{
    private final ValueTable valueTable;
    private final Refresher refresher;

    public static void display(ValueTable valueTable, Canvas canvas, Stage stage)
    {
        Renderer renderer = new Renderer(valueTable);
        canvas.accept(renderer);
        renderer.start(canvas, stage);
    }

    private Renderer(ValueTable valueTable)
    {
        this.valueTable = valueTable;
        this.refresher = new Refresher(this.valueTable);
    }

    private void start(Canvas canvas, Stage stage)
    {
        this.refresher.refresh();
        Parent parent = canvas.getGuiElement();
        stage.setTitle(canvas.getName());
        stage.setScene(new Scene(parent, 600, 700));
        stage.show();
    }

    @Override
    public Void visit(Canvas c)
    {
        for (Page s : c.getPages())
        {
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Page page)
    {
        for (Segment subSegment : page.getSubSegments())
        {
            subSegment.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Row segment)
    {
        this.refresher.addItem(segment);
        segment.getLabel().accept(this);
        segment.getInput().accept(this);

        return null;
    }

    @Override
    public Void visit(Section section)
    {
        for (Segment segment : section.getSubSegments())
        {
            segment.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BoolInput input)
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
    public Void visit(ExprInput input)
    {
        return handleInputVisit(input);
    }

    @Override
    public Void visit(Label label)
    {
        return null;
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
    public Void visit(Radio control)
    {
        return null;
    }

    @Override
    public Void visit(Slider control)
    {
        return null;
    }

    @Override
    public Void visit(Dropdown control)
    {
        return null;
    }

    private Void handleInputVisit(RegularInput input)
    {
        input.addObserver(this.refresher);
        return null;
    }

    private Void handleInputVisit(ExprInput input)
    {
        this.refresher.addItem(input);
        return null;
    }
}
