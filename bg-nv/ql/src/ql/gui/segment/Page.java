package ql.gui.segment;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * Created by bore on 09/03/15.
 */
public class Page extends Segment<GridPane>
{
    public Page(List<Segment> subsegments, Boolean visible)
    {
        super(new GridPane(), subsegments, visible);

        this.container.setAlignment(Pos.CENTER);
        this.container.setHgap(10);
        this.container.setVgap(10);
        this.container.setStyle("-fx-background-color: white;");

        for (Segment s : subsegments)
        {
            this.container.add(s.getContainer(), 0, this.container.getChildren().size() + 1);
        }
    }

    @Override
    public <V> V accept(SegmentVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
