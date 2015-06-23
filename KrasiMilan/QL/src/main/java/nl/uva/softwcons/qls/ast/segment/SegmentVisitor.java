package nl.uva.softwcons.qls.ast.segment;

public interface SegmentVisitor<T> {
    T visit(Page page);

    T visit(Question question);

    T visit(Section section);
}

