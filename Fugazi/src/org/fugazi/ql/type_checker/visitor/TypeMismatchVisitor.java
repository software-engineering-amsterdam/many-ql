package org.fugazi.ql.type_checker.visitor;


import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.comparison.*;
import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.literal.INT;
import org.fugazi.ql.ast.expression.literal.STRING;
import org.fugazi.ql.ast.expression.logical.And;
import org.fugazi.ql.ast.expression.logical.Logical;
import org.fugazi.ql.ast.expression.logical.Or;
import org.fugazi.ql.ast.expression.numerical.*;
import org.fugazi.ql.ast.expression.unary.Negative;
import org.fugazi.ql.ast.expression.unary.Not;
import org.fugazi.ql.ast.expression.unary.Positive;
import org.fugazi.ql.ast.expression.unary.Unary;
import org.fugazi.ql.ast.form.form_data.visitor.FullFormVisitor;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;

import java.util.List;

public class TypeMismatchVisitor extends FullFormVisitor {

    private final ASTIssueHandler astIssueHandler;

    public TypeMismatchVisitor() {
        super();
        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =======================
     * Binary visitors
     * =======================
     */

    /*
       This checks if both sides of the binary logical expression are of required type bool.
    */
    private Void visitBinaryLogical(Logical logical) {
        Expression left = logical.getLeft();
        Expression right = logical.getRight();

        boolean leftCorrect = this.checkIfExpressionIsBool(left);
        boolean rightCorrect = this.checkIfExpressionIsBool(right);

        if (!leftCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, logical,
                    "Left side of the binary logical expression not of type bool."
            );
        }
        if (!rightCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, logical,
                    "Right side of the binary logical expression not of type bool."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;
    }

    /*
       This checks if unary expression is of required type bool.
    */
    private Void visitUnaryLogical(Unary unary) {
        Expression expr = unary.getExpr();

        boolean exprCorrect = this.checkIfExpressionIsBool(unary);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, unary,
                    "Unary logical expression not of type bool."
            );
        }
        expr.accept(this);
        return null;
    }

    /*
       This checks if both sides of the logical comparison are of required type.
    */
    private Void visitBinaryComparison(Comparison comparison, List<Type> expectedTypes) {
        Expression left = comparison.getLeft();
        Expression right = comparison.getRight();

        // both sides need to be of same supported type
        // in order for the expression to be correct
        boolean differentTypes = false;
        boolean unsupportedTypes = false;

        if (!expectedTypes.contains(left.getReturnedType())
                || !expectedTypes.contains(right.getReturnedType())) {
            unsupportedTypes = true;
        }
        if (!left.getReturnedType().equals(right.getReturnedType())) {
            differentTypes = true;
        }

        if (unsupportedTypes) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, comparison,
                    "Side(s) of the binary comparison not of supported type(s): "
                            + expectedTypes.toString() + ". " + "Instead received types: "
                            + left.getReturnedType() + " and " + right.getReturnedType() + "."
            );
        } else if (differentTypes) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, comparison,
                    "Two sides of the binary comparison expression of different types: "
                            + left.getReturnedType() + " and " + right.getReturnedType() + "."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Void visitAnd(And and) {
        return this.visitBinaryLogical(and);
    }

    @Override
    public Void visitOr(Or or) {
        return this.visitBinaryLogical(or);
    }

    @Override
    public Void visitNot(Not not) {
        return this.visitUnaryLogical(not);
    }

    @Override
    public Void visitEQ(EQ eq) {
        return this.visitBinaryComparison(eq, eq.getSupportedTypes());
    }

    @Override
    public Void visitGE(GE ge) {
        return this.visitBinaryComparison(ge, ge.getSupportedTypes());
    }

    @Override
    public Void visitGreater(Greater greater) {
        return this.visitBinaryComparison(greater, greater.getSupportedTypes());
    }

    @Override
    public Void visitLE(LE le) {
        return this.visitBinaryComparison(le, le.getSupportedTypes());
    }

    @Override
    public Void visitLesser(Less less) {
        return this.visitBinaryComparison(less, less.getSupportedTypes());
    }

    @Override
    public Void visitNotEq(NotEq notEq) {
        return this.visitBinaryComparison(notEq, notEq.getSupportedTypes());
    }

    /**
     * =======================
     * Numerical visitors
     * =======================
     */

    /*
       This checks if both sides of the binary numerical comparison are of required type int.
    */
    private Void visitBinaryNumerical(Numerical numerical) {
        Expression left = numerical.getLeft();
        Expression right = numerical.getRight();

        boolean leftCorrect = this.checkIfExpressionIsInt(left);
        boolean rightCorrect = this.checkIfExpressionIsInt(right);

        if (!leftCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, numerical,
                    "Left side of the binary expression not of type int."
            );
        }
        if (!rightCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, numerical,
                    "Right side of the binary expression not of type int."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;

    }

    /*
       This checks if the unary numerical expression is of required type int.
    */
    private Void visitUnaryNumerical(Unary unary) {
        // Both sides of the expressions need to be of type boolean.
        Expression expr = unary.getExpr();

        boolean exprCorrect = this.checkIfExpressionIsInt(unary);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, unary,
                    "Unary numerical expression not of type int."
            );
        }
        expr.accept(this);
        return null;
    }

    @Override
    public Void visitNegative(Negative negative) {
        return this.visitUnaryNumerical(negative);
    }

    @Override
    public Void visitPositive(Positive positive) {
        return this.visitUnaryNumerical(positive);
    }

    @Override
    public Void visitAdd(Add add) {
        return this.visitBinaryNumerical(add);
    }

    @Override
    public Void visitSub(Sub sub) {
        return this.visitBinaryNumerical(sub);
    }

    @Override
    public Void visitMul(Mul mul) {
        return this.visitBinaryNumerical(mul);
    }

    @Override
    public Void visitDiv(Div div) {
        return this.visitBinaryNumerical(div);
    }



    /**
     * =======================
     * Literal visitors
     * =======================
     */

    @Override
    public Void visitINT(INT intLiteral) {

        boolean exprCorrect = this.checkIfExpressionIsInt(intLiteral);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, intLiteral,
                    "Int Literal not of type int."
            );
        }
        return null;
    }

    @Override
    public Void visitSTRING(STRING stringLiteral) {
        boolean exprCorrect = this.checkIfExpressionIsString(stringLiteral);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, stringLiteral,
                    "String Literal not of type string."
            );
        }
        return null;
    }

    @Override
    public Void visitBOOL(BOOL boolLiteral) {
        boolean exprCorrect = this.checkIfExpressionIsBool(boolLiteral);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, boolLiteral,
                    "Bool Literal not of type bool."
            );
        }
        return null;
    }



    /**
     * =======================
     * Internal check methods
     * =======================
     */

    private boolean checkIfExpressionIsBool(Expression expression) {
        return this.checkIfExpressionIsOfType(expression, new BoolType());
    }

    private boolean checkIfExpressionIsInt(Expression expression) {
        return this.checkIfExpressionIsOfType(expression, new IntType());
    }

    private boolean checkIfExpressionIsString(Expression expression) {
        return this.checkIfExpressionIsOfType(expression, new StringType());
    }

    private boolean checkIfExpressionIsOfType(Expression expression, Type type) {
        return this.checkIfTypesEqual(expression.getReturnedType(), type);
    }

    private boolean checkIfTypesEqual(Type type1, Type type2) {
        return type1.equals(type2);
    }

    /**
     * =======================
     * Exposed general form functions
     * =======================
     */

    public List<ASTNodeIssue> getErrors() {
        return this.astIssueHandler.getErrors();
    }
}