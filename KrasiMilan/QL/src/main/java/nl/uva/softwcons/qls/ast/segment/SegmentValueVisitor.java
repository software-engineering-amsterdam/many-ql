package nl.uva.softwcons.qls.ast.segment;

public interface SegmentValueVisitor<T, V> {
    T visit(Page page, V value);

    T visit(Question question, V value);

    T visit(Section section, V value);
}
