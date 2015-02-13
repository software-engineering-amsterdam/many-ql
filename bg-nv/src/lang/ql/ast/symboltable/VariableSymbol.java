package lang.ql.ast.symboltable;

import lang.ql.ast.statement.QuestionType;

/**
 * Created by bore on 13/02/15.
 */
public class VariableSymbol extends Symbol
{
    public VariableSymbol(String name, QuestionType type)
    {
        super(name, type);
    }
}
