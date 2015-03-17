package qls.ast;

/**
 * Created by bore on 03/03/15.
 */
public interface StylesheetVisitor<T>
{
    T visit(Stylesheet s);
    T visit(Page p);
}
