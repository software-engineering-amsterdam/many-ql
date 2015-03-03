package lang.ql.gui.section;

import javafx.scene.Node;
import javafx.scene.Parent;
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
public class ConditionalSection extends Section<Pane> implements Refreshable
{
    private Expr condition;

    public ConditionalSection(Expr condition, List<Section> subsections)
    {
        super(new HBox(), subsections, true);
        this.condition = condition;
    }

    public Expr getCondition()
    {
        return this.condition;
    }

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void update(ValueTable valueTable)
    {
        Boolean visible = false;

        Value val = ExprEvaluator.evaluate(condition, valueTable);
        if (!val.isUndefined())
        {
            visible = ((BooleanValue)val).getValue();
        }
        this.setVisible(visible);
    }
}
