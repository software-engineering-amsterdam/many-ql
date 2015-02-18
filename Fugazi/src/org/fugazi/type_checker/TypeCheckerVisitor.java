package org.fugazi.type_checker;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.BOOL;
import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.expression.literal.INT;
import org.fugazi.ast.expression.literal.STRING;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.Add;
import org.fugazi.ast.expression.numerical.Div;
import org.fugazi.ast.expression.numerical.Mul;
import org.fugazi.ast.expression.numerical.Sub;
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

- every numerical must have ints
  - add div mul sub
- every logical must have bool
  - or and not

- negative must have int
necessary functions:
 - check if string
 - check if int
 - check if bool
 - check if of same type

 */

import java.util.List;

public class TypeCheckerVisitor implements IASTVisitor {

    @Override
    public Object visitForm(Form form) {
        System.out.println("\n\n\nVisiting a form: " + form.getName());

        List<Statement> statementList = form.getBody();

        for (Statement statement : statementList) {

            System.out.println("Visting a statement: " + statement.toString());
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Object visitAnd(And and) {
        System.out.println("So I am visiting an and:" + and.toString());
        Expression left = and.getLeft();
        Expression right = and.getRight();

        boolean leftCorrect = this.checkIfInt(left);

        System.out.println("\n\nLeft correct: " + leftCorrect);

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitOr(Or or) {
        System.out.println("So I am visiting an or:" + or.toString());

        Expression left = or.getLeft();
        Expression right = or.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitNot(Not not) {

        System.out.println("So I am visiting a not:" + not.toString());

        Expression expression = not.getExpr();

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

    @Override
    public Object visitEQ(EQ eq) {
        System.out.println("So I am visiting an eq:" + eq.toString());
        Expression left = eq.getLeft();
        Expression right = eq.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitGE(GE ge) {

        System.out.println("So I am visiting a ge:" + ge.toString());
        Expression left = ge.getLeft();
        Expression right = ge.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitGreater(Greater greater) {

        System.out.println("So I am visiting a ge:" + greater.toString());
        Expression left = greater.getLeft();
        Expression right = greater.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitLE(LE le) {

        System.out.println("So I am visiting a le:" + le.toString());
        Expression left = le.getLeft();
        Expression right = le.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitLesser(Less less) {

        System.out.println("So I am visiting a less:" + less.toString());
        Expression left = less.getLeft();
        Expression right = less.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitNotEq(NotEq notEq) {

        System.out.println("So I am visiting a notEq:" + notEq.toString());
        Expression left = notEq.getLeft();
        Expression right = notEq.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitAdd(Add add) {

        System.out.println("So I am visiting an add:" + add.toString());
        Expression left = add.getLeft();
        Expression right = add.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitSub(Sub sub) {

        System.out.println("So I am visiting a sub:" + sub.toString());
        Expression left = sub.getLeft();
        Expression right = sub.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitMul(Mul mul) {

        System.out.println("So I am visiting a mul:" + mul.toString());
        Expression left = mul.getLeft();
        Expression right = mul.getRight();

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitDiv(Div div) {
        System.out.println("So I am visiting a div:" + div.toString());
        Expression left = div.getLeft();
        Expression right = div.getRight();

        left.accept(this);
        right.accept(this);
        return null;
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

        IntType intType = new IntType();
        System.out.println(intType.equals(new IntType()));
        for (Type type : expression.getSupportedTypes()) {
            if (type.getClass() == intType.getClass()) {
                return true;
            }
        }
        return false;

        // TODO naively thought this would work
        // maybe needs to be rethought
//        return expression.getSupportedTypes().contains(new IntType());
    }

    private boolean checkIfBool(Expression expression) {
        BoolType boolType = new BoolType();
        for (Type type : expression.getSupportedTypes()) {
            if (type.getClass() == boolType.getClass()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfString(Expression expression) {
        StringType stringType = new StringType();
        for (Type type : expression.getSupportedTypes()) {
            if (type.getClass() == stringType.getClass()) {
                return true;
            }
        }
        return false;
    }

//    private boolean checkIfSameType(Expression leftExpression, Expression rightExpression) {
//
//        // supported types of both expressions must be equal
//        return true;
//    }
}
