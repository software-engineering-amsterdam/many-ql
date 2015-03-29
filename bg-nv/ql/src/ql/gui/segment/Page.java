package ql.gui.segment;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import ql.gui.ModelVisitor;
import ql.gui.Refreshable;
import ql.semantics.ValueTable;
import ql.semantics.values.Value;

import java.util.List;

/**
 * Created by bore on 09/03/15.
 */
public class Page extends Segment<GridPane> implements Refreshable
{
    private String name;

    public Page(List<Segment> subSegments, String name, Boolean visible)
    {
        super(new GridPane(), subSegments, visible);
        this.name = name;

        this.container.setAlignment(Pos.CENTER);
        this.container.setHgap(10);
        this.container.setVgap(10);
        this.container.setStyle("-fx-background-color: white;");

        for (Segment s : subSegments)
        {
            this.container.add(s.getContainer(), 0, this.container.getChildren().size() + 1);
        }
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public void refreshElement(ValueTable valueTable)
    {
        //TODO
    }

    @Override
    public Value evaluate(ValueTable valueTable)
    {
        //TODO
        return null;
    }

    @Override
    public Boolean isRefreshPrerequisite()
    {
        return false;
    }

    @Override
    public <V> V accept(SegmentVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
