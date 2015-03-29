package org.fugazi.ql.ast.form.form_data.visitor;

import org.fugazi.ql.ast.IASTVisitor;
import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.comparison.*;
import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.expression.literal.INT;
import org.fugazi.ql.ast.expression.literal.STRING;
import org.fugazi.ql.ast.expression.logical.And;
import org.fugazi.ql.ast.expression.logical.Or;
import org.fugazi.ql.ast.expression.numerical.Add;
import org.fugazi.ql.ast.expression.numerical.Div;
import org.fugazi.ql.ast.expression.numerical.Mul;
import org.fugazi.ql.ast.expression.numerical.Sub;
import org.fugazi.ql.ast.expression.unary.Negative;
import org.fugazi.ql.ast.expression.unary.Not;
import org.fugazi.ql.ast.expression.unary.Positive;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.statement.Statement;
import org.fugazi.ql.ast.type.*;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;

import java.util.List;

/*
 This class performs a full AST Tree traversal.
 Class can inherit and override methods where they
 need to perform additional actions.
 */

public abstract class FullQLFormVisitor implements IASTVisitor<Void> {
    protected final ASTIssueHandler astIssueHandler;
    protected final QLFormDataStorage formData;

    public FullQLFormVisitor(QLFormDataStorage _formData){
        this.formData = _formData;
        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =======================
     * General visitors
     * =======================
     */

    @Override
    public Void visitForm(Form form) {
        List<Statement> statementList = form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visitQuestion(Question question) {

        Type type = question.getType();
        ID identifier = question.getIdentifier();

        type.accept(this);
        identifier.accept(this);
        return null;
    }

    @Override
    public Void visitIfStatement(IfStatement ifStatement) {
        Expression expression = ifStatement.getCondition();
        List<Statement> statementList = ifStatement.getBody();

        expression.accept(this);
        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visitComputedQuestion(ComputedQuestion assignQuest) {
        Expression computed = assignQuest.getComputedExpression();
        computed.accept(this);
        return null;
    }

    /**
     * =======================
     * Binary visitors
     * =======================
     */

    @Override
    public Void visitAnd(And and) {
        return null;
    }

    @Override
    public Void visitOr(Or or) {
        return null;
    }

    @Override
    public Void visitNot(Not not) {
        return null;
    }

    @Override
    public Void visitEQ(EQ eq) {
        return null;
    }

    @Override
    public Void visitGE(GE ge) {
        return null;
    }

    @Override
    public Void visitGreater(Greater greater) {
        return null;
    }

    @Override
    public Void visitLE(LE le) {
        return null;
    }

    @Override
    public Void visitLesser(Less less) {
        return null;
    }

    @Override
    public Void visitNotEq(NotEq notEq) {
        return null;
    }

    /**
     * =======================
     * Numerical visitors
     * =======================
     */

    @Override
    public Void visitNegative(Negative negative) {
        return null;
    }

    @Override
    public Void visitPositive(Positive positive) {
        return null;
    }

    @Override
    public Void visitAdd(Add add) {
        return null;
    }

    @Override
    public Void visitSub(Sub sub) {
        return null;
    }

    @Override
    public Void visitMul(Mul mul) {
        return null;
    }

    @Override
    public Void visitDiv(Div div) {
        return null;
    }

    /**
     * =======================
     * Literal visitors
     * =======================
     */

    @Override
    public Void visitID(ID idLiteral) {
        return null;
    }

    @Override
    public Void visitINT(INT intLiteral) {
        return null;
    }

    @Override
    public Void visitSTRING(STRING stringLiteral) {
        return null;
    }

    @Override
    public Void visitBOOL(BOOL boolLiteral) {
        return null;
    }

    /**
     * =======================
     * Type visitors
     * =======================
     */

    @Override
    public Void visitBoolType(BoolType boolType) {
        return null;
    }
    
    @Override
    public Void visitIntType(IntType intType) {
        return null;
    }
    
    @Override
    public Void visitStringType(StringType stringType) {
        return null;
    }

    @Override
    public Void visitUndefinedType(UndefinedType undefinedType) {
        return null;
    }

    /**
     * =======================
     * Error handling
     * =======================
     */

    public List<ASTNodeIssue> getErrors() {
        return this.astIssueHandler.getErrors();
    }
    
    public List<ASTNodeIssue> getWarnings() {
        return this.astIssueHandler.getWarnings();
    }
    
    public boolean hasErrors() {
        return this.astIssueHandler.hasErrors();
    }
    
    public boolean hasWarnings() {
        return this.astIssueHandler.hasWarnings();
    }
    
    public void clearErrorsAndWarnings() { 
        this.astIssueHandler.clearErrorsAndWarnings(); 
    }
}
