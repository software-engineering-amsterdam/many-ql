package nl.uva.softwcons.qls.ast.segment;

public abstract class PageSegment {

    public abstract <T> T accept(SegmentVisitor<T> visitor);

}
