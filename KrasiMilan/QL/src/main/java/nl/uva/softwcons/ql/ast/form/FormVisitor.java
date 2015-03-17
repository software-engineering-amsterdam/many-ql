package nl.uva.softwcons.ql.ast.form;

public interface FormVisitor<T> {
    public T visit(Form form);
}
