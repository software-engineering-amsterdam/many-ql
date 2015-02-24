package lang.ql.gui.line;

import lang.ql.gui.GuiElement;
import lang.ql.gui.GuiVisitor;
import lang.ql.gui.input.Input;
import lang.ql.gui.label.Label;

/**
 * Created by Nik on 23-02-2015
 */
public class Line extends GuiElement
{
    private Label label;
    private Input input;

    public Line(Label label, Input input)
    {
        super();
        this.label = label;
        this.input = input;
    }

    public Line(Label label, Input input, Boolean visible)
    {
        super(visible);
        this.label = label;
        this.input = input;
    }

    public <T> T accept(GuiVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    public Label getLabel()
    {
        return label;
    }

    public Input getInput()
    {
        return input;
    }
}
