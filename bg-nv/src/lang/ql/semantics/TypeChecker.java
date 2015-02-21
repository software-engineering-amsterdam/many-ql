package lang.ql.semantics;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class TypeChecker extends VisitorAbstract
{

    // TODO: deal with warnings for the symbol table

    private SymbolTable symbolTable;
    private Stack<QuestionType> typeStack;
    private Question currentQuestion;
    private QuestionDependencies questionDependencies;
    private ErrorLogger errors;
    private SymbolVisitor symbolVisitor;
//=======
//    private static String ifConditionBoolean = "If statements should have conditions of type boolean";
//    private static String refToUndefQuestion = "Reference to undefined question";
//    private static String duplQuestWithDiffTypes = "Duplicate questions with different types";
//    private static String invalidTypeOperands = "Operands of invalid type";
//    // TODO: add check that duplicate questions are of the same type
//    // TODO: add warning for duplicate questions
//    // TODO: solve the passing of question dependencies in a different manner
//
//    private SymbolTable symbolTable;
//    private Stack<QuestionType> typeStack;
//    private Stack<Question> variablesStack;
//
//    private Map<Question, Set<Question>> questionDependencies;
//    private Errors errors;
//>>>>>>> ff3b8c94a3822a700a8059da000b6db4d959b030

    public TypeChecker()
    {
        this.typeStack = new Stack<QuestionType>();
        this.questionDependencies = new QuestionDependencies();
        this.errors = new ErrorLogger();
        this.symbolVisitor = new SymbolVisitor();
    }

    public SymbolTable table()
    {
        return this.symbolTable;
    }

    @Override
    public void visit(Form form)
    {
        symbolVisitor.visit(form);
        this.symbolTable = symbolVisitor.getSymbolTable();

        for (Statement statement : form.getStatements())
        {
            statement.accept(this);
        }

        if (!(this.errors.getExceptions().empty()))
        {
            throw this.errors.getExceptions().pop();
        }

        // TODO: Check for cyclic dependencies
        System.out.print("");
    }

    @Override
    public void visit(IfCondition condition)
    {
        condition.getExpr().accept(this);

        QuestionType type = this.popType();
        if (type != QuestionType.BOOLEAN)
        {
            IllegalStateException ex = new IllegalStateException(ErrorMessages.ifConditionShouldBeBoolean());
            this.errors.logException(ex);
        }

        for (Statement statement : condition.getStatements())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Question q)
    {
        this.questionDependencies.addDependency(q);
    }

    @Override
    public void visit(CalculatedQuestion q)
    {
        this.setScopeForExpr(q);

        q.getExpr().accept(this);

        QuestionType defined = q.getQuestionType();
        QuestionType calculated = this.popType();

        if (defined != calculated)
        {
            IllegalStateException ex = new IllegalStateException(
                    ErrorMessages.identifierDefEvalMismatch(q.getId(), defined, calculated));
            this.errors.logException(ex);
        }

        this.resetScopeForExpr();
    }

    @Override
    public void visit(Indent n)
    {
        QuestionType type = this.symbolTable.resolve(n.getId());
        if (type == null)
        {
            IllegalStateException e = new IllegalStateException(ErrorMessages.undeclaredIdentifier(n.getId()));
            this.errors.logException(e);
        }

        List<Question> qs = this.symbolTable.getQuestionsById(n.getId());

        for (Question q : qs)
        {
            this.questionDependencies.addDependency(this.currentQuestion, q);
        }

        this.pushType(type);
    }

    @Override
    public void visit(IntExpr n)
    {
        this.pushType(QuestionType.INTEGER);
    }

    @Override
    public void visit(BoolExpr n)
    {
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(DecExpr n)
    {
        this.pushType(QuestionType.DECIMAL);
    }

    @Override
    public void visit(StrExpr n)
    {
        this.pushType(QuestionType.STRING);
    }

    @Override
    public void visit(Add e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL, QuestionType.STRING));
        this.pushType(left);
    }

    @Override
    public void visit(Sub e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(left);
    }

    @Override
    public void visit(Mul e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(left);
    }

    @Override
    public void visit(Div e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(left);
    }

    @Override
    public void visit(Pos e)
    {
        e.getOperand().accept(this);

        QuestionType type = this.popType();
        this.checkAllowedTypes(e, type, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(type);
    }

    @Override
    public void visit(Neg e)
    {
        e.getOperand().accept(this);

        QuestionType type = this.popType();
        this.checkAllowedTypes(e, type, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(type);
    }

    @Override
    public void visit(Not e)
    {
        e.getOperand().accept(this);

        QuestionType type = this.popType();
        this.checkAllowedTypes(e, type, Arrays.asList(QuestionType.BOOLEAN));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(Gt e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(Lt e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(GtEqu e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(LtEqu e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(Equ e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.BOOLEAN, QuestionType.DECIMAL, QuestionType.INTEGER,
                QuestionType.STRING));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(NotEqu e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.BOOLEAN, QuestionType.DECIMAL, QuestionType.INTEGER,
                QuestionType.STRING));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(And e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.BOOLEAN));
        this.pushType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(Or e)
    {
        QuestionType left = this.getBinaryExprType(e);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.BOOLEAN));
        this.pushType(QuestionType.BOOLEAN);
    }

    private QuestionType getBinaryExprType(BinaryExpr e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        QuestionType right = this.popType();
        QuestionType left = this.popType();

        this.checkChildTypesConsistency(e, left, right);

        return left;
    }

    private void checkChildTypesConsistency(AstNode n, QuestionType leftChildType, QuestionType rightChildType)
    {
        if (leftChildType != rightChildType)
        {
            this.errors.logException(new IllegalArgumentException(ErrorMessages.typeMismatch(
                    n.getClass().getSimpleName(), leftChildType, rightChildType)));
        }
    }

    private void checkAllowedTypes(Expr e, QuestionType childType, List<QuestionType> allowedTypes)
    {
        if (!allowedTypes.contains(childType))
        {
            this.errors.logException(new IllegalArgumentException(ErrorMessages.incorrectTypes(
                    e.getClass().getSimpleName(), childType)));
        }
    }

    private void pushType(QuestionType type)
    {
        this.typeStack.push(type);
    }

    private QuestionType popType()
    {
        try
        {
            return this.typeStack.pop();
        } catch (EmptyStackException ex)
        {
            throw ex;
        }
    }

    private void setScopeForExpr(CalculatedQuestion q)
    {
        this.currentQuestion = q;
    }

    private void resetScopeForExpr()
    {
        this.currentQuestion = null;
    }
}
