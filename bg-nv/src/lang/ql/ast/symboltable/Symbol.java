package lang.ql.ast.symboltable;

import lang.ql.ast.statement.QuestionType;

/**
 * Created by bore on 13/02/15.
 */
public abstract class Symbol
{
    private String name;
    private QuestionType type;

    public Symbol(String name, QuestionType type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return  this.name;
    }

    public QuestionType getType()
    {
        return this.type;
    }
}
