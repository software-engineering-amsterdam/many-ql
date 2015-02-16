package org.fugazi.ast;

import org.fugazi.ast.form.Form;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.logical.*;
import org.fugazi.ast.expression.numerical.*;
import org.fugazi.ast.expression.unary.*;
import org.fugazi.ast.literal.*;
import org.fugazi.ast.statement.*;
import org.fugazi.ast.type.*;

public interface IASTVisitor<T> {

    public T visitForm(Form form);
    
    /**
     * ============== 
     * Expressions
     * ==============
     */
    // Logical
    public T visitAndExpression(And andExpression);
    public T visitOrExpression(Or lessExpression);

    // Unary
    public T visitNotExpression(Not not);
    public T visitNegExpression(Negative negative);
    public T visitPosExpression(Positive positive);

    // Comparison
    public T visitEQExpression(EQ eqExpression);
    public T visitGEExpression(GE geExpression);
    public T visitGreaterExpression(Greater greaterExpression);
    public T visitLEExpression(LE leExpression);
    public T visitLessExpression(Less lessExpression);
    public T visitNotEqExpression(NotEq notEqExpression);

    // Numerical
    public T visitAddExpression(Add addExpression);
    public T visitSubExpression(Sub subExpression);
    public T visitMulExpression(Mul mulExpression);
    public T visitDivExpression(Div divExpression);

    /**
     * ==============
     * Statements
     * ==============
     */
    public T visitQuestionStatement(Question question);
    public T visitIfStatement(IfStatement ifStatement);
    public T visitComputedQuestionStatement(ComputedQuestion assignQuestStatement);

    /**
     * ==============
     * literals
     * ==============
     */
    public T visitID(ID idLiteral);
    public T visitSTRING(STRING stringLiteral);
    public T visitNUMBER(NUMBER numberLiteral);

    /**
     * ==============
     * Types
     * ==============
     */
    public T visitBoolType(BoolType boolType);
    public T visitIntType(IntType intType);
    public T visitMoneyType(MoneyType moneyType);
    public T visitStringType(StringType moneyType);
    public T visitUndefinedType(UndefinedType undefinedType);
}
