package org.fugazi.type_checker;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.comparison.*;
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

import java.util.List;

public class TypeCheckerVisitor implements IASTVisitor {

    /**
     * ==============
     * Types
     * ==============
     */
    public Void visitBoolType(BoolType boolType){return null;}
    public Void visitIntType(IntType intType){return null;}
    public Void visitStringType(StringType moneyType){return null;}
    public Void visitUndefinedType(UndefinedType undefinedType){return null;}

    @Override
    public Object visitForm(Form form) {
        System.out.println("Visiting a form: " + form.getName());
//        form.accept(this);

        List<Statement> statementList = form.getBody();

        for (Statement statement : statementList) {

            System.out.println("Visting a statement: " + statement.toString());
        }
        return null;
    }

    @Override
    public Object visitAnd(And and) {
        System.out.println("So I am visiting an and:" + and);
        return null;
    }

    @Override
    public Object visitOr(Or or) {
        System.out.println("So I am visiting an or:" + or);
        return null;
    }

    @Override
    public Object visitNot(Not not) {
        return null;
    }

    @Override
    public Object visitNegative(Negative negative) {
        return null;
    }

    @Override
    public Object visitPositive(Positive positive) {
        return null;
    }

    @Override
    public Object visitEQ(EQ eq) {
        return null;
    }

    @Override
    public Object visitGE(GE ge) {
        return null;
    }

    @Override
    public Object visitGreater(Greater greater) {
        return null;
    }

    @Override
    public Object visitLE(LE le) {
        return null;
    }

    @Override
    public Object visitLesser(Less less) {
        return null;
    }

    @Override
    public Object visitNotEq(NotEq notEq) {
        return null;
    }

    @Override
    public Object visitAdd(Add add) {
        return null;
    }

    @Override
    public Object visitSub(Sub sub) {
        return null;
    }

    @Override
    public Object visitMul(Mul mul) {
        return null;
    }

    @Override
    public Object visitDiv(Div div) {
        return null;
    }

    @Override
    public Object visitID(ID id) {
        return null;
    }

    @Override
    public Object visitINT(INT INT) {
        return null;
    }

    @Override
    public Object visitSTRING(STRING string) {
        return null;
    }

    @Override
    public Object visitQuestion(Question question) {
        return null;
    }

    @Override
    public Object visitIfStatement(IfStatement ifStatement) {
        return null;
    }

    @Override
    public Object visitComputedQuestion(ComputedQuestion assignQuest) {
        return null;
    }

    // operands of invalid type to operators
}
