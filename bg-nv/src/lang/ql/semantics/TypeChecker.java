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
    private static String ifConditionBoolean = "If statements should have conditions of type boolean";
    private static String refToUndefQuestion = "Reference to undefined question";
    private static String duplQuestWithDiffTypes = "Duplicate questions with different types";
    private static String invalidTypeOperands = "Operands of invalid type";
    // TODO: add check that duplicate questions are of the same type
    // TODO: add warning for duplicate questions
    // TODO: solve the passing of question dependencies in a different manner

    private SymbolTable symbolTable;
    private Stack<QuestionType> typeStack;
    private Stack<Question> variablesStack;

    private Map<Question, Set<Question>> questionDependencies;
    private Errors errors;

    public TypeChecker(SymbolTable symbolTable)
    {
        this.symbolTable = symbolTable;
        this.typeStack = new Stack<QuestionType>();
        this.variablesStack = new Stack<Question>();
        this.questionDependencies = new HashMap<Question, Set<Question>>();
        this.errors = new Errors();
    }

    @Override
    public void visit(Form form)
    {
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
        condition.getExpression().accept(this);

        QuestionType type = this.popFromStack();
        if (type != QuestionType.BOOLEAN)
        {
            this.errors.logException(new IllegalArgumentException(ifConditionBoolean));
        }

        for (Statement statement : condition.getStatements())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Question q)
    {
        this.questionDependencies.put(q, Collections.<Question>emptySet());
    }

    @Override
    public void visit(CalculatedQuestion q)
    {
        q.getExpression().accept(this);

        QuestionType defined = q.getQuestionType();
        QuestionType calculated = this.popFromStack();

        if (defined != calculated)
        {
            this.errors.logException(new IllegalArgumentException(
                    String.format("Question \"%s\" is defined as %s, but it is assigned a value of type %s.",
                            q.getId(), defined, calculated)));
        }

        Set<Question> dep = new HashSet<Question>();
        for (int i = 0; i < this.variablesStack.size(); i++)
        {
            dep.add(this.variablesStack.pop());
        }

        this.questionDependencies.put(q, dep);
    }

    @Override
    public void visit(IntegerExpr n)
    {
        this.typeStack.push(QuestionType.INTEGER);
    }

    @Override
    public void visit(BooleanExpr n)
    {
        this.typeStack.push(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(DecimalExpr n)
    {
        this.typeStack.push(QuestionType.DECIMAL);
    }

    @Override
    public void visit(StringExpr n)
    {
        this.typeStack.push(QuestionType.STRING);
    }

    @Override
    public void visit(Add e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        QuestionType right = this.popFromStack();
        QuestionType left = this.popFromStack();

        this.checkChildTypesConsistency(e, left, right);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL, QuestionType.STRING));

        this.typeStack.push(left);
    }

    @Override
    public void visit(Sub e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        QuestionType right = this.popFromStack();
        QuestionType left = this.popFromStack();

        this.checkChildTypesConsistency(e, left, right);
        this.checkAllowedTypes(e, left, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));

        this.typeStack.push(left);
    }

    @Override
    public void visit(Gt e)
    {
//        this.checkBinaryOperators(e, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
//        e.setType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(Neg e)
    {
        e.getOperand().accept(this);

        QuestionType type = this.popFromStack();
        this.checkAllowedTypes(e, type, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.typeStack.push(type);
    }

    @Override
    public void visit(Pos e)
    {
        e.getOperand().accept(this);

        QuestionType type = this.popFromStack();
        this.checkAllowedTypes(e, type, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        this.typeStack.push(type);
    }

    @Override
    public void visit(Variable n)
    {
        QuestionType type = this.symbolTable.resolve(n.getId());
        if (type == null)
        {
            this.errors.logException(new IllegalArgumentException(
                    String.format("Identifier \"%s\" is not defined.", n.getId())));
        }

        Question q = this.symbolTable.getQuestionByName(n.getId());
        this.variablesStack.push(q);

        this.typeStack.push(type);
    }

    private void checkChildTypesConsistency(AstNode n, QuestionType leftChildType, QuestionType rightChildType)
    {
        if (leftChildType != rightChildType)
        {
            this.errors.logException(new IllegalArgumentException(
                    String.format("%s has children of different types: %s and %s.",
                            n.getClass().getSimpleName(), leftChildType, rightChildType)));
        }
    }

    private void checkAllowedTypes(Expression e, QuestionType childType, List<QuestionType> allowedTypes)
    {
        if (!allowedTypes.contains(childType))
        {
            this.errors.logException(new IllegalArgumentException(String.format("%s cannot have children of type %s",
                    e.getClass().getSimpleName(), childType)));
        }
    }

    private QuestionType popFromStack()
    {
        try
        {
            return this.typeStack.pop();
        } catch (EmptyStackException ex)
        {
            throw ex;
        }
    }

    public Map<Question, Set<Question>> getQuestionDependencies()
    {
        return questionDependencies;
    }
}
