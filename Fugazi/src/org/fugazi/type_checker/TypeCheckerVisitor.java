package org.fugazi.type_checker;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.BOOL;
import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.expression.literal.INT;
import org.fugazi.ast.expression.literal.STRING;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Logical;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.*;
import org.fugazi.ast.expression.unary.Negative;
import org.fugazi.ast.expression.unary.Not;
import org.fugazi.ast.expression.unary.Positive;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.ast.statement.Statement;
import org.fugazi.ast.type.*;

/*
Operators with invalid types:
- Comparison cannot have string and both have to be of the same type.
- GE, Greater, LE, Less must be int
- and / or must have booleans

- negative must have int
necessary functions:
 - check if string
 - check if int
 - check if bool
 - check if of same type

 */

import java.util.List;

public class TypeCheckerVisitor implements IASTVisitor {

    private final ASTErrorHandler astErrorHandler;

    public TypeCheckerVisitor(){
        this.astErrorHandler = new ASTErrorHandler();
    }

    @Override
    public Object visitForm(Form form) {
        List<Statement> statementList = form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    private Object visitBinaryLogical(Logical logical) {
        // Both sides of the expressions need to be of type boolean.
        Expression left = logical.getLeft();
        Expression right = logical.getRight();

        boolean leftCorrect = this.checkIfBool(left);
        boolean rightCorrect = this.checkIfBool(right);

        if (!leftCorrect) {
            System.out.println("\n\nLeft not correct.");
            this.astErrorHandler.registerNewError( logical,
                    "Left side of that expression not of type bool."
            );
        }
        if (!rightCorrect) {
            System.out.println("\n\nRight not correct. ");
            this.astErrorHandler.registerNewError( logical,
                    "Left side of that expression not of type bool."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;

    }

    @Override
    public Object visitAnd(And and) {
        return this.visitBinaryLogical(and);
    }

    @Override
    public Object visitOr(Or or) {
        return this.visitBinaryLogical(or);
    }

    @Override
    public Object visitNot(Not not) {

        System.out.println("So I am visiting a not:" + not.toString());

        Expression expression = not.getExpr();

        boolean exprCorrect = this.checkIfBool(expression);

        if (!exprCorrect) {
            System.out.println("\n\nLeft not correct.");
            this.astErrorHandler.registerNewError(not,
                    "The expression not of type bool."
            );
        }

        expression.accept(this);
        return null;
    }

    @Override
    public Object visitNegative(Negative negative) {
        System.out.println("So I am visiting a negative:" + negative.toString());

        Expression expression = negative.getExpr();

        expression.accept(this);
        return null;
    }

    @Override
    public Object visitPositive(Positive positive) {
        System.out.println("So I am visiting a positive:" + positive.toString());

        Expression expression = positive.getExpr();

        expression.accept(this);
        return null;
    }


    private Object visitBinaryComparison(Comparison comparison) {
        // Both sides of the expressions need to be of type boolean.
        Expression left = comparison.getLeft();
        Expression right = comparison.getRight();

        boolean leftCorrect = this.checkIfInt(left);
        boolean rightCorrect = this.checkIfInt(right);

        if (!leftCorrect) {
            System.out.println("\n\nLeft not correct.");
            this.astErrorHandler.registerNewError( comparison,
                    "Left side of that comparison expression not of type int."
            );
        }
        if (!rightCorrect) {
            System.out.println("\n\nRight not correct. ");
            this.astErrorHandler.registerNewError( comparison,
                    "Left side of that comparison expression not of type int."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitEQ(EQ eq) {
        return this.visitBinaryComparison(eq);
    }

    @Override
    public Object visitGE(GE ge) {
        return this.visitBinaryComparison(ge);
    }

    @Override
    public Object visitGreater(Greater greater) {
        return this.visitBinaryComparison(greater);
    }

    @Override
    public Object visitLE(LE le) {
        return this.visitBinaryComparison(le);
    }

    @Override
    public Object visitLesser(Less less) {
        return this.visitBinaryComparison(less);
    }

    @Override
    public Object visitNotEq(NotEq notEq) {
        return this.visitBinaryComparison(notEq);
    }

    private Object visitBinaryNumerical(Numerical numerical) {
        // Both sides of the expressions need to be of type boolean.
        Expression left = numerical.getLeft();
        Expression right = numerical.getRight();

        boolean leftCorrect = this.checkIfInt(left);
        boolean rightCorrect = this.checkIfInt(right);

        if (!leftCorrect) {
            System.out.println("\n\nLeft not correct.");
            this.astErrorHandler.registerNewError( numerical,
                    "Left side of that expression not of type bool."
            );
        }
        if (!rightCorrect) {
            System.out.println("\n\nRight not correct. ");
            this.astErrorHandler.registerNewError( numerical,
                    "Left side of that expression not of type bool."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;

    }

    @Override
    public Object visitAdd(Add add) {
        return this.visitBinaryNumerical(add);
    }

    @Override
    public Object visitSub(Sub sub) {
        return this.visitBinaryNumerical(sub);
    }

    @Override
    public Object visitMul(Mul mul) {
        return this.visitBinaryNumerical(mul);
    }

    @Override
    public Object visitDiv(Div div) {
        return this.visitBinaryNumerical(div);
    }

    @Override
    public Object visitID(ID idLiteral) {
        System.out.println("So I am visiting an id:" + idLiteral.toString());
        return null;
    }

    @Override
    public Object visitINT(INT intLiteral) {
        System.out.println("So I am visiting an INT:" + intLiteral.toString());
        return null;
    }

    @Override
    public Object visitSTRING(STRING stringLiteral) {
        System.out.println("So I am visiting a string:" + stringLiteral.toString());
        return null;
    }

    @Override
    public Object visitBOOL(BOOL boolLiteral) {
        System.out.println("So I am visiting a bool:" + boolLiteral.toString());
        return null;
    }

    @Override
    public Object visitQuestion(Question question) {
        System.out.println("Visting question: " + question.toString());

        Type type = question.getType();
        ID identifier = question.getIdentifier();

        type.accept(this);
        identifier.accept(this);

        return null;
    }

    @Override
    public Object visitIfStatement(IfStatement ifStatement) {
        System.out.println("Visting ifStatement: " + ifStatement.toString());
        Expression expression = ifStatement.getCondition();
        List<Statement> statementList = ifStatement.getBody();

        expression.accept(this);
        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Object visitComputedQuestion(ComputedQuestion assignQuest) {
        System.out.println("Visting computed question: " + assignQuest.toString());

        Type type = assignQuest.getType();
        ID identifier = assignQuest.getIdentifier();
        Expression computed = assignQuest.getComputedExpression();

        type.accept(this);
        identifier.accept(this);
        computed.accept(this);
        return null;
    }

    @Override
    public Void visitBoolType(BoolType boolType){return null;}
    @Override
    public Void visitIntType(IntType intType){return null;}
    @Override
    public Void visitStringType(StringType moneyType){return null;}
    @Override
    public Void visitUndefinedType(UndefinedType undefinedType){return null;}

    // operands of invalid type to operators

    private boolean checkIfInt(Expression expression) {
        return expression.getSupportedTypes().contains(new IntType().getClass());
    }

    private boolean checkIfBool(Expression expression) {
        return expression.getSupportedTypes().contains(new BoolType().getClass());
    }

    private boolean checkIfString(Expression expression) {
        return expression.getSupportedTypes().contains(new StringType().getClass());
    }



//    private boolean checkIfSameType(Expression leftExpression, Expression rightExpression) {
//
//        // supported types of both expressions must be equal
//        return true;
//    }

    public boolean isFormCorrect() {
        return !this.astErrorHandler.hasErrors();
    }


    public void displayFormWarningsAndErrors() {
        this.astErrorHandler.displayWarningsAndErrors();
        return;
    }
}
