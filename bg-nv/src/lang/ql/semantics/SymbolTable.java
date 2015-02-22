package lang.ql.semantics;

import lang.ql.ast.statement.Question;
import lang.ql.ast.types.Type;
import lang.ql.semantics.errors.Error;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolTable
{
    private Map<String, Type> symbols;
    private QuestErrInfo questErrInfo;

    public SymbolTable()
    {
        this.symbols = new HashMap<String, Type>();
        this.questErrInfo = new QuestErrInfo();
    }

    public QuestErrInfo getQuestErrInfo()
    {
        return this.questErrInfo;
    }

    public void define(Question q, Type type)
    {
        String id = q.getId();
        if (this.symbols.containsKey(id))
        {
            Type duplicateType = this.symbols.get(id);
            Question duplicateQ = this.questErrInfo.getQuestionsById(id).get(0);
            Error error = Error.identifierAlreadyDeclared(id, duplicateQ.getLineNumber(), q.getLineNumber());

            if (!(type.equals(duplicateType)))
            {
                error = Error.identifierDeclaredOfDiffType(id, duplicateQ.getLineNumber(), q.getLineNumber());
            }

            this.questErrInfo.addMessage(error);
        }

        this.symbols.put(id, type);
        this.questErrInfo.addQuestion(q);
    }

    public Type resolve(String name)
    {
        return this.symbols.get(name);
    }
}
