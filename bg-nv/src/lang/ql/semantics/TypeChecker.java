package lang.ql.semantics;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.*;
import lang.ql.ast.statement.*;
import lang.ql.ast.SymbolTable;
import lang.ql.ast.visitor.VisitorAbstract;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class TypeChecker extends VisitorAbstract
{
    private SymbolTable symbolTable;

    public void visit(AstNode node, SymbolTable symbolTable)
    {
        this.symbolTable = symbolTable;
        this.visitInternal(node);
    }

    private void visitInternal(AstNode node)
    {
        if (node.getChildren() != null)
        {
            for (AstNode child : node.getChildren())
            {
                this.visitInternal(child);
            }
        }

        node.visit(this);
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        QuestionType defined = n.getQuestionType();
        QuestionType calculated = n.getExpression().getType();

        if (defined != calculated)
        {
            throw new IllegalArgumentException(String.format("%s is defined as %s, but it is assigned a %s.",
                    n.getClass().getSimpleName(), defined, calculated));
        }
    }

    @Override
    public void visit(IfCondition n)
    {
        if (n.getExpression().getType() != QuestionType.BOOLEAN)
        {
            throw new IllegalArgumentException("If statements should have conditions of type boolean");
        }
    }

    @Override
    public void visit(IntegerExpression n)
    {
        n.setType(QuestionType.INTEGER);
    }

    @Override
    public void visit(BooleanExpression n)
    {
        n.setType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(DecimalExpression n)
    {
        n.setType(QuestionType.DECIMAL);
    }

    @Override
    public void visit(StringExpression n)
    {
        n.setType(QuestionType.STRING);
    }

    @Override
    public void visit(AdditionExpression n)
    {
        this.checkBinaryOperators(n, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL, QuestionType.STRING));
        n.setType(n.getLeft().getType());
    }

    @Override
    public void visit(SubtractionExpression n)
    {
        this.checkBinaryOperators(n, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        n.setType(n.getLeft().getType());
    }

    @Override
    public void visit(GreaterThanExpression n)
    {
        this.checkBinaryOperators(n, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        n.setType(QuestionType.BOOLEAN);
    }

    @Override
    public void visit(UnaryMinusExpression n)
    {
        QuestionType operandType = n.getOperand().getType();
        this.checkAllowedTypes(n, operandType, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        n.setType(operandType);
    }

    @Override
    public void visit(UnaryPlusExpression n)
    {
        QuestionType operandType = n.getOperand().getType();
        this.checkAllowedTypes(n, operandType, Arrays.asList(QuestionType.INTEGER, QuestionType.DECIMAL));
        n.setType(operandType);
    }

    @Override
    public void visit(VariableExpression n)
    {
        QuestionType type = this.symbolTable.resolve(n.getId());
        if (type == null)
        {
            throw new IllegalArgumentException(String.format("Identifier \"%s\" is not defined.", n.getId()));
        }
        n.setType(type);
    }

    private void checkBinaryOperators(BinaryOperatorExpression n, List<QuestionType> allowedTypes)
    {
        QuestionType leftChildType = n.getLeft().getType();
        QuestionType rightChildType = n.getRight().getType();

        this.checkChildTypesConsistency(n, leftChildType, rightChildType);
        this.checkAllowedTypes(n, leftChildType, allowedTypes);
    }

    private void checkChildTypesConsistency(AstNode n, QuestionType leftChildType, QuestionType rightChildType)
    {
        if (leftChildType != rightChildType)
        {
            throw new IllegalArgumentException(String.format("%s has children of different types: %s and %s.",
                    n.getClass().getSimpleName(), leftChildType, rightChildType));
        }
    }

    private void checkAllowedTypes(Expression n, QuestionType childType, List<QuestionType> allowedTypes)
    {
        if (!allowedTypes.contains(childType))
        {
            throw new IllegalArgumentException(String.format("%s cannot have children of type %s",
                    n.getClass().getSimpleName(), childType));
        }
    }
}
