package ql.gui.segment;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import ql.ast.expression.Expr;
import ql.gui.Refreshable;
import ql.gui.input.Input;
import ql.gui.label.Label;
import ql.semantics.ExprEvaluator;
import ql.semantics.ValueTable;
import ql.semantics.values.BoolValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public class Row extends Segment<Pane> implements Refreshable
{
    private final Expr condition;
    private final VBox inputBox;
    private final Label label;
    private final Input input;
    private Insets insets;

    public Row(Expr condition, Label label, Input input)
    {
        super(new HBox(), true);
        this.input = input;
        this.label = label;
        this.condition = condition;
        this.insets = new Insets(0, 0, 15, 0);

        this.inputBox = new VBox();
        this.initializeInputBox();

        this.container.getChildren().add(this.inputBox);
    }

    public void initializeInputBox()
    {
        this.inputBox.getChildren().add(this.label.getTextNode());
        this.inputBox.getChildren().add(this.input.getInputNode());
        this.inputBox.setFillWidth(true);
        this.inputBox.setPrefWidth(400);
        this.inputBox.setPadding(this.insets);

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
    public <V> V accept(SegmentVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        Boolean visible = false;

        Value val = ExprEvaluator.evaluate(condition, valueTable);
        if (!val.isUndefined())
        {
            visible = ((BoolValue)val).getValue();
        }
        this.setVisible(visible);
    }

    @Override
    public Value evaluate(ValueTable valueTable)
    {
        return ExprEvaluator.evaluate(condition, valueTable);
    }

    public void applyStyle(RowStyle style)
    {
        if (style.isWidgetSet())
        {
            this.input.switchControl(style.getWidget());
        }
        this.applyWidth(style.getWidth());
        this.applyFont(style.getFont());
        this.applyForeColor(style.getForeColor());
        this.applyBackColor(style.getBackColor());
    }

    private void applyWidth(Integer width)
    {
        this.inputBox.setPrefWidth(width.doubleValue());
    }

    private void applyForeColor(Paint color)
    {
        this.label.applyColor(color);
    }

    private void applyBackColor(Paint color)
    {
        this.inputBox.setBackground(new Background(new BackgroundFill(color, null, this.insets)));
    }

    private void applyFont(Font font)
    {
        this.label.applyFont(font);
    }
}
