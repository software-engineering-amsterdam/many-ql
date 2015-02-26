package nl.uva.softwcons.ast;

import nl.uva.softwcons.ast.form.Form;

public interface FormVisitor<T> {
    public T visitForm(Form form);
}
