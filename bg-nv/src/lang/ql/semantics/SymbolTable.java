package lang.ql.semantics;

import lang.ql.ast.statement.Question;
import lang.ql.ast.type.Type;
import lang.ql.ast.type.UndefinedType;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolTable
{
    private Map<String, Question> symbols;

    public SymbolTable()
    {
        this.symbols = new HashMap<>();
    }

    public void define(Question q)
    {
        this.symbols.put(q.getId(), q);
    }

    public Type resolve(String name)
    {
        Question q = this.symbols.get(name);
        if (q != null)
        {
            return q.getType();
        }
        return new UndefinedType();
    }

    public boolean containsQuestionId(String id)
    {
        return this.symbols.containsKey(id);
    }

    public Question getQuestion(String id)
    {
        return this.symbols.get(id);
    }
}
