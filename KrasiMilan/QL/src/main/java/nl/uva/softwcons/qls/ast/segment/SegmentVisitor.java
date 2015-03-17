package nl.uva.softwcons.qls.ast.segment;

public interface SegmentVisitor<T> {
    public T visit(Page page);

    public T visit(Question question);

    public T visit(Section section);
}
