package ql.gui.segment;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import ql.ast.expression.Expr;
import ql.gui.ModelVisitor;
import ql.gui.Refreshable;
import ql.semantics.ExprEvaluator;
import ql.semantics.ValueTable;
import ql.semantics.values.BoolValue;
import ql.semantics.values.Value;

import java.util.List;

/**
 * Created by Nik on 3-3-15.
 */
public class Conditional extends Segment<Pane> implements Refreshable
{
    private final Expr condition;

    public Conditional(Expr condition, List<Segment> subsegments)
    {
        this(condition, subsegments, new RowStyle());
    }

    public Conditional(Expr condition, List<Segment> subsegments, RowStyle style)
    {
        super(new HBox(), subsegments, true);

        for (Segment s : subsegments)
        {
            this.container.getChildren().add(s.getContainer());
        }

        this.condition = condition;
        this.setStyle(style);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
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

    @Override
    public Boolean isRefreshPrerequisite()
    {
        return false;
    }

    private void setStyle(RowStyle style)
    {
        //TODO
    }
}