package nl.uva.softwcons.qls.ast.stylesheet;

public interface StylesheetVisitor<T> {
    T visit(Stylesheet stylesheet);
}
