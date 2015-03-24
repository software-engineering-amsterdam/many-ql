package nl.uva.softwcons.ql.ast.form;

public interface FormVisitor<T> {
    T visit(Form form);
}
