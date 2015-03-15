package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.ast.type.Type;
import ql.semantics.errors.*;
import ql.semantics.errors.Error;

/**
 * Created by bore on 13/02/15.
 */
public class QuestionCollector implements FormVisitor<Void>, StatVisitor<Void>
{
    private final QuestionMap questionMap;
    private final Messages messages;

    public static QuestionResult collect(Form f)
    {
        QuestionCollector visitor = new QuestionCollector();
        f.accept(visitor);

        return new QuestionResult(visitor.questionMap, visitor.messages);
    }

    private QuestionCollector()
    {
        this.questionMap = new QuestionMap();
        this.messages = new Messages();
    }

    @Override
    public Void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition condition)
    {
        for (Statement statement : condition.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.checkForError(q);
        this.questionMap.put(q);

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.checkForError(q);
        this.questionMap.put(q);

        return null;
    }

    private void checkForError(Question q)
    {
        String id = q.getId();
        if (this.questionMap.contains(id))
        {
            int currentLineNumber = q.getLineNumber();
            int duplicateLineNumber = this.questionMap.getLineNumber(id);

            Error error = Error.identifierAlreadyDeclared(id, duplicateLineNumber, currentLineNumber);

            Type duplicateType = this.questionMap.getType(id);
            if (this.isIdentTypeMismatchError(q.getType(), duplicateType))
            {
                error = Error.identifierDeclaredOfDiffType(id, duplicateLineNumber, currentLineNumber);
            }

            this.messages.add(error);
        }
    }

    private boolean isIdentTypeMismatchError(Type type, Type duplicateType)
    {
        return !(type.equals(duplicateType));
    }
}
