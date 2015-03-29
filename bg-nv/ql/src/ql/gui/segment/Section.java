package ql.gui.segment;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Created by Nik on 10-3-15.
 */
public class Section extends ParentSegment<TitledPane>
{
    private final String name;

    public Section(String name, List<Segment> subSegments)
    {
        super(subSegments, new TitledPane());
        this.name = name;

        VBox contentBox = new VBox();
        contentBox.setStyle("-fx-background-color: white; ");
        for (Segment s : subSegments)
        {
            contentBox.getChildren().add(s.getContainer());
        }

        this.container.setText(this.name);
        this.container.setCollapsible(false);
        this.container.setContent(contentBox);
    }

    @Override
    public <V> V accept(SegmentVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
