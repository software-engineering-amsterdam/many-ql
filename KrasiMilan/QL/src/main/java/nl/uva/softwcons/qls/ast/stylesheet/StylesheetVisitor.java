package nl.uva.softwcons.qls.ast.stylesheet;


public interface StylesheetVisitor<T> {
    public T visit(Stylesheet stylesheet);
}
