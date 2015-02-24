package lang.ql.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.Type;
import lang.ql.semantics.errors.*;
import lang.ql.semantics.errors.Error;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolVisitor implements FormVisitor<Void>, StatVisitor<Void>
{
    private SymbolTable symbolTable;
    private List<Message> errors;

    public static SymbolResult extract(Form f)
    {
        SymbolVisitor visitor = new SymbolVisitor();
        f.accept(visitor);

        return new SymbolResult(visitor.symbolTable, visitor.errors);
    }

    private SymbolVisitor()
    {
        this.symbolTable = new SymbolTable();
        this.errors = new ArrayList<Message>();
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
        this.symbolTable.define(q);

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.checkForError(q);
        this.symbolTable.define(q);

        return null;
    }

    private void checkForError(Question q)
    {
        String id = q.getId();
        if (this.symbolTable.containsQuestionId(id))
        {
            Type duplicateType = this.symbolTable.resolve(id);
            Question duplicateQuestion = this.symbolTable.getQuestion(id);
            int duplicateLineNumber = duplicateQuestion.getLineNumber();
            int currentLineNumber = q.getLineNumber();

            Error error = Error.identifierAlreadyDeclared(id, duplicateLineNumber, currentLineNumber);

            if (!(q.getType().equals(duplicateType)))
            {
                error = Error.identifierDeclaredOfDiffType(id, duplicateLineNumber, currentLineNumber);
            }

            this.errors.add(error);
        }
    }
}
