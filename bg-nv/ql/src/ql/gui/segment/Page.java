package ql.gui.segment;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * Created by bore on 09/03/15.
 */
public class Page extends ParentSegment<GridPane>
{
    private String name;

    public Page(List<Segment> subSegments, String name, Boolean visible)
    {
        super(subSegments, new GridPane(), visible);
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
    public <V> V accept(SegmentVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
