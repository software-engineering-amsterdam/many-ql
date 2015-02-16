package org.fugazi.type_checker;


import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.logical.AndExpression;
import org.fugazi.ast.expression.logical.OrExpression;
import org.fugazi.ast.expression.numerical.AddExpression;
import org.fugazi.ast.expression.numerical.DivExpression;
import org.fugazi.ast.expression.numerical.MulExpression;
import org.fugazi.ast.expression.numerical.SubExpression;
import org.fugazi.ast.expression.unary.NegExpression;
import org.fugazi.ast.expression.unary.NotExpression;
import org.fugazi.ast.expression.unary.PosExpression;
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
    public Void visitAndExpression(AndExpression andExpression) {return null;}
    public Void visitOrExpression(OrExpression lessExpression) {return null;}

    // Unary
    public Void visitNotExpression(NotExpression notExpression){return null;}
    public Void visitNegExpression(NegExpression negExpression){return null;}
    public Void visitPosExpression(PosExpression notExpression){return null;}

    // Comparison
    public Void visitEQExpression(EQExpression eqExpression){return null;}
    public Void visitGEExpression(GEExpression geExpression){return null;}
    public Void visitGreaterExpression(GreaterExpression greaterExpression){return null;}
    public Void visitLEExpression(LEExpression leExpression){return null;}
    public Void visitLessExpression(LessExpression lessExpression){return null;}
    public Void visitNotEqExpression(NotEqExpression notEqExpression){return null;}

    // Numerical
    public Void visitAddExpression(AddExpression addExpression){return null;}
    public Void visitSubExpression(SubExpression subExpression){return null;}
    public Void visitMulExpression(MulExpression mulExpression){return null;}
    public Void visitDivExpression(DivExpression divExpression){return null;}

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
