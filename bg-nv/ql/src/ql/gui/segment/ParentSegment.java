package ql.gui.segment;

import javafx.scene.Node;

import java.util.List;

/**
 * Created by Nik on 29-3-15.
 */
public abstract class ParentSegment<T extends Node> extends Segment<T>
{
    private final List<Segment> subSegments;

    public ParentSegment(List<Segment> subSegments, T container)
    {
        super(container);
        assert subSegments != null;

        this.subSegments = subSegments;
    }

    public List<Segment> getSubSegments()
    {
        return this.subSegments;
    }
}
