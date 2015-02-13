package lang.ql.ast.symboltable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolTable implements Scope
{
    private Map<String, Symbol> symbols = new HashMap<String, Symbol>();

    public SymbolTable()
    {
//        define(new BuiltInTypeSymbol("int"));
//        define(new BuiltInTypeSymbol("float"));
    }

    //public String toString() { return getScopeName()+":"+symbols; }

    @Override
    public void define(Symbol symbol)
    {
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol resolve(String name)
    {
        return symbols.get(name);
    }
}
