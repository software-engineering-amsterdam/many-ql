package org.fugazi.type_checker;


import org.fugazi.ast.expression.comparison.*;
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
import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.literal.ID;
import org.fugazi.ast.literal.NUMBER;
import org.fugazi.ast.literal.STRING;
import org.fugazi.ast.statement.ComputedQuestionStatement;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.QuestionStatement;
import org.fugazi.ast.type.*;

public class TypeCheckerVisitor implements IASTVisitor<Void>{

    public Void visitForm(Form form) {return null;}

    /**
     * ==============
     * Expressions
     * ==============
     */
    // Logical
    public Void visitAndExpression(And andExpression) {return null;}
    public Void visitOrExpression(Or lessExpression) {return null;}

    // Unary
    public Void visitNotExpression(Not not){return null;}
    public Void visitNegExpression(Negative negative){return null;}
    public Void visitPosExpression(Positive notExpression){return null;}

    // Comparison
    public Void visitEQExpression(EQ eqExpression){return null;}
    public Void visitGEExpression(GE geExpression){return null;}
    public Void visitGreaterExpression(Greater greaterExpression){return null;}
    public Void visitLEExpression(LE leExpression){return null;}
    public Void visitLessExpression(Less lessExpression){return null;}
    public Void visitNotEqExpression(NotEq notEqExpression){return null;}

    // Numerical
    public Void visitAddExpression(Add addExpression){return null;}
    public Void visitSubExpression(Sub subExpression){return null;}
    public Void visitMulExpression(Mul mulExpression){return null;}
    public Void visitDivExpression(Div divExpression){return null;}

    /**
     * ==============
     * Statements
     * ==============
     */
    public Void visitQuestionStatement(QuestionStatement questionStatement){return null;}
    public Void visitIfStatement(IfStatement ifStatement){return null;}
    public Void visitComputedQuestionStatement(ComputedQuestionStatement assignQuestStatement){return null;}

    /**
     * ==============
     * literals
     * ==============
     */
    public Void visitID(ID idLiteral){return null;}
    public Void visitSTRING(STRING stringLiteral){return null;}
    public Void visitNUMBER(NUMBER numberLiteral){return null;}

    /**
     * ==============
     * Types
     * ==============
     */
    public Void visitBoolType(BoolType boolType){return null;}
    public Void visitIntType(IntType intType){return null;}
    public Void visitMoneyType(MoneyType moneyType){return null;}
    public Void visitStringType(StringType moneyType){return null;}
    public Void visitUndefinedType(UndefinedType undefinedType){return null;}
}
