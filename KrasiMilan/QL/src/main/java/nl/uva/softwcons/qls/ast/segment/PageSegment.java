package nl.uva.softwcons.qls.ast.segment;

public abstract class PageSegment {

    public abstract <T> T visit(SegmentVisitor<T> visitor);

}
