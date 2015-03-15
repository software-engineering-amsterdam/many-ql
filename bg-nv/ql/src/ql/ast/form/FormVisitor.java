package ql.ast.form;

/**
 * Created by bore on 24/02/15.
 */
public interface FormVisitor<T>
{
    T visit(Form f);
}
