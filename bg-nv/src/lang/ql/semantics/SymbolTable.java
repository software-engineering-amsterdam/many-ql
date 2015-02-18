package lang.ql.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.statement.Question;
import lang.ql.ast.statement.QuestionType;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolTable
{
    private Map<String, QuestionType> symbols;
    private Set<RuntimeException> errors;
    private Set<Question> questions;

    public SymbolTable()
    {
        this.symbols = new HashMap<String, QuestionType>();
        this.errors = new HashSet<RuntimeException>();
        this.questions = new HashSet<Question>();
    }

    public void define(Question q, QuestionType type)
    {
        String id = q.getId();
        if (this.symbols.containsKey(id))
        {
            QuestionType duplicateType = this.symbols.get(id);
            IllegalStateException ex = new IllegalStateException(ErrorMessages.identifierAlreadyDeclared(id));

            if (!(type.equals(duplicateType)))
            {
                ex = new IllegalStateException(ErrorMessages.identifierDeclaredOfDiffType(id));
            }

            this.errors.add(ex);
        }

        this.symbols.put(id, type);
        this.questions.add(q);
    }

    public QuestionType resolve(String name)
    {
        assert this.symbols.containsKey(name);

        return this.symbols.get(name);
    }

    public List<Question> getQuestionsById(String id)
    {
        List<Question> result = new ArrayList<Question>();
        for (Question q : this.questions)
        {
            if (q.getId().equals(id))
            {
                result.add(q);
            }
        }
        return result;
    }
}
