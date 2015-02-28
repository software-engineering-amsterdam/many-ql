package nl.uva.softwcons.ast.form;


public interface FormVisitor<T> {
    public T visitForm(Form form);
}
