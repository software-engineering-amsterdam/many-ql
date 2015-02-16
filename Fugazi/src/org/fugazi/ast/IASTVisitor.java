package org.fugazi.ast;

import org.fugazi.ast.Form.Form;
import org.fugazi.ast.Expression.comparison.*;
import org.fugazi.ast.Expression.logical.*;
import org.fugazi.ast.Expression.numerical.*;
import org.fugazi.ast.Expression.unary.*;
import org.fugazi.ast.Literals.*;
import org.fugazi.ast.Statement.*;
import org.fugazi.ast.Type.*;

public interface IASTVisitor<T> {

    public T visitForm(Form form);
    
    /**
     * ============== 
     * Expressions
     * ==============
     */
    // Logical
    public T visitAndExpression(AndExpression andExpression);
    public T visitOrExpression(OrExpression lessExpression);

    // Unary
    public T visitNotExpression(NotExpression notExpression);
    public T visitNegExpression(NegExpression negExpression);
    public T visitPosExpression(PosExpression notExpression);

    // Comparison
    public T visitEQExpression(EQExpression eqExpression);
    public T visitGEExpression(GEExpression geExpression);
    public T visitGreaterExpression(GreaterExpression greaterExpression);
    public T visitLEExpression(LEExpression leExpression);
    public T visitLessExpression(LessExpression lessExpression);
    public T visitNotEqExpression(NotEqExpression notEqExpression);

    // Numerical
    public T visitAddExpression(AddExpression addExpression);
    public T visitSubExpression(SubExpression subExpression);
    public T visitMulExpression(MulExpression mulExpression);
    public T visitDivExpression(DivExpression divExpression);

    /**
     * ==============
     * Statements
     * ==============
     */
    public T visitQuestionStatement(QuestionStatement questionStatement);
    public T visitIfStatement(IfStatement ifStatement);
    public T visitComputedQuestionStatement(ComputedQuestionStatement assignQuestStatement);

    /**
     * ==============
     * Literals
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
