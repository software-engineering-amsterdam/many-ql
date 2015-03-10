package lang.ql.gui.segment;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.Refreshable;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.Value;

import java.util.List;

/**
 * Created by Nik on 3-3-15.
 */
public class Conditional extends Segment<Pane> implements Refreshable
{
    private Expr condition;

    public Conditional(Expr condition, List<Segment> subsegments)
    {
        super(new HBox(), subsegments, true);

        for (Segment s : subsegments)
        {
            this.container.getChildren().add(s.getContainer());
        }

        this.condition = condition;
    }

    public Expr getCondition()
    {
        return this.condition;
    }

    @Override
    public <U> U accept(ModelVisitor<U> visitor)
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
            visible = ((BooleanValue)val).getValue();
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
}
