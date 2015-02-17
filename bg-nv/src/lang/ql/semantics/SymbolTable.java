package lang.ql.semantics;

import lang.ql.ast.statement.QuestionType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolTable
{
    private Map<String, QuestionType> symbols;

    public SymbolTable()
    {
        this.symbols = new HashMap<String, QuestionType>();
    }

    public void define(String name, QuestionType type)
    {
        symbols.put(name, type);
    }

    public QuestionType resolve(String name)
    {
        return symbols.get(name);
    }
}
