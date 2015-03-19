package ql.semantics.errors;

import ql.util.StringHelper;

import java.util.Collection;

/**
 * Created by bore on 20/02/15.
 */
public class Error extends Message
{
    public Error(String message)
    {
        super(message);
    }

    @Override
    public boolean isError()
    {
        return true;
    }

    public static Error typeMismatch(String id, String leftChildType, String rightChildType, int line)
    {
        String m = String.format("QL Error (Line %d): expression of type %s cannot have children of different type: %s and %s",
                line, id, leftChildType, rightChildType);
        return new Error(m);
    }

    public static Error incorrectTypes(String id, String leftChildType, int line)
    {
        return new Error(String.format("QL Error (Line %d): expression of type %s cannot children of type %s",
                line, id, leftChildType));
    }

    public static Error ifConditionShouldBeBoolean(int line)
    {
        return new Error(String.format("QL Error (Line %d): if statements should have conditions of type boolean", line));
    }

    public static Error undeclaredIdentifier(String id, int line)
    {
        return new Error(String.format("QL Error (Line %d): identifier \"%s\" is not declared", line, id));
    }

    public static Error identifierDefEvalMismatch(String id, String defined, String evaluated, int line)
    {
        return new Error(String.format(
                "QL Error (Line %d): Question \"%s\" is defined as type %s, but is assigned expression of type %s",
                line, id, defined, evaluated));
    }

    public static Error identifierAlreadyDeclared(String id, Collection<String> lines)
    {
        String lineString = StringHelper.printStrValueList(lines);
        return new Error(String.format("QL Error : multiple declarations of identifier \"%s\" on lines: %s",
                id, lineString));
    }

    public static Error identifierDeclaredOfDiffType(String id, int line1, int line2)
    {
        return new Error(String.format(
                "QL Error (Line: %d): Question \"%s\" is declared twice with a different type on line %d and %d",
                line1, id, line1, line2));
    }

    public static Error cyclicQuestions(String idList)
    {
        return new Error(String.format("QL Error: the following questions form a cyclic dependency: %s", idList));
    }
}
