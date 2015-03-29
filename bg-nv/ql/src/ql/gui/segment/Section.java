package ql.gui.segment;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import ql.gui.ModelVisitor;

import java.util.List;

/**
 * Created by Nik on 10-3-15.
 */
public class Section extends Segment<Node>
{
    public Section(List<Segment> subSegments, Boolean visible)
    {
        super(new GridPane(), subSegments, visible);
    }

    @Override
    public <V> V accept(SegmentVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
