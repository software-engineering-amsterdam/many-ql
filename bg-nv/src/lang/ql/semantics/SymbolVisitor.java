package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.Type;
import lang.ql.semantics.errors.*;
import lang.ql.semantics.errors.Error;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolVisitor implements Visitor
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
    public void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(IfCondition condition)
    {
        for (Statement statement : condition.getBody())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Question q)
    {
        this.checkForError(q);
        this.symbolTable.define(q);
    }

    @Override
    public void visit(CalculatedQuestion q)
    {
        this.checkForError(q);
        this.symbolTable.define(q);
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

    @Override
    public void visit(BoolExpr e)
    {

    }

    @Override
    public void visit(IntExpr e)
    {

    }

    @Override
    public void visit(DecExpr e)
    {

    }

    @Override
    public void visit(StrExpr e)
    {

    }

    @Override
    public void visit(Indent e)
    {

    }

    @Override
    public void visit(Neg e)
    {

    }

    @Override
    public void visit(Pos e)
    {

    }

    @Override
    public void visit(Not e)
    {

    }

    @Override
    public void visit(Add e)
    {

    }

    @Override
    public void visit(Sub e)
    {

    }

    @Override
    public void visit(Mul e)
    {

    }

    @Override
    public void visit(Div e)
    {

    }

    @Override
    public void visit(Gt e)
    {

    }

    @Override
    public void visit(Lt e)
    {

    }

    @Override
    public void visit(GtEqu e)
    {

    }

    @Override
    public void visit(LtEqu e)
    {

    }

    @Override
    public void visit(Equ e)
    {

    }

    @Override
    public void visit(NotEqu e)
    {

    }

    @Override
    public void visit(And e)
    {

    }

    @Override
    public void visit(Or e)
    {

    }
}
