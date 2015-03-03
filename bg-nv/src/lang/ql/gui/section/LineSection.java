package lang.ql.gui.section;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.input.Input;
import lang.ql.gui.label.Label;

import java.util.Collections;

/**
 * Created by Nik on 23-02-2015
 */
public class LineSection extends Section<VBox>
{
    private Label label;
    private Input input;

    public LineSection(Label label, Input input)
    {
        this(label, input, true);
    }

    public LineSection(Label label, Input input, Boolean visible)
    {
        super(new VBox(), Collections.<Section>emptyList(), visible);
        this.label = label;
        this.input = input;
    }

    public Label getLabel()
    {
        return label;
    }

    public Input getInput()
    {
        return input;
    }

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}