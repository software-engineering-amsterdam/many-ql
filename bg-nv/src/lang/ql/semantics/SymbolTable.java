package lang.ql.semantics;

import lang.ql.ast.statement.Question;
import lang.ql.ast.statement.QuestionType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolTable
{
    private Map<Question, QuestionType> questionToType;
    private Map<String, Question> stringToQuestion;

    public SymbolTable()
    {
        this.questionToType = new HashMap<Question, QuestionType>();
        this.stringToQuestion = new HashMap<String, Question>();
    }

    public void define(Question question, QuestionType type)
    {
        this.questionToType.put(question, type);
        this.stringToQuestion.put(question.getId(), question);
    }

    public QuestionType resolve(String name)
    {
        Question q = this.getQuestionByName(name);

        if (!(this.questionToType.containsKey(q)))
        {
            throw new IllegalStateException("Not found in symbol table");
        }

        return this.questionToType.get(q);
    }

    public Question getQuestionByName(String name)
    {
        if (!(this.stringToQuestion.containsKey(name)))
        {
            throw new IllegalStateException("Not found in symbol table");
        }

        return this.stringToQuestion.get(name);
    }
}
