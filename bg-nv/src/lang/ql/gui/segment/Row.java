package lang.ql.gui.segment;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.input.Input;
import lang.ql.gui.label.Label;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nik on 23-02-2015
 */
public class Row extends Segment<VBox>
{
    private Label label;
    private Input input;

    public Row(Label label, Input input)
    {
        this(label, input, true);
    }

    public Row(Label label, Input input, Boolean visible)
    {
        super(new VBox(), Collections.<Segment>emptyList(), visible);
        this.label = label;
        this.input = input;

        this.container.getChildren().add(this.label.getTextNode());
        this.container.getChildren().add(this.input.getInputNode());
        this.container.setFillWidth(true);
        this.container.setPrefWidth(400);
        this.container.setPadding(new Insets(0, 0, 15, 0));
    }

    public Label getLabel()
    {
        return label;
    }

    public Input getInput()
    {
        return input;
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}