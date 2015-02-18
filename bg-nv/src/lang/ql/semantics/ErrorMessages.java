package lang.ql.semantics;

import lang.ql.ast.statement.QuestionType;

/**
 * Created by bore on 17/02/15.
 */
public class ErrorMessages
{
    public static String identifierAlreadyDeclared(String id)
    {
        return String.format("Identifier \"%s\" is already declared", id);
    }

    public static String identifierDeclaredOfDiffType(String id)
    {
        return  String.format("Question \"%s\" is already declared with a different type.", id);
    }

    public static String identifierDefEvalMismatch(String id, QuestionType defined, QuestionType evaluated)
    {
        return String.format("Question \"%s\" is defined as type %s, but is calculated as type %s",
                id, defined, evaluated);
    }

    public static String typeMismatch(String id, QuestionType leftChildType, QuestionType rightChildType)
    {
        return String.format("Expression of type %s cannot children of different types: %s and %s",
                id, leftChildType, rightChildType);
    }

    public static String incorrectTypes(String id, QuestionType leftChildType)
    {
        return String.format("Expression of type %s cannot children of type: %s",
                id, leftChildType);
    }

    public static String ifConditionShouldBeBoolean()
    {
        return "If statements should have conditions of type boolean";
    }

    public static String undeclaredIdentifier(String id)
    {
        return String.format("Identifier \"%s\" is not declared", id);
    }
}
