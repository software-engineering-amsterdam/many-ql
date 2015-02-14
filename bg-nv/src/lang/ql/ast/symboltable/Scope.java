package lang.ql.ast.symboltable;

/**
 * Created by bore on 13/02/15.
 */
public interface Scope
{
    public void define(Symbol symbol);
    public Symbol resolve(String name);
}
