package uva.sc.ql.ast;

import uva.sc.ql.form.Form;

public interface IQLFormNodeVisitor<T> {

    public T visit(Form questionnaire);
}
